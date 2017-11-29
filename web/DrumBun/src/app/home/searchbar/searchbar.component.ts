import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Trip} from "../../_models/trip.model";
import {TripService} from "../../_shared/trip.service";

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent implements OnInit {
  @ViewChild('search') searchForm: NgForm;
  trips: Trip[];

  constructor(private tripService: TripService) {
  }

  ngOnInit() {
    this.trips = this.tripService.getTrips();
  }

  justLog() {
    console.log("From: " + this.searchForm.value.fromLocation +
      "\nTo: " + this.searchForm.value.toLocation +
      "\nType: " + this.searchForm.value.searchType +
      "\nDate: " + this.searchForm.value.date+
      "\nTime: " + this.searchForm.value.time);
  }

  fetchData() {
    this.justLog();
    // this.tripService.fetchData(this.searchForm.value.fromLocation, this.searchForm.value.toLocation, this.searchForm.value.searchType, this.searchForm.value.date);
  }

}
