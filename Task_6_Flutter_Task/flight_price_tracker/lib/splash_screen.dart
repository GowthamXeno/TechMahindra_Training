import 'package:flutter/material.dart';


class SplashScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Image.asset(
          'assets/app_logo.png',
          width: 200, 
          height: 200,
        ),
      ),
    );
  }
}