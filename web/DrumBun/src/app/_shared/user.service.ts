import {Injectable} from '@angular/core';
import {UserdetailsModel} from "../_models/userdetails.model";
import {Http, Response} from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {UserprofileService} from "./userprofile.service";
import {UserprofileModel} from "../_models/userprofile.model";


@Injectable()
export class UserService {

  private userDetails: UserdetailsModel;
  private apiUrl = 'http://localhost:8080';

  constructor(private http: Http,
              private httpClient: HttpClient,
              private userProfileService: UserprofileService) {
  }

  getUserDetails(username: String) {
    return this.httpClient.get(this.apiUrl + "/users/username/" + username)
      .subscribe(
        (response: UserprofileModel) => {
          this.userProfileService.createUserProfile(response.username, response.firstName, response.lastName, response.email, response.userProfile);
        },
        (error) => console.log(error)
      )
  }

  saveUserDetails(data: UserprofileModel) {
    console.log("HERE COMES THE REQUEST")
    return this.httpClient.post(this.apiUrl + "/valami/" + data.username, data);
  }

  findById(id: number): Observable<UserdetailsModel> {
    return null;
  }

  deleteUserById(id: number): Observable<boolean> {
    return null;
  }

  updateUser(user: UserdetailsModel): Observable<UserdetailsModel> {
    return null;
  }

}
