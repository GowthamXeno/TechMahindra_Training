class Appointment {
  int? id;
  String name;
  String date;
  String time;
  String reason;

  Appointment({this.id, required this.name, required this.date, required this.time, required this.reason});

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'date': date,
      'time': time,
      'reason': reason,
    };
  }

  factory Appointment.fromMap(Map<String, dynamic> map) {
    return Appointment(
      id: map['id'],
      name: map['name'],
      date: map['date'],
      time: map['time'],
      reason: map['reason'],
    );
  }
}
