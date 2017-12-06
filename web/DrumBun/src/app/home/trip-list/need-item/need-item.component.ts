import {Component, Injectable, Input, OnInit} from '@angular/core';
import {NeedModel} from "../../../_models/need.model";
import {NeedService} from "../../../_shared/need.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-need-item',
  templateUrl: './need-item.component.html',
  styleUrls: ['./need-item.component.css']
})

@Injectable()
export class NeedItemComponent implements OnInit {
  @Input() need: NeedModel;

  constructor(private needService: NeedService,
              private router: Router) {
  }

  ngOnInit() {
  }

  giveOffer(index: number){
    this.needService.giveOffer(index);
  }

  navigateToProfileOf(username: string){
    this.router.navigate(['profileof/' + username]);
  }

}
