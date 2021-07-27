import {ComponentFixture, TestBed} from '@angular/core/testing';

import {CardListSkeletonComponent} from './card-list-skeleton.component';

describe('CardListSkeletonComponent', () => {
  let component: CardListSkeletonComponent;
  let fixture: ComponentFixture<CardListSkeletonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardListSkeletonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CardListSkeletonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
