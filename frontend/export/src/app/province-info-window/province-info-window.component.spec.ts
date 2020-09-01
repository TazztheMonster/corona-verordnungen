import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProvinceInfoWindowComponent } from './province-info-window.component';

describe('ProvinceInfoWindowComponent', () => {
  let component: ProvinceInfoWindowComponent;
  let fixture: ComponentFixture<ProvinceInfoWindowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProvinceInfoWindowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProvinceInfoWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
