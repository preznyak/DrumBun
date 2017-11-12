import {Component, OnInit} from '@angular/core';
import {ICarouselConfig, AnimationConfig} from 'angular4-carousel';


@Component({
  selector: 'app-slide',
  templateUrl: './slide.component.html',
  styleUrls: ['./slide.component.css']
})
export class SlideComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  public imageSources: string[] = [
    './assets/1.jpg',
    './assets/2.jpg',
    './assets/3.jpg'
  ];

  public config: ICarouselConfig = {
    verifyBeforeLoad: true,
    log: false,
    animation: true,
    animationType: AnimationConfig.SLIDE,
    autoplay: true,
    autoplayDelay: 4000,
    stopAutoplayMinWidth: 400
  };
}
