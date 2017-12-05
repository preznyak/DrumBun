import {Component, Input, OnInit} from '@angular/core';
import {NeedModel} from "../../../_models/need.model";

@Component({
  selector: 'app-need-item',
  templateUrl: './need-item.component.html',
  styleUrls: ['./need-item.component.css']
})
export class NeedItemComponent implements OnInit {
  @Input() need: NeedModel;

  constructor() {
  }

  ngOnInit() {
  }

}
