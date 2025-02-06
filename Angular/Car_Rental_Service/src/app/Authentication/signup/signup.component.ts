
import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ShowErrorComponent } from '../show-error/show-error.component';
@Component({
  selector: 'app-signup',
  imports: [FormsModule,ReactiveFormsModule,CommonModule,ShowErrorComponent],
  standalone:true,
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
 signupForm:FormGroup;
 invalidForm!:boolean
 constructor() {
  this.signupForm=new FormGroup({ 
    name: new FormControl('', [Validators.required,Validators.minLength(3)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(8)]),
    confirm_password: new FormControl('', Validators.required)
  });
}
get passwordMismatch() {
  return (
    this.signupForm.get('password')?.value !== this.signupForm.get('confirm_password')?.value &&
    this.signupForm.get('confirm_password')?.touched
  );
}
OnSubmit(){
  if (this.signupForm.invalid) {
  this.invalidForm=true;
    return;
  }
  alert("Registration SuccessFul");
}
ShowForm(){
  this.invalidForm=false;
}
}
