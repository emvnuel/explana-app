import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-list-skeleton',
  templateUrl: './card-list-skeleton.component.html',
  styleUrls: ['./card-list-skeleton.component.css']
})
export class CardListSkeletonComponent implements OnInit {

  @Input() active: boolean | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
