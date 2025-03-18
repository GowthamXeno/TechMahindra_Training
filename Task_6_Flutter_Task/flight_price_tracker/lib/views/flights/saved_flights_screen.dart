import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:easy_localization/easy_localization.dart';
import 'flight_details_screen2.dart';

class SavedFlightsScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("saved_flights".tr()),
        backgroundColor: Colors.blueAccent,
        centerTitle: true,
      ),
      body: StreamBuilder<QuerySnapshot>(
        stream:
            FirebaseFirestore.instance.collection('savedFlights').snapshots(),
        builder: (context, snapshot) {
          if (!snapshot.hasData) {
            return const Center(child: CircularProgressIndicator());
          }

          var flights = snapshot.data!.docs;

          if (flights.isEmpty) {
            return Center(
              child: Text("no_saved_flights".tr()),
            ); // Localized text
          }

          return ListView.builder(
            itemCount: flights.length,
            itemBuilder: (context, index) {
              var flight = flights[index].data() as Map<String, dynamic>;

              return Card(
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(12),
                ),
                elevation: 3,
                margin: const EdgeInsets.all(8),
                child: ListTile(
                  title: Text(
                    "${flight['originAirport']} → ${flight['destinationAirport']}",
                    style: const TextStyle(fontWeight: FontWeight.bold),
                  ),
                  subtitle: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "${"flight_label".tr()} ${flight['carrier']} ${flight['flightNumber']}",
                      ),
                      Text(
                        "${"departure_label".tr()} ${flight['departureTime']}",
                      ),
                      Text("${"arrival_label".tr()} ${flight['arrivalTime']}"),
                      Text(
                        "${"duration_label".tr()} ${flight['flightDuration']}",
                      ),
                      Text(
                        "${"flight_price".tr()} ₹${flight['price']}",
                        style: const TextStyle(
                          fontWeight: FontWeight.bold,
                          color: Colors.green,
                        ),
                      ),
                    ],
                  ),
                  trailing: IconButton(
                    icon: const Icon(Icons.delete, color: Colors.red),
                    onPressed: () => flights[index].reference.delete(),
                  ),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder:
                            (context) => FlightDetailsScreen2(
                              flight: flight,
                              airportNames: {},
                            ),
                      ),
                    );
                  },
                ),
              );
            },
          );
        },
      ),
    );
  }
}
