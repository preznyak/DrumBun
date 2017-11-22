import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../_shared/authentication.service";
import {Router} from "@angular/router";
import {UserService} from "../_shared/user.service";
import {UserdetailsModel} from "../_models/userdetails.model";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  data: UserdetailsModel;

  constructor(private authenticationService: AuthenticationService,
              private router: Router,
              private userDetailsService: UserService) {
  }

  ngOnInit() {
  }

  toProfile(){
    this.userDetailsService.getUserDetails(this.authenticationService.getToken())
      .subscribe(
        (data) => {this.data = data;
        this.router.navigate(['/profile'],this.data)},
        (error) => console.log(error)
      );
  }

  onLogout() {
    this.authenticationService.logout();
    // TODO firebase
    this.authenticationService.logoutUser()
      .subscribe(
        (response) => {
          this.router.navigate(['/login'])
          console.log(response)},
        (error) => console.log(error)
      );
  }

}
