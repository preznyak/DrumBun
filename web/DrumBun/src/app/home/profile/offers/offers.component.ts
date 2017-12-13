import {Component, Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OfferModel} from "../../../_models/offer.model";
import {Router} from "@angular/router";
import {UserprofileService} from "../../../_shared/userprofile.service";

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
@Injectable()
export class OffersComponent implements OnInit {
  offers: OfferModel[];
  errorMessage: string;
  noNewOffer: string;
  disabled: boolean = false;


  constructor(private httpClient: HttpClient,
              private router: Router,
              private userProfile: UserprofileService) {
  }

  ngOnInit() {
    if (this.userProfile.getUserProfile().userProfile.driverLicense == "No"){
      this.noNewOffer = "Without driver license you cant create offers.";
      this.disabled = true;
    }
    this.httpClient.get("/api/offers/myOffers/" + this.userProfile.getUserProfile().username)
      .subscribe(
        (response: OfferModel[]) => {this.offers = response;
        console.log(this.offers);},
        (error) => this.errorMessage = error.error
      );
  }

  newOffer(){
    this.router.navigate(['create-offer']);
    console.log("new Offer Clicked");
  }

}
