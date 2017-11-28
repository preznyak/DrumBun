import {DetailsModel, UserprofileModel} from "../_models/userprofile.model";
import {Injectable} from "@angular/core";

@Injectable()
export class UserprofileService {
  private UserProfile: UserprofileModel;


  createUserProfile(username: string, firstName: string, lastName: string, email: string, userProfile: DetailsModel) {
    this.UserProfile = new UserprofileModel(username, firstName, lastName, email, new DetailsModel(userProfile.image, userProfile.bio, userProfile.phoneNumber, userProfile.facebookProfile, userProfile.city,
      userProfile.country, userProfile.gender, userProfile.driverLicense, userProfile.birthDate));
    console.log(this.UserProfile);
  }

  setUserProfile(userProfile: UserprofileModel) {
    this.UserProfile = userProfile;
  }

  getUserProfile() {
    return this.UserProfile;
  }
}
