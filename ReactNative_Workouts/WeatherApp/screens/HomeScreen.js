import React, { useState } from 'react';
import { View, Button, FlatList, Text, TouchableOpacity, StyleSheet, TextInput } from 'react-native';

const cities = ['London', 'Paris', 'New York', 'Tokyo', 'Sydney'];

const HomeScreen = ({ navigation }) => {
  const [selectedCity, setSelectedCity] = useState('');
  const [searchCity, setSearchCity] = useState('');

  const handleCitySelection = (city) => {
    if (!city.trim()) return;
    setSelectedCity(city);
    navigation.navigate('Weather', { city });
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Select a City:</Text>
      <FlatList
        data={cities}
        keyExtractor={(item) => item}
        renderItem={({ item }) => (
          <TouchableOpacity style={styles.cityButton} onPress={() => handleCitySelection(item)}>
            <Text style={styles.cityText}>{item}</Text>
          </TouchableOpacity>
        )}
      />
      <Text style={styles.title}>Or Enter a City:</Text>
      <View style={styles.inputContainer}>
        <TextInput
          style={styles.input}
          placeholder="Enter city"
          value={searchCity}
          onChangeText={setSearchCity}
        />
        <Button title="Go" onPress={() => handleCitySelection(searchCity)} />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
  },
  title: {
    fontSize: 20,
    marginBottom: 20,
  },
  cityButton: {
    padding: 10,
    backgroundColor: '#ddd',
    marginVertical: 5,
    alignItems: 'center',
    width: 200,
  },
  cityText: {
    fontSize: 18,
  },
  inputContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    width: '100%',
    marginTop: 10,
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    flex: 1,
    marginRight: 10,
  },
});

export default HomeScreen;
