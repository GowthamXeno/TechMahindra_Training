import 'package:flutter/material.dart';
import '../db_helper.dart';
import 'add_edit_screen.dart';
import '../models/appointment.dart';
import './appointment_details_screen.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  List<Appointment> appointments = [];

  @override
  void initState() {
    super.initState();
    loadAppointments();
  }

  Future<void> loadAppointments() async {
    final data = await DatabaseHelper.getAppointments();
    setState(() {
      appointments = data.map((e) => Appointment.fromMap(e)).toList();
    });
  }

  Future<void> deleteAppointment(int id) async {
    await DatabaseHelper.deleteAppointment(id);
    loadAppointments();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Dental Appointments')),
      body: appointments.isEmpty
          ? Center(child: Text('No appointments yet.'))
          : ListView.builder(
              itemCount: appointments.length,
              itemBuilder: (context, index) {
                final appointment = appointments[index];
                return Card(
                  child: ListTile(
                    title: Text(appointment.name),
                    subtitle: Text("${appointment.date} at ${appointment.time}\nReason: ${appointment.reason}"),
                     onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => AppointmentDetailsScreen(appointment: appointment),
                        ),
                      );
                    },
                    trailing: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        IconButton(
                          icon: Icon(Icons.edit, color: Colors.blue),
                          onPressed: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) => AddEditScreen(appointment: appointment.toMap()),
                              ),
                            ).then((_) => loadAppointments());
                          },
                        ),
                        IconButton(
                          icon: Icon(Icons.delete, color: Colors.red),
                          onPressed: () => deleteAppointment(appointment.id!),
                        ),
                      ],
                    ),
                  ),
                );
              },
            ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => AddEditScreen(),
            ),
          ).then((_) => loadAppointments());
        },
      ),
    );
  }
}
