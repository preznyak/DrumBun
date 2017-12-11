import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {UserprofileService} from "../../../../_shared/userprofile.service";

@Component({
  selector: 'app-create-offer',
  templateUrl: './create-offer.component.html',
  styleUrls: ['./create-offer.component.css']
})
export class CreateOfferComponent implements OnInit {
  @ViewChild('newOfferForm') offerForm: NgForm;

  constructor(private httpClient: HttpClient,
              private router: Router,
              private userProfile: UserprofileService) { }

  ngOnInit() {
  }

  submitForm(){
    console.log(this.offerForm.value);
    this.httpClient.post("/api/offers/new", JSON.stringify({
      "path": this.offerForm.value.path,
      userUsername: this.userProfile.getUserProfile().username,
      date: this.offerForm.value.date + 'T' + this.offerForm.value.time + ':00',
      comment: this.offerForm.value.comment,
      maxSeats: this.offerForm.value.maxSeats
    })).subscribe(
      (response) => this.router.navigate(['/myoffers']),
      (error) => this.router.navigate(['/myoffers'])
    )
  }



}
