import 'package:flutter/material.dart';

class ThirdTask extends StatefulWidget {
  const ThirdTask({super.key});
  @override
  _ThirdTask createState() => _ThirdTask();
}

class _ThirdTask extends State<ThirdTask> {
  int price = 5000;

  void increasePrice() {
    setState(() {
      price += 100;
    });
  }

  void decreasePrice() {
    setState(() {
      price -= 100;
    });
  }

  void multiplyPrice() {
    setState(() {
      price = (price * 1.2).round();
    });
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return Scaffold(appBar: AppBar(title: Text('Third Task',style: theme.textTheme.titleLarge)
    ),body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Price: \₹${price}',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                ElevatedButton(
                  onPressed: increasePrice,
                  child: Text('+100'),
                ),
                SizedBox(width: 10),
                ElevatedButton(
                  onPressed: decreasePrice,
                  child: Text('-100'),
                ),
                SizedBox(width: 10),
                ElevatedButton(
                  onPressed: multiplyPrice,
                  child: Text('×1.2'),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
