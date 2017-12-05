import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {NeedService} from "../../_shared/need.service";
import {OfferService} from "../../_shared/offer.service";
import {CommunicationService} from "../../_shared/communication.service";

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent implements OnInit {
  @ViewChild('search') searchForm: NgForm;

  constructor(private needService: NeedService,
              private offerService: OfferService,
              private communcationService: CommunicationService) {
  }

  ngOnInit() {
  }

  justLog() {
    console.log("From: " + this.searchForm.value.fromLocation +
      "\nTo: " + this.searchForm.value.toLocation +
      "\nType: " + this.searchForm.value.searchType +
      "\nDate: " + this.searchForm.value.date+
      "\nTime: " + this.searchForm.value.time);
  }

  fetchData() {
    this.communcationService.notifyOther({from: this.searchForm.value.fromLocation,to: this.searchForm.value.toLocation,type: this.searchForm.value.searchType,date: this.searchForm.value.date,time: this.searchForm.value.time })
    // if (this.searchForm.value.searchType.equals("offers")){
    //   this.offerService.fetchData(this.searchForm.value.fromLocation, this.searchForm.value.toLocation, this.searchForm.value.searchType, this.searchForm.value.date, this.searchForm.value.time);
    // }
    // if (this.searchForm.value.searchType.equals("needs")){
    //   this.needService.fetchData(this.searchForm.value.fromLocation, this.searchForm.value.toLocation, this.searchForm.value.searchType, this.searchForm.value.date, this.searchForm.value.time);
    // }
    this.justLog();
  }

}
