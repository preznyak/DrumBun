import {UserprofileModel} from "../_models/userprofile.model";
import {Injectable} from "@angular/core";

@Injectable()
export class UserprofileService{
  private UserProfile: UserprofileModel;

  setUserProfile(userProfile: UserprofileModel){
    this.UserProfile = userProfile;
  }

  getUserProfile(){
    return this.UserProfile;
  }
}
