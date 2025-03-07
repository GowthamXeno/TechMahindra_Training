// 5. Create a object called student with properties id, name, department, college and email.Write a function to access the properties and display them. Invoke the function to display the details
// Write another function to access the properties id, name and email and display them. Invoke the function to display the details
// Add a property called address, as another object, with properties as doorNo, street, area and pincode
// Add a function to display the details of the student with address.
// Delete the property email and the function created to display id, name and email.

const student = {
  id: 404,
  Name: "Gowtham",
  Dept: "ECE",
  College: "PEC",
  email: "gowtham@gmail.com",
  display: function () {
    console.log(this.id);
    console.log(this.Name);
    console.log(this.Dept);
    console.log(this.College);
    console.log(this.email);
  },
};
student.display();
display1 = () => console.log(student);
display1();
display2 = () => {
  console.log(student["id"] + " " + student["Name"] + " " + student["email"]);
  student.address = {
    doorNo: 28,
    street: "Nehru Nagar", 
    area: "JKM",
    pincode: 621804,
  };
};
console.log("After Changes :");
display2();
delete student.email;
display1();
