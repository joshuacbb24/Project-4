import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoalListingComponent } from './goal-listing.component';

describe('GoalListingComponent', () => {
  let component: GoalListingComponent;
  let fixture: ComponentFixture<GoalListingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GoalListingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GoalListingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
