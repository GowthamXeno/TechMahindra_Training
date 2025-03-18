import 'package:flutter/material.dart';
import 'package:easy_localization/easy_localization.dart';

class AboutScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('about'.tr()), 
        centerTitle: true,
        leading: IconButton(
          icon: Icon(Icons.arrow_back),
          onPressed: () => Navigator.pop(context),
        ),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // App Name
            Text(
              "Flight Price Tracker",
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),

            // App Description
            Text("track_flight_prices".tr(), style: TextStyle(fontSize: 16)),
            SizedBox(height: 20),

            // Features Section
            Text(
              "features".tr(),
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),
            FeatureTile(
              icon: Icons.api_rounded,
              title: "public_api".tr(),
              description: "public_api_desc".tr(),
            ),
            FeatureTile(
              icon: Icons.navigation_rounded,
              title: "bottom_navigation".tr(),
              description: "bottom_navigation_desc".tr(),
            ),
            FeatureTile(
              icon: Icons.filter_alt_rounded,
              title: "event_filtering".tr(),
              description: "event_filtering_desc".tr(),
            ),
            FeatureTile(
              icon: Icons.grid_view_rounded,
              title: "layouts".tr(),
              description: "layouts_desc".tr(),
            ),
            FeatureTile(
              icon: Icons.cloud_done_rounded,
              title: "database".tr(),
              description: "database_desc".tr(),
            ),
            FeatureTile(
              icon: Icons.language_rounded,
              title: "localization".tr(),
              description: "localization_desc".tr(),
            ),
          ],
        ),
      ),
    );
  }
}

// Custom Widget for Feature Display
class FeatureTile extends StatelessWidget {
  final IconData icon;
  final String title;
  final String description;

  FeatureTile({
    required this.icon,
    required this.title,
    required this.description,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      elevation: 3,
      margin: EdgeInsets.symmetric(vertical: 8),
      child: ListTile(
        leading: Icon(icon, color: Colors.blueAccent, size: 30),
        title: Text(
          title,
          style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
        ),
        subtitle: Text(description, style: TextStyle(fontSize: 14)),
      ),
    );
  }
}
