import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobLevelsSelectComponent } from './job-levels-select.component';

describe('JobLevelsSelectComponent', () => {
  let component: JobLevelsSelectComponent;
  let fixture: ComponentFixture<JobLevelsSelectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JobLevelsSelectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobLevelsSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
