
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:easy_localization/easy_localization.dart';
import 'views/home/home_screen.dart';
import 'views/flights/saved_flights_screen.dart';
import 'views/settings/settings_screen.dart';
import './core/api_service.dart';
import 'splash_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  await EasyLocalization.ensureInitialized();

  runApp(EasyLocalization(
    supportedLocales: [Locale('en'), Locale('es'),Locale('ta'),Locale('de'),Locale('fr')], 
    path: 'assets/lang',
    fallbackLocale: Locale('en'),
    child: const MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flight Price Tracker',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        brightness: Brightness.light,
      ),
      debugShowCheckedModeBanner: false,
      home: const MainScreen(),
      localizationsDelegates: context.localizationDelegates,
      supportedLocales: context.supportedLocales,
      locale: context.locale,
    );
  }
}

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  int _selectedIndex = 0;
  List<dynamic> allFlights = [];
  Map<String, String> airportNames = {};
  bool isLoading = true;
  final ApiService apiService = ApiService();
  bool _showSplash = true;
  bool _showLoading = true;

  @override
  void initState() {
    super.initState();
    _showSplashForDuration();
    loadFlights();
  }

  void _showSplashForDuration() {
    Future.delayed(const Duration(seconds: 3), () {
      setState(() {
        _showSplash = false;
      });
    });
  }

  void loadFlights() async {
    setState(() {
      isLoading = true;
    });
    try {
      List<dynamic> flights = await apiService.fetchAllFlights();
      Map<String, String> airports = apiService.getAirportNames();

      setState(() {
        allFlights = flights;
        airportNames = airports;
        isLoading = false;
        _showLoading = false;
      });
    } catch (e) {
      debugPrint("Error loading flights: $e");
      setState(() {
        isLoading = false;
        _showLoading = false;
      });
    }
  }

  static List<Widget> _screens = [];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    if (_showSplash) {
      return SplashScreen();
    }

    if (_showLoading) {
      return Scaffold(
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.asset(
                'assets/app_logo.png', // Replace with your logo asset path
                width: 150,
                height: 150,
              ),
              SizedBox(height: 20),
              LinearProgressIndicator(),
            ],
          ),
        ),
      );
    }

    _screens = [
      HomeScreen(
        allFlights: allFlights,
        airportNames: airportNames,
        onRefresh: loadFlights,
      ),
      SavedFlightsScreen(),
      SettingsScreen(),
    ];

    return Scaffold(
      body: _screens[_selectedIndex],
      bottomNavigationBar: _showLoading
          ? null
          : BottomNavigationBar(
              items: [
                BottomNavigationBarItem(
                  icon: Icon(Icons.flight_takeoff),
                  label: 'home'.tr(),
                ),
                BottomNavigationBarItem(
                  icon: Icon(Icons.bookmark),
                  label: 'saved'.tr(),
                ),
                BottomNavigationBarItem(
                  icon: Icon(Icons.settings),
                  label: 'settings'.tr(),
                ),
              ],
              currentIndex: _selectedIndex,
              selectedItemColor: Colors.white,
              unselectedItemColor: Colors.grey.shade400,
              backgroundColor: Colors.blueAccent,
              elevation: 10,
              type: BottomNavigationBarType.fixed,
              onTap: _onItemTapped,
            ),
    );
  }
}
