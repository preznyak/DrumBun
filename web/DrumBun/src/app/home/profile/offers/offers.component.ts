import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OfferModel} from "../../../_models/offer.model";

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {
  offers: OfferModel[];

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit() {
    this.httpClient.get("/api/offers")
      .subscribe(
        (response: OfferModel[]) => {this.offers = response;
        console.log(this.offers);},
        (error) => console.log(error)
      );
  }

  newOffer(){
    //TODO new offer.
    console.log("new Offer Clicked");
  }

}
