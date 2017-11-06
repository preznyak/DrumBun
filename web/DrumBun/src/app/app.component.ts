import {Component, OnInit} from '@angular/core';
import * as firebase from 'firebase'; //mock fake backend

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  //ami az ngOnInitben van az csak a fake backend miatt kell
  ngOnInit(){
    firebase.initializeApp({
      apiKey: "AIzaSyAER8ynluOWDaJJQDm-DX1J07Dy_ypXdlI",
      authDomain: "drumbun-backend.firebaseapp.com",
    })
  }
}
