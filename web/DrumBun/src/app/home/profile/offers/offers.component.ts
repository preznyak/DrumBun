import {Component, Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OfferModel} from "../../../_models/offer.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
@Injectable()
export class OffersComponent implements OnInit {
  offers: OfferModel[];

  constructor(private httpClient: HttpClient,
              private router: Router) {
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
    this.router.navigate(['create-offer']);
    console.log("new Offer Clicked");
  }

}
