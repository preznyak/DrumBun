import {Component, Input, OnInit} from '@angular/core';
import {OfferModel} from "../../../../_models/offer.model";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user-offers',
  templateUrl: './user-offers.component.html',
  styleUrls: ['./user-offers.component.css']
})
export class UserOffersComponent implements OnInit {
  @Input() offer: OfferModel;
  deleted: boolean = false;

  constructor(private router: Router,
              private httpClient: HttpClient) { }

  ngOnInit() {
  }

  seePassengerProfile(username: string){
    this.router.navigate(['profileof/' + username]);
  }

  deleteOffer(id: number){
    console.log("delete offer: "+ id);
    this.httpClient.delete("/api/offers/delete/" + id, JSON.stringify({id: id}))
      .subscribe(
        (response) => {
          this.deleted = true;
        },
        (error) => {
          this.deleted = true;
        }
      )
  }

}
