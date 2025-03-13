import 'package:doctorappointment/models/appointment.dart';
import 'package:flutter/material.dart';
import '../db_helper.dart';

class AddEditScreen extends StatefulWidget {
  final Map<String, dynamic>? appointment;

  AddEditScreen({this.appointment});

  @override
  _AddEditScreenState createState() => _AddEditScreenState();
}

class _AddEditScreenState extends State<AddEditScreen> {
  final _formKey = GlobalKey<FormState>();
  TextEditingController _nameController = TextEditingController();
  TextEditingController _dateController = TextEditingController();
  TextEditingController _timeController = TextEditingController();
  TextEditingController _reasonController = TextEditingController();
  final List<String> doctors = ["Dr. Smith", "Dr. Johnson", "Dr. Williams"];
  String? selectedDoctor;
  @override
  void initState() {
    super.initState();
    if (widget.appointment != null) {
      _nameController.text = widget.appointment!['name'];
      _dateController.text = widget.appointment!['date'];
      _timeController.text = widget.appointment!['time'];
      _reasonController.text = widget.appointment!['reason'];
      selectedDoctor = widget.appointment!['doctor'];
    }
  }

  Future<void> saveAppointment() async {
    if (_formKey.currentState!.validate()) {
      final newAppointment = Appointment(
        id:
            widget.appointment != null
                ? widget.appointment!['id'] as int?
                : null,
        name: _nameController.text,
        date: _dateController.text,
        time: _timeController.text,
        reason: _reasonController.text,
        doctor: selectedDoctor ?? doctors.first,
      );

      if (widget.appointment == null) {
        await DatabaseHelper.insertAppointment(newAppointment.toMap());
      } else {
        await DatabaseHelper.updateAppointment(
          newAppointment.id!,
          newAppointment.toMap(),
        );
      }

      Navigator.pop(context, true);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          widget.appointment == null ? 'Add Appointment' : 'Edit Appointment',
        ),
      ),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                controller: _nameController,
                decoration: InputDecoration(labelText: 'Patient Name'),
                validator:
                    (value) => value!.isEmpty ? 'Enter patient name' : null,
              ),
              TextFormField(
                controller: _dateController,
                decoration: InputDecoration(labelText: 'Date'),
                onTap: () async {
                  DateTime? pickedDate = await showDatePicker(
                    context: context,
                    initialDate: DateTime.now(),
                    firstDate: DateTime.now(),
                    lastDate: DateTime(2101),
                  );
                  if (pickedDate != null) {
                    setState(() {
                      _dateController.text =
                          pickedDate.toLocal().toString().split(' ')[0];
                    });
                  }
                },
                readOnly: true,
                validator: (value) => value!.isEmpty ? 'Select a date' : null,
              ),
              TextFormField(
                controller: _timeController,
                decoration: InputDecoration(labelText: 'Time'),
                onTap: () async {
                  TimeOfDay? pickedTime = await showTimePicker(
                    context: context,
                    initialTime: TimeOfDay.now(),
                  );
                  if (pickedTime != null) {
                    setState(() {
                      _timeController.text = pickedTime.format(context);
                    });
                  }
                },
                readOnly: true,
                validator: (value) => value!.isEmpty ? 'Select a time' : null,
              ),
              TextFormField(
                controller: _reasonController,
                decoration: InputDecoration(labelText: 'Reason for Visit'),
                validator: (value) => value!.isEmpty ? 'Enter reason' : null,
              ),
              SizedBox(height: 20),
              DropdownButtonFormField<String>(
                decoration: InputDecoration(labelText: "Select Doctor"),
                value: selectedDoctor,
                items: doctors.map((doctor) {
                  return DropdownMenuItem(
                    value: doctor,
                    child: Text(doctor),
                  );
                }).toList(),
                onChanged: (value) {
                  setState(() {
                    selectedDoctor = value;
                  });
                },
                validator: (value) => value == null ? "Select a doctor" : null,
              ),
              SizedBox(height: 30),
              ElevatedButton(
                onPressed: saveAppointment,
                child: Text('Save Appointment'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
