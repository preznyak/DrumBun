import {Component, Input, OnInit} from '@angular/core';
import {NeedModel} from "../../../../_models/need.model";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-needs',
  templateUrl: './user-needs.component.html',
  styleUrls: ['./user-needs.component.css']
})
export class UserNeedsComponent implements OnInit {
  @Input() need: NeedModel;
  deleted: boolean = false;

  constructor(private router: Router,
              private httpClient: HttpClient) { }

  ngOnInit() {
  }

  seeTransportersProfile(username: string){
    this.router.navigate(['profileof/' + username]);
  }


  deleteNeed(id: number){
    console.log("delete need: "+ id);
    this.httpClient.delete("/api/needs/delete/" + id, JSON.stringify({id: id}))
      .subscribe(
        (response) => {
          this.deleted = true;
        },
        (error) => {
          this.deleted = true;
        }
      )
  }

}
