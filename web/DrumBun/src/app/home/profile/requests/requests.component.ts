import {Component, OnInit} from '@angular/core';
import {NeedModel} from "../../../_models/need.model";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
  needs: NeedModel[];

  constructor(private httpClient: HttpClient) {
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
    //TODO new need.
    console.log("new Need Clicked");
  }

}
