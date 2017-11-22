import * as firebase from 'firebase';
import {Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {User} from "../_models/user.model";
import {Http} from "@angular/http";
import {UserService} from "./user.service";

@Injectable()
export class AuthenticationService {

  private token: string;
  private apiUrl = 'http://localhost:8080';

  constructor(private router: Router,
              private http: Http,
              private userService: UserService) {

  }

  loginUser(username: String, password: String) {
    console.log("before login user" + username + password);
    return this.http.post(this.apiUrl + "/login", JSON.stringify({username: username, password: password}))
      .subscribe(
        (response) => {
          this.token = response.text();
          //XML Parse error here, because of idk;
          this.router.navigate(['/home']);
          this.userService.getUserDetails(this.token);
        },
        (error) => console.log(error)
      )
  }

  registerUser(user: User) {
    console.log("before register user" + user.email + user.password);
    return this.http.post(this.apiUrl + "/registeruser", user).subscribe(
      (response) => {
        this.router.navigate(['/login']);
        console.log(response);
      },
      (error) => {
        // this.router.navigate(['/login']);
        console.log(error);
      }
    );
  }

  logoutUser() {
    this.token = null;
    return this.http.post(this.apiUrl + "/logout", this.token);
  }

  getToken() {
    return this.token;
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
