import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedItemComponent } from './need-item.component';

describe('NeedItemComponent', () => {
  let component: NeedItemComponent;
  let fixture: ComponentFixture<NeedItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NeedItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NeedItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
