import * as firebase from 'firebase';
import {Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {User} from "../_models/user.model";
import {Http} from "@angular/http";
import {UserService} from "./user.service";
import {TokenService} from "./token.service";

@Injectable()
export class AuthenticationService {

  private apiUrl = 'http://localhost:8080';

  constructor(private router: Router,
              private http: Http,
              private userService: UserService,
              private tokenService: TokenService) {

  }

  loginUser(username: String, password: String) {
    console.log("before login user" + username + password);
    return this.http.post(this.apiUrl + "/login", JSON.stringify({username: username, password: password}))
    // return this.http.post(/api/ + "/login", JSON.stringify({username: username, password: password}))
      .subscribe(
        (response) => {
          this.tokenService.token = response.text();
          this.router.navigate(['/home']);
          this.userService.getUserDetails(username);
        },
        (error) => console.log(error)
      )
  }

  registerUser(user: User) {
    console.log("before register user" + user.email + user.password);
    return this.http.post(this.apiUrl + "/registeruser", user).subscribe(
      (response) => {
        this.router.navigate(['/login']);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  logoutUser() {
    this.tokenService.token = null;
    return this.http.post(this.apiUrl + "/logout", this.tokenService.token);
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
              (token: string) => this.tokenService.token = token
            )
        }
      )
      .catch(
        error => console.log(error)
      )
  }

  logout() {
    firebase.auth().signOut();
    this.tokenService.token = null;
  }

  //TODO make guard use token service
  isAuthenticated() {
    return this.tokenService.token != null;
  }
}
