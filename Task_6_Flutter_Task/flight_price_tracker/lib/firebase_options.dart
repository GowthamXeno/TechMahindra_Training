
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        return macos;
      case TargetPlatform.windows:
        return windows;
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyCDyyJg8ZFg2r7DIkqAtrL7xTyFW-ySL80',
    appId: '1:794327583986:web:ea02d7149c44cfc31d946b',
    messagingSenderId: '794327583986',
    projectId: 'flight-price-tracker-techm',
    authDomain: 'flight-price-tracker-techm.firebaseapp.com',
    storageBucket: 'flight-price-tracker-techm.firebasestorage.app',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyCku0EFEkhcc-ajoxrHfnKyE-KnNfCL1hE',
    appId: '1:794327583986:android:bc321ec277617a851d946b',
    messagingSenderId: '794327583986',
    projectId: 'flight-price-tracker-techm',
    storageBucket: 'flight-price-tracker-techm.firebasestorage.app',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'AIzaSyCl4qz-37RF9pFKaIZqiVi1MdPNwmNVc5E',
    appId: '1:794327583986:ios:dd77254b649ea9cc1d946b',
    messagingSenderId: '794327583986',
    projectId: 'flight-price-tracker-techm',
    storageBucket: 'flight-price-tracker-techm.firebasestorage.app',
    iosBundleId: 'com.example.flightPriceTracker',
  );

  static const FirebaseOptions macos = FirebaseOptions(
    apiKey: 'AIzaSyCl4qz-37RF9pFKaIZqiVi1MdPNwmNVc5E',
    appId: '1:794327583986:ios:dd77254b649ea9cc1d946b',
    messagingSenderId: '794327583986',
    projectId: 'flight-price-tracker-techm',
    storageBucket: 'flight-price-tracker-techm.firebasestorage.app',
    iosBundleId: 'com.example.flightPriceTracker',
  );

  static const FirebaseOptions windows = FirebaseOptions(
    apiKey: 'AIzaSyCDyyJg8ZFg2r7DIkqAtrL7xTyFW-ySL80',
    appId: '1:794327583986:web:5140113aa7c463fb1d946b',
    messagingSenderId: '794327583986',
    projectId: 'flight-price-tracker-techm',
    authDomain: 'flight-price-tracker-techm.firebaseapp.com',
    storageBucket: 'flight-price-tracker-techm.firebasestorage.app',
  );
}
