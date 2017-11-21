import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../_shared/user.service";
import {UserdetailsModel} from "../../../_models/userdetails.model";

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {
  private userDetails: UserdetailsModel;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userDetails = this.userService.getUserDetailsFromUserService();
    console.log("====fromProfileEdit");
    console.log(this.userDetails);
  }

  //TODO form, onSave, Save data to server
  //TODO Welcome page and routing

}
