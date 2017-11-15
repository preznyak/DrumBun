import { Component, OnInit } from '@angular/core';
import {Trip} from "../../_models/trip.model";
import {TripService} from "../../_shared/trip.service";

@Component({
  selector: 'app-trip-list',
  templateUrl: './trip-list.component.html',
  styleUrls: ['./trip-list.component.css']
})
export class TripListComponent implements OnInit {
  trips: Trip[];

  constructor(private tripService: TripService) { }

  ngOnInit() {
    this.trips = this.tripService.getTrips();
  }

}
