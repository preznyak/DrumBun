import {Component, Input, OnInit} from '@angular/core';
import {Trip} from "../../../_models/trip.model";

@Component({
  selector: 'app-trip-item',
  templateUrl: './trip-item.component.html',
  styleUrls: ['./trip-item.component.css']
})
export class TripItemComponent implements OnInit {
  @Input() trip: Trip;

  constructor() {
  }

  ngOnInit() {
  }

}
