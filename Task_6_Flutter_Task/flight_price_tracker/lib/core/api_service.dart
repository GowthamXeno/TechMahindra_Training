import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:intl/intl.dart';

class ApiService {
  final String apiKey =
      "qwpzEIDTJCcH1gTJGvPWS3hsCvhdE03r";
  final String apiSecret = "LaitxT7WTQQ54wBC";
  final String authUrl =
      "https://test.api.amadeus.com/v1/security/oauth2/token";
  final String flightUrl =
      "https://test.api.amadeus.com/v2/shopping/flight-offers";

  String? accessToken;


  Future<void> getAccessToken() async {
    if (accessToken != null) return; 

    try {
      final response = await http.post(
        Uri.parse(authUrl),
        headers: {"Content-Type": "application/x-www-form-urlencoded"},
        body: {
          "grant_type": "client_credentials",
          "client_id": apiKey,
          "client_secret": apiSecret,
        },
      );

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        accessToken = data["access_token"];
        print("✅ Access Token Fetched");
      } else {
        throw Exception(
          "🔴 Token Fetch Failed: ${response.statusCode} ${response.body}",
        );
      }
    } catch (e) {
      print("🔴 Exception in getAccessToken: $e");
      throw Exception("Failed to get access token");
    }
  }


  Future<List<dynamic>> fetchAllFlights() async {
    try {
      await getAccessToken();

      String departureDate = DateFormat(
        'yyyy-MM-dd',
      ).format(DateTime.now());
      print(departureDate);
      final Uri url = Uri.parse(
        "$flightUrl?"
        "originLocationCode=DEL&"
        "destinationLocationCode=NYC&"
        "departureDate=$departureDate&" 
        "adults=1&"
        "currencyCode=INR",
      );

      final response = await http.get(
        url,
        headers: {
          "Authorization": "Bearer $accessToken",
          "Content-Type": "application/json",
        },
      );

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        print("✅ Flights Data Loaded: ${data['data']?.length ?? 0} offers");
        return data['data'] ?? [];
      } else {
        throw Exception(
          "🔴 API Error ${response.statusCode}: ${response.body}",
        );
      }
    } catch (e) {
      print("🔴 Exception in fetchAllFlights: $e");
      return [];
    }
  }


  List<String> extractLocations(List<dynamic> flights) {
    Set<String> locations = {};

    for (var flight in flights) {
      locations.add(
        flight['itineraries'][0]['segments'][0]['departure']['iataCode'],
      );
      locations.add(
        flight['itineraries'][0]['segments'][0]['arrival']['iataCode'],
      );
    }

    print("✅ Unique Locations Extracted: ${locations.length}");
    return locations.toList();
  }


  List<dynamic> filterFlights(
    List<dynamic> allFlights,
    String? from,
    String? to,
  ) {
    return allFlights.where((flight) {
      String origin =
          flight['itineraries'][0]['segments'][0]['departure']['iataCode'];
      String destination =
          flight['itineraries'][0]['segments'][0]['arrival']['iataCode'];

      bool matchesFrom = from == null || from.isEmpty || origin == from;
      bool matchesTo = to == null || to.isEmpty || destination == to;

      return matchesFrom && matchesTo;
    }).toList();
  }

  Map<String, String> getAirportNames() {
Map<String, String> airportNames = {
  "DEL": "Delhi, India",
  "DOH": "Doha, Qatar",
  "LHR": "London, UK",
  "JFK": "New York, USA",
  "DXB": "Dubai, UAE",
  "SIN": "Singapore",
  "HKG": "Hong Kong",
  "CDG": "Paris, France",
  "SYD": "Sydney, Australia",
  "NRT": "Tokyo, Japan",
  "CMB": "Colombo, Sri Lanka",
  "AUH": "Abu Dhabi, UAE",
  "YUL": "Montreal, Canada",
  "YYZ": "Toronto, Canada",
  "HND": "Tokyo Haneda, Japan",
  "BOM": "Mumbai, India",
  "ICN": "Seoul, South Korea",
  "EWR": "Newark, USA",
  "FRA": "Frankfurt, Germany",
  "BLR": "Bangalore, India"
};

    return airportNames;
  }
}
