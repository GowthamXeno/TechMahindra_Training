import 'package:cloud_firestore/cloud_firestore.dart';

class FirebaseService {
  static final FirebaseFirestore _db = FirebaseFirestore.instance;

  // Save flight data to Firestore
  static Future<void> saveFlight(Map<String, dynamic> flightData) async {
    await _db.collection("saved_flights").add(flightData);
  }

  // Fetch saved flights
  static Stream<QuerySnapshot> getSavedFlights() {
    return _db.collection("saved_flights").snapshots();
  }
}
