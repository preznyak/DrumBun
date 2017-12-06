import {Component, Injectable, Input, OnInit} from '@angular/core';
import {OfferModel} from "../../../_models/offer.model";
import {OfferService} from "../../../_shared/offer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-offer-item',
  templateUrl: './offer-item.component.html',
  styleUrls: ['./offer-item.component.css']
})
@Injectable()
export class OfferItemComponent implements OnInit {
  @Input() offer: OfferModel;

  constructor(private offerService: OfferService,
              private router: Router) { }

  ngOnInit() {
  }

  getIn(index: number){
    this.offerService.getIn(index);
  }

  navigateToProfileOf(username: string){
    this.router.navigate(['profileof/' + username]);
  }

}
