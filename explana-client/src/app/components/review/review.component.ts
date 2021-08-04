import {Component, Input, OnInit} from '@angular/core';
import {ReviewResponse} from "../../models/review-response.model";

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  @Input() review!: ReviewResponse;

  constructor() { }

  ngOnInit(): void {
  }

}
