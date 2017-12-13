import {Component, Injectable, Input, OnInit} from '@angular/core';
import {NeedModel} from "../../../_models/need.model";
import {NeedService} from "../../../_shared/need.service";
import {Router} from "@angular/router";
import {UserprofileService} from "../../../_shared/userprofile.service";

@Component({
  selector: 'app-need-item',
  templateUrl: './need-item.component.html',
  styleUrls: ['./need-item.component.css']
})

@Injectable()
export class NeedItemComponent implements OnInit {
  @Input() need: NeedModel;
  disabled: boolean = false;
  informationText: string;


  constructor(private needService: NeedService,
              private router: Router,
              private userProfile: UserprofileService) {
  }

  ngOnInit() {
    if (this.userProfile.getUserProfile().userProfile.driverLicense == "No"){
      this.disabled = true;
      this.informationText = "You can't give offer without license";
    }
    if (this.need.userUsername == this.userProfile.getUserProfile().username){
      this.disabled = true;
      this.informationText = "This is your need";
    }
    for (var i=0; i<this.need.transporters.length; i++){
      if (this.userProfile.getUserProfile().username == this.need.transporters[i].username){
        this.disabled = true;
        this.informationText = "Offer given";
      }

    }
  }

  giveOffer(index: number){
    this.disabled = true;
    this.needService.giveOffer(index);
  }

  navigateToProfileOf(username: string){
    this.router.navigate(['profileof/' + username]);
  }

}
