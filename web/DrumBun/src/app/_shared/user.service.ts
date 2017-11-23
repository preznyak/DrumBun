import { Injectable } from '@angular/core';
import { UserdetailsModel } from "../_models/userdetails.model";
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";


@Injectable()
export class UserService {

  private userDetails: UserdetailsModel;
  private apiUrl = 'http://localhost:8080';

  constructor(private http: Http,
              private httpClient: HttpClient) {
  }

  getUserDetails(token: String) {

    // 'Content-Type': 'application/json',
    // 'Accept': 'application/json',


    // const headers = new Headers(  {
    //                                 'Authorization': `Bearer ${token}`,
    //                               });
    // console.log(headers);

    //Testing fucntion with 1 object returned in request
    return this.httpClient.get(this.apiUrl + "/users")
      .subscribe(
        (response) => {
          // const data = response.json();
          console.log(response);
          // return data;
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
