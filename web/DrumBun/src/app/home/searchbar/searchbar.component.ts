import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {RequestService} from "../../_shared/request.service";
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

  constructor(private requestService: RequestService, private tripService: TripService) {
  }

  ngOnInit() {
    this.trips = this.tripService.getTrips();
  }

  justLog(){
    console.log("From: " + this.searchForm.value.fromLocation +
                "\nTo:" + this.searchForm.value.toLocation +
                "\nType: " + this.searchForm.value.searchType)
  }

  onTest(){
    this.requestService.sendRequest(this.trips)
      .subscribe(
        (response) => console.log(response),
        (error) => console.log(error)
      )
  }

}
