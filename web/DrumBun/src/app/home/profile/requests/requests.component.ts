import {Component, OnInit} from '@angular/core';
import {NeedModel} from "../../../_models/need.model";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {UserprofileService} from "../../../_shared/userprofile.service";

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
  needs: NeedModel[];
  errorMessage: string;

  constructor(private httpClient: HttpClient,
              private router: Router,
              private userProfile: UserprofileService) {
  }

  ngOnInit() {
    this.httpClient.get("/api/needs/myNeeds/" + this.userProfile.getUserProfile().username)
      .subscribe(
        (response: NeedModel[]) => {this.needs = response;
          console.log(this.needs);},
        (error) => this.errorMessage = error.error
      );
  }

  newNeed(){
    this.router.navigate(['create-need']);
    console.log("new Need Clicked");
  }

}
