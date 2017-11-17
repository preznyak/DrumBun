import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../_shared/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService,
              private router: Router) {
  }

  ngOnInit() {
  }

  onLogout() {
    this.authenticationService.logout();
    this.authenticationService.logoutUser()
      .subscribe(
        (response) => {
          this.router.navigate(['/login'])
          console.log(response)},
        (error) => console.log(error)
      );
  }

}
