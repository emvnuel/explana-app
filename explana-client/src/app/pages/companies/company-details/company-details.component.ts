import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CompanyService} from "../../../services/company.service";
import {CompanyDetailsResponse} from "../../../models/company-details-response.model";
import {ReviewResponse} from "../../../models/review-response.model";
import {NzButtonSize} from "ng-zorro-antd/button";
import {ReviewService} from "../../../services/review.service";

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {
  company!: CompanyDetailsResponse;
  reviews: ReviewResponse[] = [];
  size: NzButtonSize = 'large';
  reviewPaginationIndex: number = 0
  companyId: string | undefined;
  isLoadingReviews: boolean = true;
  lastPage: boolean = false;
  noReviews: boolean = false;
  formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
  });

  constructor(
    private route: ActivatedRoute,
    private companyService: CompanyService,
    private reviewService: ReviewService

  ){}

  ngOnInit() {
    this.route.params.subscribe(params => {
     this.companyId = params['id'];

      this.findCompany();
      this.findReviews();

    });
  }

  private findCompany() {
    this.companyService.findById(this.companyId!).subscribe(value => {
      this.company = value;
    });
  }

  private findReviews() {
    this.isLoadingReviews = true;
    this.reviewService.findAllByCompany(this.companyId!, this.reviewPaginationIndex).subscribe(data => {
      this.reviews.push(...data.content);
      this.isLoadingReviews = false;
      this.lastPage = data.last;
      this.noReviews = data.totalElements == 0;
    });
  }


  findMoreReviews() {
    this.reviewPaginationIndex++;
    this.findReviews()
  }
}
