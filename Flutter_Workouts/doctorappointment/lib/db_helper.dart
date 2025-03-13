import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class DatabaseHelper {
  static final DatabaseHelper instance = DatabaseHelper._init();
  static Database? _database;

  DatabaseHelper._init();

  Future<Database> get database async {
    if (_database != null) return _database!;
    _database = await _initDB();
    return _database!;
  }
static Future<int> updateAppointment(int id, Map<String, dynamic> appointment) async {
  final db = await DatabaseHelper.instance.database;
  return await db.update(
    'appointments',
    appointment,
    where: 'id = ?',
    whereArgs: [id],
  );
}
  Future<Database> _initDB() async {
    final dbPath = await getDatabasesPath();
    final path = join(dbPath, 'appointments.db');

    return await openDatabase(
      path,
      version: 1,
      onCreate: (db, version) async {
        await db.execute('''
          CREATE TABLE appointments (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            date TEXT,
            time TEXT,
            reason TEXT,
            doctor TEXT
          )
        ''');
      },
    );
  }

  static Future<int> insertAppointment(Map<String, dynamic> appointment) async {
    final db = await DatabaseHelper.instance.database;
    return await db.insert('appointments', appointment);
  }

  static Future<List<Map<String, dynamic>>> getAppointments() async {
    final db = await DatabaseHelper.instance.database;
    return await db.query('appointments');
  }

  static Future<int> deleteAppointment(int id) async {
    final db = await DatabaseHelper.instance.database;
    return await db.delete('appointments', where: 'id = ?', whereArgs: [id]);
  }
}
