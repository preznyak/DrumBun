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
  offerGiven: boolean = false;

  constructor(private needService: NeedService,
              private router: Router,
              private userProfile: UserprofileService) {
  }

  ngOnInit() {
    for (var i=0; i<this.need.transporters.length; i++){
      if (this.userProfile.getUserProfile().username == this.need.transporters[i].username){
        this.offerGiven = true;
      }
    }
  }

  giveOffer(index: number){
    this.offerGiven = true;
    this.needService.giveOffer(index);
  }

  navigateToProfileOf(username: string){
    this.router.navigate(['profileof/' + username]);
  }

}
