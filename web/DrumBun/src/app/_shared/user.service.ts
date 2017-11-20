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

  //test purposes
  findAll(): Observable<UserdetailsModel[]>  {
    return this.http.get(this.apiUrl + "/users")
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
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