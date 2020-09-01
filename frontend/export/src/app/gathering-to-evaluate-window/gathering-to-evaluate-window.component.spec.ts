import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GatheringToEvaluateWindowComponent } from './gathering-to-evaluate-window.component';

describe('GatheringToEvaluateWindowComponent', () => {
  let component: GatheringToEvaluateWindowComponent;
  let fixture: ComponentFixture<GatheringToEvaluateWindowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GatheringToEvaluateWindowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GatheringToEvaluateWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
