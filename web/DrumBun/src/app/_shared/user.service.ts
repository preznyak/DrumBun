import { Injectable } from '@angular/core';
import { UserdetailsModel } from "../_models/userdetails.model";
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";
import {User} from "../_models/user.model";

@Injectable()
export class UserService {

  private userDetails: UserdetailsModel;
  private apiUrl = 'http://localhost:8080';

  constructor(private http: Http) {
  }

  // TODO test purposes, to be deleted
  findAll(): Observable<User[]>  {
    return this.http.get(this.apiUrl + "/users")
      .map((res:Response) => res.json());
      // .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getUserDetails(token: String) {
    return this.http.get(this.apiUrl + "/userdetails", token)
      .map(
        (response: Response) => {
          const data = response.json();
          return data;
        }
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
