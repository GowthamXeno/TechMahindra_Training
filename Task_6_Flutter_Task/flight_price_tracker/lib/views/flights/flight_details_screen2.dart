import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:easy_localization/easy_localization.dart';

class FlightDetailsScreen2 extends StatelessWidget {
  final Map<String, dynamic> flight;
  final Map<String, String> airportNames;

  const FlightDetailsScreen2({
    required this.flight,
    required this.airportNames,
    Key? key,
  }) : super(key: key);


  String calculateDuration(String departureTime, String arrivalTime) {
    try {
      DateTime depTime = DateTime.parse(departureTime);
      DateTime arrTime = DateTime.parse(arrivalTime);
      Duration duration = arrTime.difference(depTime);
      return "${duration.inHours}h ${duration.inMinutes % 60}m";
    } catch (e) {
      return "unknown_duration".tr();
    }
  }

  @override
  Widget build(BuildContext context) {
    String origin = flight['originAirport'] ?? 'unknown'.tr();
    String destination = flight['destinationAirport'] ?? 'unknown'.tr();
    String departureTime = flight['departureTime'] ?? '';
    String arrivalTime = flight['arrivalTime'] ?? '';
    String price = flight['price'] ?? '0.0';
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
                        "${"flight_label".tr()} ${flight['flightNumber'] ?? 'N/A'}",
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
              ],
            ),
          ),
        ),
      ),
    );
  }
}
