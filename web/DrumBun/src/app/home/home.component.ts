import {Component, OnInit} from '@angular/core';
import {TripService} from "../_shared/trip.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [TripService]
})
export class HomeComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

}
