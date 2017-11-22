import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from "../../../_shared/user.service";
import {UserdetailsModel} from "../../../_models/userdetails.model";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {
  @ViewChild('editForm') editForm: NgForm;

  private userDetails: UserdetailsModel;

  constructor(private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {
    this.userDetails = this.userService.getUserDetailsFromUserService();
    console.log("====fromProfileEdit");
    console.log(this.userDetails.firstName);

  }

  loadData(){
    this.editForm.setValue({
      profilePicture: this.userDetails.profilePicture,
      firstName: this.userDetails.firstName,
      lastName: this.userDetails.lastName,
      birthdate: this.userDetails.birthdate,
      gender: this.userDetails.gender,
      addressCity: this.userDetails.addressCity,
      addressCountry: this.userDetails.addressCountry,
      email: this.userDetails.email,
      phone: this.userDetails.phone,
      driverLicense: this.userDetails.driverLicense
    });
  }

  clearData(){
    this.editForm.reset();
  }

  cancelEdit(){
    this.router.navigate(['/profile']);
  }

  saveData(){
    this.userDetails = this.editForm.value;
    this.userService.setUserDetailsAtUserService(this.userDetails)
      .subscribe(
        (response) => this.router.navigate(['/home']),
        //temporary navigate to home
        // (error) => console.log(error + "handle error")
        (error) => this.router.navigate(['/home'])
      );
  }
  //TODO html look nicer.
  //TODO Welcome page and routing

}
