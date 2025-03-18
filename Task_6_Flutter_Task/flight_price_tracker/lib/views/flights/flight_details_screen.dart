import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:intl/intl.dart';
import 'package:easy_localization/easy_localization.dart';

class FlightDetailsScreen extends StatelessWidget {
  final Map<String, dynamic> flight;
  final Map<String, String> airportNames;

  const FlightDetailsScreen({
    required this.flight,
    required this.airportNames,
    Key? key,
  }) : super(key: key);

  Future<void> saveFlight(BuildContext context) async {
    try {
      var itinerary =
          (flight['itineraries'] as List?)?.first?['segments'] as List?;
      if (itinerary == null || itinerary.isEmpty) {
        ScaffoldMessenger.of(
          context,
        ).showSnackBar(SnackBar(content: Text("invalid_flight".tr())));
        return;
      }

      var segment = itinerary.first;
      String origin = segment['departure']['iataCode'] ?? 'unknown'.tr();
      String destination = segment['arrival']['iataCode'] ?? 'unknown'.tr();
      String departureTime = segment['departure']['at'] ?? '';
      String arrivalTime = segment['arrival']['at'] ?? '';
      String price = flight['price']?['total'] ?? '0.0';
      String carrier = segment['carrierCode'] ?? 'unknown'.tr();
      String flightNumber = segment['number'] ?? 'N/A';
      String baggage = flight['baggage'] ?? "Not Provided";
      String cancellationPolicy =
          flight['cancellationPolicy'] ?? "Not Available";

      await FirebaseFirestore.instance.collection('savedFlights').add({
        'origin': origin,
        'destination': destination,
        'originAirport': airportNames[origin] ?? origin,
        'destinationAirport': airportNames[destination] ?? destination,
        'departureTime': departureTime,
        'arrivalTime': arrivalTime,
        'flightDuration': calculateDuration(departureTime, arrivalTime),
        'price': price,
        'carrier': carrier,
        'flightNumber': flightNumber,
        'baggage': baggage,
        'cancellationPolicy': cancellationPolicy,
      });

      ScaffoldMessenger.of(
        context,
      ).showSnackBar(SnackBar(content: Text("flight_saved".tr())));
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text("flight_save_failed".tr(args: [e.toString()]))),
      );
    }
  }

  String calculateDuration(String departureTime, String arrivalTime) {
    try {
      DateTime depTime = DateTime.parse(departureTime);
      DateTime arrTime = DateTime.parse(arrivalTime);
      Duration duration = arrTime.difference(depTime);
      return "${duration.inHours}h ${duration.inMinutes % 60}m";
    } catch (e) {
      return "unknown_flight".tr();
    }
  }

  @override
  Widget build(BuildContext context) {
    var itinerary =
        (flight['itineraries'] as List?)?.first?['segments'] as List?;
    if (itinerary == null || itinerary.isEmpty) {
      return Scaffold(
        appBar: AppBar(title: Text("flight_details".tr())),
        body: Center(child: Text("no_flight_details".tr())),
      );
    }

    var segment = itinerary.first;
    String origin = segment['departure']['iataCode'] ?? 'unknown'.tr();
    String destination = segment['arrival']['iataCode'] ?? 'unknown'.tr();
    String departureTime = segment['departure']['at'] ?? '';
    String arrivalTime = segment['arrival']['at'] ?? '';
    String price = flight['price']?['total'] ?? '0.0';
    String baggage = flight['baggage'] ?? "not_provided".tr();
    String cancellationPolicy = flight['cancellationPolicy'] ?? "not_available".tr();

    return Scaffold(
      appBar: AppBar(
        title: Text("flight_details".tr()),
        backgroundColor: Colors.blueAccent,
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Card(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(16),
          ),
          elevation: 5,
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Center(
                  child: Column(
                    children: [
                      Text(
                        "${airportNames[origin] ?? origin} → ${airportNames[destination] ?? destination}",
                        style: const TextStyle(
                          fontSize: 20,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      const SizedBox(height: 8),
                      Text(
                        "${"flight_label".tr()} ${segment['carrierCode']} ${segment['number']}",
                        style: const TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.bold,
                          color: Colors.blueGrey,
                        ),
                      ),
                    ],
                  ),
                ),
                const SizedBox(height: 16),
                ListTile(
                  leading: Icon(Icons.flight_takeoff, color: Colors.green),
                  title: Text(
                    "departure_label".tr(),
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  subtitle: Text(
                    departureTime.isNotEmpty
                        ? DateFormat(
                          "MMM d, yyyy - h:mm a",
                        ).format(DateTime.parse(departureTime))
                        : "unknown".tr(),
                  ),
                ),
                ListTile(
                  leading: Icon(Icons.flight_land, color: Colors.red),
                  title: Text(
                    "arrival_label".tr(),
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  subtitle: Text(
                    arrivalTime.isNotEmpty
                        ? DateFormat(
                          "MMM d, yyyy - h:mm a",
                        ).format(DateTime.parse(arrivalTime))
                        : "unknown".tr(),
                  ),
                ),
                const SizedBox(height: 16),
                ListTile(
                  leading: Icon(Icons.timer, color: Colors.blueAccent),
                  title: Text(
                    "duration_label".tr(),
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  subtitle: Text(
                    "${calculateDuration(departureTime, arrivalTime)}",
                  ),
                ),
                ListTile(
                  leading: Icon(Icons.luggage, color: Colors.orange),
                  title: Text(
                    "baggage".tr(),
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  subtitle: Text(baggage),
                ),
                ListTile(
                  leading: Icon(Icons.info_outline, color: Colors.red),
                  title: Text(
                    "cancellation_policy".tr(),
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                  subtitle: Text(cancellationPolicy),
                ),
                const SizedBox(height: 16),
                Center(
                  child: Text(
                    "${"flight_price".tr()} ₹$price",
                    style: const TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.bold,
                      color: Colors.green,
                    ),
                  ),
                ),
                const SizedBox(height: 16),
                Center(
                  child: ElevatedButton.icon(
                    onPressed: () => saveFlight(context),
                    icon: const Icon(Icons.bookmark_add),
                    label: Text("save_flight".tr()),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: const Color.fromARGB(255, 180, 216, 246),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
