import { Component, OnInit } from '@angular/core';
import {Trip} from "../../_models/trip.model";

@Component({
  selector: 'app-trip-list',
  templateUrl: './trip-list.component.html',
  styleUrls: ['./trip-list.component.css']
})
export class TripListComponent implements OnInit {
  trips: Trip[] = [
    new Trip(1,1,"fromTestTrip","toTestTrip","foo","now")
  ];

  constructor() { }

  ngOnInit() {
  }

}
