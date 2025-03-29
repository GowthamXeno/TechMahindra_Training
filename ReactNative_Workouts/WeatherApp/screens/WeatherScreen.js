import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet } from 'react-native';

const WeatherScreen = ({ route }) => {
  const { city } = route.params;
  const [weatherData, setWeatherData] = useState(null);

  useEffect(() => {
    fetch(
      `http://api.weatherapi.com/v1/current.json?key=5c4b55d65f3b467baf295331252803&q=${city}&aqi=no`
    )
      .then((response) => response.json())
      .then((data) => setWeatherData(data))
      .catch((error) => console.error(error));
  }, [city]);

  return (
    <View style={styles.container}>
      {weatherData ? (
        <>
          <Text style={styles.title}>Weather in {weatherData.location.name}</Text>
          <Text style={styles.info}>Temperature: {weatherData.current.temp_c}°C</Text>
          <Text style={styles.info}>Condition: {weatherData.current.condition.text}</Text>
        </>
      ) : (
        <Text style={styles.loading}>Loading weather data...</Text>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
  },
  info: {
    fontSize: 18,
  },
  loading: {
    fontSize: 16,
    fontStyle: 'italic',
  },
});

export default WeatherScreen;