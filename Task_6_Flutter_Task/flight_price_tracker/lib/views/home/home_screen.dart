import 'package:flutter/material.dart';
import 'package:easy_localization/easy_localization.dart';
import '../flights/flight_details_screen.dart';

class HomeScreen extends StatefulWidget {
  final List<dynamic> allFlights;
  final Map<String, String> airportNames;
  final VoidCallback onRefresh;

  HomeScreen({
    required this.allFlights,
    required this.airportNames,
    required this.onRefresh,
  });

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  List<dynamic> filteredFlights = [];
  String? selectedFrom;
  String? selectedTo;
  String? selectedDate;
  TextEditingController fromController = TextEditingController();
  TextEditingController toController = TextEditingController();
  TextEditingController dateController = TextEditingController();
  List<String> suggestions = [];

  @override
  void initState() {
    super.initState();
    filteredFlights = widget.allFlights;
    suggestions = widget.airportNames.values.toList();
  }

  void applyFilter() {
    setState(() {
      filteredFlights =
          widget.allFlights.where((flight) {
            if (flight['itineraries'] == null || flight['itineraries'].isEmpty)
              return false;
            if (flight['itineraries'][0]['segments'] == null ||
                flight['itineraries'][0]['segments'].isEmpty)
              return false;

            var itinerary = flight['itineraries'][0]['segments'][0];

            String? origin = itinerary['departure']?['iataCode'];
            String? destination = itinerary['arrival']?['iataCode'];

            if (origin == null || destination == null) return false;

            bool matchesFrom =
                selectedFrom == null ||
                selectedFrom!.isEmpty ||
                widget.airportNames[origin] == selectedFrom;
            bool matchesTo =
                selectedTo == null ||
                selectedTo!.isEmpty ||
                widget.airportNames[destination] == selectedTo;

            return matchesFrom && matchesTo;
          }).toList();
    });
  }

  Widget buildFloatingLabelAutocompleteField(
    TextEditingController controller,
    String label,
    Function(String) onSelected,
  ) {
    return Autocomplete<String>(
      optionsBuilder: (TextEditingValue textEditingValue) {
        if (textEditingValue.text.isEmpty) return [];
        return suggestions
            .where(
              (option) => option.toLowerCase().contains(
                textEditingValue.text.toLowerCase(),
              ),
            )
            .toList();
      },
      onSelected: onSelected,
      fieldViewBuilder: (
        context,
        textEditingController,
        focusNode,
        onFieldSubmitted,
      ) {
        return TextField(
          controller: textEditingController,
          focusNode: focusNode,
          decoration: InputDecoration(
            labelText: label.tr(),
            border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
            filled: true,
            fillColor: Colors.grey[200],
          ),
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          "app_title".tr(),
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
        backgroundColor: Colors.blueAccent,
        centerTitle: true,
        actions: [
          IconButton(icon: Icon(Icons.refresh), onPressed: widget.onRefresh),
        ],
      ),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          children: [
            Text(
              "filter_flight_offers".tr(),
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),
            Card(
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(12),
              ),
              elevation: 4,
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  children: [
                    Row(
                      children: [
                        Expanded(
                          child: buildFloatingLabelAutocompleteField(
                            fromController,
                            "from",
                            (value) {
                              setState(() {
                                selectedFrom = value;
                                applyFilter();
                              });
                            },
                          ),
                        ),
                        SizedBox(width: 10),
                        Expanded(
                          child: buildFloatingLabelAutocompleteField(
                            toController,
                            "to",
                            (value) {
                              setState(() {
                                selectedTo = value;
                                applyFilter();
                              });
                            },
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            ),
            SizedBox(height: 16),
            Expanded(
              child:
                  filteredFlights.isEmpty
                      ? Center(child: Text("no_flights".tr()))
                      : ListView.builder(
                        itemCount: filteredFlights.length,
                        itemBuilder: (context, index) {
                          var flight = filteredFlights[index];
                          if (flight['itineraries'] == null ||
                              flight['itineraries'].isEmpty)
                            return SizedBox();
                          var itinerary =
                              flight['itineraries'][0]['segments'][0];

                          String origin =
                              itinerary['departure']?['iataCode'] ?? "Unknown";
                          String destination =
                              itinerary['arrival']?['iataCode'] ?? "Unknown";
                          String departureDate =
                              itinerary['departure']?['at']?.split("T")[0] ??
                              "Unknown";
                          double price =
                              double.tryParse(
                                flight['price']?['total']?.toString() ?? "0.0",
                              ) ??
                              0.0;

                          return Card(
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(12),
                            ),
                            elevation: 3,
                            margin: EdgeInsets.symmetric(vertical: 8),
                            child: ListTile(
                              title: Text(
                                "${widget.airportNames[origin] ?? origin} → ${widget.airportNames[destination] ?? destination}",
                              ),
                              subtitle: Text(
                                "${'price_label'.tr()} : ₹${price.toStringAsFixed(2)}\t | ${'date'.tr()} : $departureDate",
                              ),
                              leading: Icon(
                                Icons.flight_takeoff,
                                color: Colors.blueAccent,
                              ),
                              onTap: () {
                                Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                    builder:
                                        (context) => FlightDetailsScreen(
                                          flight: flight,
                                          airportNames: widget.airportNames,
                                        ),
                                  ),
                                );
                              },
                            ),
                          );
                        },
                      ),
            ),
          ],
        ),
      ),
    );
  }
}
