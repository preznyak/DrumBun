import {Component, OnInit} from '@angular/core';
import {UserService} from "../../_shared/user.service";
import {UserdetailsModel} from "../../_models/userdetails.model";
import {AuthenticationService} from "../../_shared/authentication.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userDetails: UserdetailsModel;

  constructor(private userService: UserService,
              private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    this.userService.getUserDetails(this.authenticationService.getToken())
      .subscribe(
        (data) => this.userDetails = data,
        (error) => console.log(error)
      );
    console.log("success");
  }
}
