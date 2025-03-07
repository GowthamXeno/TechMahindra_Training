import { Component, Input } from '@angular/core';
import { enquiry } from '../../../model/enquiry';
import { ApiService } from '../../../services/api.service';

@Component({
  selector: 'app-enquiry-form',
  templateUrl: './enquiry-form.component.html',
  styleUrl: './enquiry-form.component.css'
})
export class EnquiryFormComponent {
    enquiry:enquiry = {name:'', email:'', serviceType:'', message:''};
    errors:string[]=[]

    constructor(private api: ApiService) {}
    submitForm() {
      this.errors=[]
      let emailPattern = /^[a-zA-Z0-9\._]+@[a-zA-Z]+\.[a-zA-Z]{2,4}$/;
      if(!this.enquiry.name || this.enquiry.name.length<3){
        this.errors.push("Name should be atleast three characters long")
      }
      if(!this.enquiry.email || !emailPattern.test(this.enquiry.email)){
        this.errors.push("Invalid Email")
      }
      if(!this.enquiry.serviceType || this.enquiry.serviceType.length==0){
        this.errors.push("Please select a service type")
      }
      if(!this.enquiry.message || this.enquiry.message.length<10){
        this.errors.push("Message should be atleast 10 characters long")
      }
      if(this.errors.length==0){
        this.api.addEnquiry({
          name: this.enquiry.name,
          email: this.enquiry.email,
          serviceType: this.enquiry.serviceType,
          message: this.enquiry.message
        }).subscribe({
            next: (response) => {
              console.log("Enquiry Form Response:", response);
              this.enquiry = {name:'', email:'', serviceType:'', message:''};
              alert("Enquiry Submitted Successfully")	
            },
            error: (error) => {
              alert("Something went wrong. Please try again")
           }});
      }
      // console.log(this.enquiry);
      this.enquiry = {name:'', email:'', serviceType:'', message:''};
    }
 }
