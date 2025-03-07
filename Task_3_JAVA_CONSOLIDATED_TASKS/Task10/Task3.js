
let student = {
  name: "Gowtham",
  age: 22,
  dept: "Electronics and Communication",
  display: function() {
    console.log("Name : "+this.name);
    console.log("Age : "+this.age);
    console.log("Department : "+this.dept);
  }
};


console.log(student.name);
console.log(student.age);
console.log(student.course);


student.display();


student.address = {
  street: "28C , Kottai Vasel East Street",
  city: "Udayarpalayam",
  pincode: "621804",
  getCity : function () {
    console.log("City : "+this.city);
  },
  getPincode : function () {
    console.log("Pincode : "+this.pincode);
  }
};

student.updateAge = function (newAge) {
  this.age = newAge;
  console.log(`Age updated to: ${this.age}`);
};

console.log(student.address.street);
student.updateAge(23);
student.address.getCity();
student.address.getPincode();

delete student.dept;
delete student.updateAge;

console.log(student);
student.display();
student.address.getCity();
