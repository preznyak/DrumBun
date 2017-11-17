import * as firebase from 'firebase';
import {Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {User} from "../_models/user.model";
import {Http} from "@angular/http";

@Injectable()
export class AuthenticationService {

  private token: string;
  private apiUrl = 'http://localhost:8080';

  constructor(private router: Router,
              private http: Http) {

  }

  loginUser(email: String, password: String){
    console.log("before login user" + email + password);
    return this.http.post(this.apiUrl + "/loginuser", email,password);
  }

  registerUser(user: User){
    console.log("before register user" + user.email + user.password);
    return this.http.post(this.apiUrl + "/registeruser", user);
  }

  logoutUser() {
    this.token = null;
    return this.http.post(this.apiUrl + "/logoutuser", this.token);
  }

  signUpUser(email: string, password: string) {
    firebase.auth().createUserWithEmailAndPassword(email, password)
      .catch(
        error => console.log(error)
      )
  }

  signInUser(email: string, password: string) {
    firebase.auth().signInWithEmailAndPassword(email, password)
      .then(
        response => {
          this.router.navigate([''])
          firebase.auth().currentUser.getToken()
            .then(
              (token: string) => this.token = token
            )
        }
      )
      .catch(
        error => console.log(error)
      )
  }

  logout() {
    firebase.auth().signOut();
    this.token = null;
  }

  isAuthenticated() {
    return this.token != null;
  }
}
