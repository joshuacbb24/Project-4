import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditGoalsComponent } from './edit-goals.component';

describe('EditGoalsComponent', () => {
  let component: EditGoalsComponent;
  let fixture: ComponentFixture<EditGoalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditGoalsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditGoalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
