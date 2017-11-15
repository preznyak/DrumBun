import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent implements OnInit {
  @ViewChild('search') searchForm: NgForm;

  constructor() {
  }

  ngOnInit() {
  }

  justLog(){
    console.log("From: " + this.searchForm.value.fromLocation +
                "\nTo:" + this.searchForm.value.toLocation +
                "\nType: " + this.searchForm.value.searchType)
  }

}
