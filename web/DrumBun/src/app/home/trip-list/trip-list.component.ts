import {Component, OnInit} from '@angular/core';
import {NeedModel} from "../../_models/need.model";
import {NeedService} from "../../_shared/need.service";
import {OfferModel} from "../../_models/offer.model";
import {OfferService} from "../../_shared/offer.service";
import {Subscription} from "rxjs/Subscription";
import {CommunicationService} from "../../_shared/communication.service";

@Component({
  selector: 'app-trip-list',
  templateUrl: './trip-list.component.html',
  styleUrls: ['./trip-list.component.css']
})
export class TripListComponent implements OnInit {
  needs: NeedModel[];
  offers: OfferModel[];
  needData: boolean;


  private subscription: Subscription;

  constructor(private needService: NeedService,
              private offerService: OfferService,
              private communcationService: CommunicationService) {
  }

  ngOnInit() {
    this.subscription = this.communcationService.notifyObservable$.subscribe((res) => {
      if (res.hasOwnProperty('type') && res.type === 'offers') {
        this.needData = false;
        this.offers = this.offerService.getOffers();
        // this.offerService.fetchData(res.from, res.to, res.type, res.date, res.time);
      }
      if (res.hasOwnProperty('type') && res.type === 'needs') {
        this.needData = true;
        this.needs = this.needService.getNeeds();
        // this.needService.fetchData(res.from, res.to, res.type, res.date, res.time);
      }
    });
    // this.needData = true;
    // this.needs = this.needService.getNeeds();
    // this.offers = this.offerService.getOffers();
  }

}
