import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {DetailsModel, UserprofileModel} from "../../../_models/userprofile.model";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-foreign-profile',
  templateUrl: './foreign-profile.component.html',
  styleUrls: ['./foreign-profile.component.css']
})
export class ForeignProfileComponent implements OnInit {

  username: string;
  foreignProfile: UserprofileModel;

  constructor(private router: ActivatedRoute,
              private httpClient: HttpClient) {

  }

  ngOnInit() {
    this.router.params.subscribe(
      (response) => this.username = response.username
    );
    this.httpClient.get("http://localhost:8080/users/username/"+this.username)
      .subscribe(
        (response: UserprofileModel) => {this.foreignProfile =
          new UserprofileModel(response.username,response.firstName,response.lastName,response.email,
            new DetailsModel(response.userProfile.image,response.userProfile.bio,response.userProfile.phoneNumber,
              response.userProfile.facebookProfile,response.userProfile.city,response.userProfile.country,
              response.userProfile.gender,response.userProfile.driverLicense,response.userProfile.birthDate));
        console.log(this.foreignProfile);}
      );
    // console.log(this.foreignProfile);
  }

}
