import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {UserprofileService} from "../../../../_shared/userprofile.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-create-need',
  templateUrl: './create-need.component.html',
  styleUrls: ['./create-need.component.css']
})
export class CreateNeedComponent implements OnInit {
  @ViewChild('newNeedForm') needForm: NgForm;

  constructor(private httpClient: HttpClient,
              private router: Router,
              private userProfile: UserprofileService) { }

  ngOnInit() {
  }

  submitForm(){
    console.log(this.needForm.value);
    this.httpClient.post("/api/needs/new", JSON.stringify({
      "path": this.needForm.value.path,
      userUsername: this.userProfile.getUserProfile().username,
      date: this.needForm.value.date + 'T' + this.needForm.value.time + ':00',
      comment: this.needForm.value.comment
    })).subscribe(
      (response) => this.router.navigate(['/myrequests']),
      (error) => this.router.navigate(['/myrequests'])
    )

}
}
