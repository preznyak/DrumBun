import { Injectable } from '@angular/core';
import { UserdetailsModel } from "../_models/userdetails.model";
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";
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

    //Testing fucntion with 1 object returned in request
    return this.httpClient.get(this.apiUrl + "/users/username/" + username)
      .subscribe(
        (response: UserprofileModel) => {
          this.userProfileService.setUserProfile(response);
          // console.log(response);
          // console.log("********************");
          console.log(this.userProfileService.getUserProfile());
        },
        (error) => console.log(error)
      )
  }

  getUserDetailsFromUserService(){
    return this.userDetails;
  }

  setUserDetailsAtUserService(data: UserdetailsModel){
    this.userDetails = data;
    console.log("=====FromUserService=====setUserDetailsAtUserService=======")
    console.log(this.userDetails)
    return this.http.post(this.apiUrl + "/updateuserdetails", data);
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
