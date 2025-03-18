class FlightModel {
  final String airline;
  final String departure;
  final String arrival;
  final String price;

  FlightModel({
    required this.airline,
    required this.departure,
    required this.arrival,
    required this.price,
  });

  factory FlightModel.fromJson(Map<String, dynamic> json) {
    return FlightModel(
      airline: json['itineraries'][0]['segments'][0]['carrierCode'],
      departure: json['itineraries'][0]['segments'][0]['departure']['at'],
      arrival: json['itineraries'][0]['segments'][0]['arrival']['at'],
      price: json['price']['total'],
    );
  }
}
