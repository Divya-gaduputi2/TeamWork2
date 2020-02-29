import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent {

  support: FormGroup;

  error_messages = {
    'fname': [
      { type: 'required', message: 'First Name is required!' },
    ],

    'lname': [
      { type: 'required', message: 'Last Name is required!' }
    ],

    'email': [
      { type: 'required', message: 'Email is required!' },
      { type: 'minlength', message: 'Email length is too short!' },
      { type: 'maxlength', message: 'Invalid Email length!' },
      { type: 'email', message: 'Please enter valid email ID!'}
    ],

    'message': [
      { type: 'required', message: 'No Message!' },
      { type: 'minlength', message: 'Atleast 50 words!' }
    ]
  }

  constructor(
    public formBuilder: FormBuilder
  ) { 
    this.support = this.formBuilder.group({
      fname: new FormControl('', Validators.compose([
        Validators.required
      ])),
      lname: new FormControl('', Validators.compose([
        Validators.required
      ])),
      email: new FormControl('', Validators.compose([
        Validators.required,
        Validators.email,
        Validators.minLength(3),
        Validators.maxLength(30)
      ])),
      message: new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(50)
      ]))
    });
  }

}
