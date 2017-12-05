import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {CommunicationService} from "../../_shared/communication.service";

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent implements OnInit {
  @ViewChild('search') searchForm: NgForm;

  constructor(private communicationService: CommunicationService) {
  }

  ngOnInit() {
  }

  fetchData() {
    this.communicationService.notifyOther({from: this.searchForm.value.fromLocation,to: this.searchForm.value.toLocation,type: this.searchForm.value.searchType,date: this.searchForm.value.date,time: this.searchForm.value.time })
  }

}
