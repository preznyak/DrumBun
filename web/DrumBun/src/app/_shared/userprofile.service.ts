import {UserprofileModel} from "../_models/userprofile.model";
import {Injectable} from "@angular/core";

@Injectable()
export class UserprofileService{
  private UserProfile: UserprofileModel;

  setUserProfile(userProfile: UserprofileModel){
    this.UserProfile = userProfile;
    // this.UserProfile.details = new DetailsModel("En egy fasza gyerek vagyok","En egy fasza gyerek vagyok","En egy fasza gyerek vagyok","En egy fasza gyerek vagyok","En egy fasza gyerek vagyok","En egy fasza gyerek vagyok",
    //   "En egy fasza gyerek vagyok","En egy fasza gyerek vagyok","En egy fasza gyerek vagyok");
    // this.UserProfile.details.driverLicense = "";
    // this.UserProfile.details.gender = "";
    // this.UserProfile.details.birthDate = "";
    // this.UserProfile.details.city = "";
    // this.UserProfile.details.country = "";
    // this.UserProfile.details.facebookProfile = "";
    // this.UserProfile.details.image = "";
    // this.UserProfile.details.phoneNumber = "";
  }


  getUserProfile(){
    return this.UserProfile;
  }
}
