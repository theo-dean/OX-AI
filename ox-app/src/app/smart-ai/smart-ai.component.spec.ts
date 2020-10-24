import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartAiComponent } from './smart-ai.component';

describe('SmartAiComponent', () => {
  let component: SmartAiComponent;
  let fixture: ComponentFixture<SmartAiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SmartAiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SmartAiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
