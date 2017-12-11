import {Component, OnInit} from '@angular/core';
import {NeedModel} from "../../../_models/need.model";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
  needs: NeedModel[];

  constructor(private httpClient: HttpClient,
              private router: Router) {
  }

  ngOnInit() {
    this.httpClient.get("/api/needs")
      .subscribe(
        (response: NeedModel[]) => {this.needs = response;
          console.log(this.needs);},
        (error) => console.log(error)
      );
  }

  newNeed(){
    this.router.navigate(['create-need']);
    console.log("new Need Clicked");
  }

}
