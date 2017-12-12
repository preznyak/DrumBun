import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {UserprofileService} from "../../../../_shared/userprofile.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {NeedModel} from "../../../../_models/need.model";

@Component({
  selector: 'app-create-need',
  templateUrl: './create-need.component.html',
  styleUrls: ['./create-need.component.css']
})
export class CreateNeedComponent implements OnInit {
  @ViewChild('newNeedForm') needForm: NgForm;
  data: NeedModel;

  constructor(private httpClient: HttpClient,
              private router: Router,
              private userProfile: UserprofileService) { }

  ngOnInit() {
  }

  submitForm(){
    console.log(this.needForm.value);

    this.data = this.needForm.value;
    this.data.path = this.needForm.value.path;
    this.data.userUsername = this.userProfile.getUserProfile().username;
    this.data.date = this.needForm.value.date + "T" + this.needForm.value.time + ":00";
    this.data.comment = this.needForm.value.comment;
    delete this.data["time"];

    this.httpClient.put("/api/needs/new", this.data)
      .subscribe(
      (response) => this.router.navigate(['/myneeds']),
      (error) => this.router.navigate(['/myneeds'])
    )

}
}
