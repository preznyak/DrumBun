import {Component, OnInit} from '@angular/core';
import {UserService} from "../../_shared/user.service";
import {UserdetailsModel} from "../../_models/userdetails.model";
import {AuthenticationService} from "../../_shared/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userDetails: UserdetailsModel;

  constructor(private userService: UserService,
              private authenticationService: AuthenticationService,
              private router: Router) {
  }


  userDetailsteszt: UserdetailsModel = new UserdetailsModel(
      "https://vignette.wikia.nocookie.net/phobia/images/b/bd/Boy.jpg/revision/latest?cb=20161123121117",
      "Lajos",
      "Kovacs",
      "1996.12.04",
    "Male",

    "Romania",
      "LakatosCity",
    "ecetke@gmail.com",
    "0712312412123",

      "B");

  ngOnInit() {
    this.userService.getUserDetails(this.authenticationService.getToken())
      .subscribe(
        (data) => this.userDetails = data,
        (error) => console.log(error)
      );
    console.log("success");
    console.log(this.userDetailsteszt);
  }

  toEdit(){
    this.router.navigate(['/profile-edit']);
  }

}
