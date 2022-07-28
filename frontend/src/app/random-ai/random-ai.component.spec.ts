import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RandomAIComponent } from './random-ai.component';

describe('RandomAIComponent', () => {
  let component: RandomAIComponent;
  let fixture: ComponentFixture<RandomAIComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RandomAIComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RandomAIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
