import {Component, Injectable, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {AuthenticationService} from "../_shared/authentication.service";
import {User} from "../_models/user.model";
import {UserService} from "../_shared/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  @ViewChild('f') signupForm: NgForm;

  constructor(private authenticationService: AuthenticationService,
              private user: User,
              private router: Router) {

  }

  ngOnInit() {
  }

  onSignup() {
    this.user.firstName = this.signupForm.value.userData.firstname;
    this.user.lastName = this.signupForm.value.userData.lastname;
    this.user.email = this.signupForm.value.userAuthenticationData.email;
    this.user.password = this.signupForm.value.userAuthenticationData.password;
    // this.authenticationService.signUpUser(this.user.email, this.user.password);
    console.log("onSignup called");
    this.authenticationService.registerUser(this.user)
        .subscribe(
          (response) => {
            this.router.navigate(['/login'])
            console.log(response)},
              (error) => console.log(error)
          );
  }


}
