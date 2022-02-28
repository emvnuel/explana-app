import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Page} from "../models/page.model";
import {ReviewResponse} from "../models/review-response.model";
import {ReviewRequest} from "../models/review-request.model";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http: HttpClient) { }

  public reviewCompany(companyId: string, review: ReviewRequest) {
    return this.http.post(`${environment.baseUrl}/companies/${companyId}/reviews`, review);
  }

  public findAllByCompany(companyId: string, page: number, size?: number): Observable<Page<ReviewResponse>> {
    return this.http.get<Page<ReviewResponse>>(`${environment.baseUrl}/companies/${companyId}/reviews?page=${page}`);
  }

}
