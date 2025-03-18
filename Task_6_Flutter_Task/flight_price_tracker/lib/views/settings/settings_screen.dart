import 'package:flight_price_tracker/views/settings/about_screen.dart';
import 'package:flutter/material.dart';
import 'package:easy_localization/easy_localization.dart';

class SettingsScreen extends StatefulWidget {
  @override
  _SettingsScreenState createState() => _SettingsScreenState();
}

class _SettingsScreenState extends State<SettingsScreen> {
  final List<Locale> _supportedLocales = [
    Locale('en'), 
    Locale('es'),
    Locale('ta'),
    Locale('fr'), 
    Locale('de'), 
  ];

  final Map<String, String> _languageNames = {
    'en': 'English',
    'es': 'Español',
    'ta': 'தமிழ்',
    'fr': 'Français',
    'de': 'Deutsch',
  };

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('settings'.tr()),
        centerTitle: true,
        elevation: 0,
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                'change_language'.tr(),
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                  color: Theme.of(context).primaryColor,
                ),
              ),
              SizedBox(height: 20),
              Card(
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(12),
                ),
                elevation: 4,
                child: Padding(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 16,
                    vertical: 8,
                  ),
                  child: DropdownButtonHideUnderline(
                    child: DropdownButton<Locale>(
                      value: context.locale,
                      onChanged: (Locale? newLocale) {
                        if (newLocale != null) {
                          context.setLocale(newLocale);
                        }
                      },
                      items:
                          _supportedLocales.map((locale) {
                            return DropdownMenuItem(
                              value: locale,
                              child: Text(
                                _languageNames[locale.languageCode] ??
                                    "Unknown",
                                style: TextStyle(fontSize: 16),
                              ),
                            );
                          }).toList(),
                    ),
                  ),
                ),
              ),
              SizedBox(height: 30),
              Divider(),
              
              ListTile(
                leading: Icon(
                  Icons.info_outline,
                  color: Theme.of(context).primaryColor,
                ),
                title: Text(
                  'about'.tr(),
                  style: TextStyle(fontSize: 16, fontWeight: FontWeight.w500),
                ),
                onTap: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => AboutScreen()),
                  );
                },
              ),

              SizedBox(height: 30),
              Divider(),

              Card(
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(12),
                ),
                color: Colors.blueGrey[50],
                elevation: 2,
                child: Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Icon(
                        Icons.flight_takeoff,
                        color: Theme.of(context).primaryColor,
                        size: 40,
                      ),
                      SizedBox(height: 10),
                      Text(
                        'app_description'.tr(),
                        textAlign: TextAlign.center,
                        style: TextStyle(
                          fontSize: 14,
                          color: Colors.grey[700],
                          fontWeight: FontWeight.w500,
                        ),
                      ),
                    ],
                  ),
                ),
              ),

              SizedBox(height: 20),
            ],
          ),
        ),
      ),
    );
  }
}
