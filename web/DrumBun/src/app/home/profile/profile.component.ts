import {Component, OnInit} from '@angular/core';
import {UserService} from "../../_shared/user.service";
import {UserdetailsModel} from "../../_models/userdetails.model";
import {AuthenticationService} from "../../_shared/authentication.service";
import {Router} from "@angular/router";
import {DetailsModel, UserprofileModel} from "../../_models/userprofile.model";
import {UserprofileService} from "../../_shared/userprofile.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userDetails: UserprofileModel;
  isDataLoaded: boolean = false;

  constructor(private router: Router,
              private userProfileService: UserprofileService) {
    this.loadData();

  }


  ngOnInit() {
    console.log("fromNgOnInit")
    console.log(this.userDetails);
    if(this.userDetails != null){
      this.isDataLoaded = true;
    }

  }

  loadData(){
    this.userDetails = this.userProfileService.getUserProfile();
    console.log(this.userDetails.userProfile.image.toString());
  }

  toEdit(){
    this.router.navigate(['/profile-edit']);
  }

}
