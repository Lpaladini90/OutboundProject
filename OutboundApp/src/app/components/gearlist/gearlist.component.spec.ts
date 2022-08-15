import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GearlistComponent } from './gearlist.component';

describe('GearlistComponent', () => {
  let component: GearlistComponent;
  let fixture: ComponentFixture<GearlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GearlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GearlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
