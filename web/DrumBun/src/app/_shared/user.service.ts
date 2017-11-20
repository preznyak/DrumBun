import { Injectable } from '@angular/core';
import { UserdetailsModel } from "../_models/userdetails.model";
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";
import {User} from "../_models/user.model";

@Injectable()
export class UserService {

  private apiUrl = 'http://localhost:8080';

  constructor(private http: Http) {
  }

  // TODO test purposes, to be deleted
  findAll(): Observable<User[]>  {
    return this.http.get(this.apiUrl + "/users")
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getUserDetails(token: String) {
    return this.http.get(this.apiUrl + "/usersdetails", token)
      .map(
        (response: Response) => {
          const data = response.json();
          return data;
        }
      )
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
