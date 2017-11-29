import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from "../../../_shared/user.service";
import {UserdetailsModel} from "../../../_models/userdetails.model";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";
import {UserprofileModel} from "../../../_models/userprofile.model";
import {UserprofileService} from "../../../_shared/userprofile.service";

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {
  @ViewChild('editForm') editForm: NgForm;

  private userDetails: UserprofileModel;
  isDataLoaded: boolean = true;

  constructor(private userDetailsService: UserprofileService,
              private userService: UserService,
              private router: Router) {


  }

  ngOnInit() {
    this.userDetails = this.userDetailsService.getUserProfile();
    if (this.userDetails == null){
      this.isDataLoaded = false;
    }
  }

  loadData() {
    this.editForm.setValue({
      username: this.userDetails.username,
      firstName: this.userDetails.firstName,
      lastName: this.userDetails.lastName,
      email: this.userDetails.email,
      userProfile: {
        image: this.userDetails.userProfile.image,
        facebookProfile: this.userDetails.userProfile.facebookProfile,
        birthDate: this.userDetails.userProfile.birthDate,
        bio: this.userDetails.userProfile.bio,
        gender: this.userDetails.userProfile.gender,
        city: this.userDetails.userProfile.city,
        country: this.userDetails.userProfile.country,
        phoneNumber: this.userDetails.userProfile.phoneNumber,
        driverLicense: this.userDetails.userProfile.driverLicense
      }
    });
  }

  clearData() {
    this.editForm.reset();
  }

  cancelEdit() {
    this.router.navigate(['/profile']);
  }

  //TODO test this!
  saveData() {
    this.userService.saveUserDetails(this.editForm.value)
      .subscribe(
        (response) => {
          console.log(response);
          this.userDetailsService.setUserProfile(this.editForm.value);
          this.router.navigate(['/profile'])
        },
        (error) => console.log(error)
      )
  }
}
