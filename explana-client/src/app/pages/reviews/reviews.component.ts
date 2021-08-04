import { Component, OnInit } from '@angular/core';
import {CompanyResponse} from "../../models/company-response.model";
import {ActivatedRoute, Router} from "@angular/router";
import {CompanyService} from "../../services/company.service";
import {ReviewService} from "../../services/review.service";
import {FormBuilder, Validators} from "@angular/forms";
import {IFormBuilder, IFormGroup} from "@rxweb/types";
import {ReviewRequest} from "../../models/review-request.model";
import {CurrencyPipe} from "@angular/common";
import {ErrorService} from "../../services/error.service";

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {
  company!: CompanyResponse;
  private companyId!: string;
  form: IFormGroup<ReviewRequest>;
  fb: IFormBuilder;
  tooltips = ['terrible', 'bad', 'ok', 'good', 'wonderful'];

  formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
  });

  formatterDollar: any = (value: number) => this.formatter.format(value);
  isSendingRequest: boolean = false;

  constructor(
    private currencyPipe : CurrencyPipe,
    private route: ActivatedRoute,
    private companyService: CompanyService,
    private reviewService: ReviewService,
    private router: Router,
    private errorService: ErrorService,
    fb: FormBuilder) {

      this.fb = fb;

      this.form = this.fb.group<ReviewRequest>({
        title: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(28)]],
        job: [null, [Validators.required]],
        jobLevel: [null, [Validators.required]],
        cons: ['', [Validators.required, Validators.minLength(10)]],
        pros: ['', [Validators.required, Validators.minLength(10)]],
        rating: [null, [Validators.required, Validators.min(1), Validators.max(5)]],
        salary: [0, [Validators.required, Validators.min(0.01)]]
      });

      this.form.valueChanges.subscribe(console.log)

    }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.companyId = params['id'];

      this.findCompany();

    });
  }

  private findCompany() {

    this.companyService.findById(this.companyId).subscribe(value => {
      this.company = value;
    });

  }

  submit(review: ReviewRequest) {
    this.isSendingRequest = true;
    this.reviewService.reviewCompany(this.company.id, review).subscribe(
      async data => {
        this.isSendingRequest = false;
        await this.router.navigate(['/companies', this.company?.id])
      },
      err=> {
        this.isSendingRequest = false;
        this.errorService.handle(this.form, err);
      });
  }

}
