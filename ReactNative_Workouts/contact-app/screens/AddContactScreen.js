import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet, Alert } from 'react-native';
import * as Contacts from 'expo-contacts';

export default function AddContactScreen({ navigation }) {
  const [name, setName] = useState('');
  const [phone, setPhone] = useState('');

  const saveContact = async () => {
    console.log("Save Contact Called!");
    
    if (!name || !phone) {
      Alert.alert('Please fill in all fields');
      console.log("Inside error");
      return;
    }
  
    const { granted } = await Contacts.requestPermissionsAsync({
      permissions: [Contacts.Permission.WRITE_CONTACTS],
    });
  
    if (!granted) {
      Alert.alert('Permission Denied', 'Cannot save contact without permission.');
      return;
    }
  
    try {
      const contact = {
        [Contacts.Fields.Name]: name,
        [Contacts.Fields.PhoneNumbers]: [{ label: 'mobile', number: phone }],
      };
  
      const contactId = await Contacts.addContactAsync(contact);
      if (contactId) {
        Alert.alert('Contact added successfully');
        console.log("Contact added Log");
        navigation.goBack();
      } else {
        Alert.alert('Failed to add contact');
      }
    } catch (error) {
      console.error("Error adding contact:", error);
      Alert.alert('Error', 'Failed to save contact.');
    }
  };
  

  return (
    <View style={styles.container}>
      <Text>Name:</Text>
      <TextInput style={styles.input} value={name} onChangeText={setName} />
      <Text>Phone:</Text>
      <TextInput style={styles.input} value={phone} onChangeText={setPhone} keyboardType="phone-pad" />
      <Button title="Save Contact" onPress={saveContact} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 5,
    padding: 10,
    marginVertical: 10,
  },
});