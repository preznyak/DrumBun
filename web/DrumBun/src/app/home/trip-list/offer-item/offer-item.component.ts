import {Component, Injectable, Input, OnInit} from '@angular/core';
import {OfferModel} from "../../../_models/offer.model";
import {OfferService} from "../../../_shared/offer.service";
import {Router} from "@angular/router";
import {UserprofileService} from "../../../_shared/userprofile.service";

@Component({
  selector: 'app-offer-item',
  templateUrl: './offer-item.component.html',
  styleUrls: ['./offer-item.component.css']
})
@Injectable()
export class OfferItemComponent implements OnInit {
  @Input() offer: OfferModel;
  joined: boolean = false;

  constructor(private offerService: OfferService,
              private router: Router,
              private userProfile: UserprofileService) { }

  ngOnInit() {
    for (var i=0; i<this.offer.passengers.length; i++){
      if (this.userProfile.getUserProfile().username == this.offer.passengers[i].username){
        this.joined = true;
      }
    }
  }

  getIn(index: number){
    this.joined = true;
    this.offerService.getIn(index);
  }

  navigateToProfileOf(username: string){
    this.router.navigate(['profileof/' + username]);
  }

}
