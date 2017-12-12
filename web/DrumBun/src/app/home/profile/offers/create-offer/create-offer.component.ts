import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {UserprofileService} from "../../../../_shared/userprofile.service";
import {OfferModel} from "../../../../_models/offer.model";

@Component({
  selector: 'app-create-offer',
  templateUrl: './create-offer.component.html',
  styleUrls: ['./create-offer.component.css']
})
export class CreateOfferComponent implements OnInit {
  @ViewChild('newOfferForm') offerForm: NgForm;
  data: OfferModel;

  constructor(private httpClient: HttpClient,
              private router: Router,
              private userProfile: UserprofileService) { }

  ngOnInit() {
  }

  submitForm(){
    console.log(this.offerForm.value);

    this.data = this.offerForm.value;
    this.data.path = this.offerForm.value.path;
    this.data.userUsername = this.userProfile.getUserProfile().username;
    this.data.date = this.offerForm.value.date + "T" + this.offerForm.value.time + ":00";
    this.data.comment = this.offerForm.value.comment;
    this.data.maxSeats = this.offerForm.value.maxSeats;
    delete this.data["time"];

    this.httpClient.put("/api/offers/new", this.data
    ).subscribe(
      (response) => this.router.navigate(['/myoffers']),
      (error) => this.router.navigate(['/myoffers'])
    )
  }
}
