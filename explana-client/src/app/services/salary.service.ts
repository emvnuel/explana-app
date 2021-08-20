import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Page} from "../models/page.model";
import {ReviewResponse} from "../models/review-response.model";
import {HttpClient} from "@angular/common/http";
import {SalaryStatisticResponse} from "../models/salary-statistic-response.model";

@Injectable({
  providedIn: 'root'
})
export class SalaryService {

  constructor(private http: HttpClient) { }

  public findAllByCompany(companyId: string): Observable<SalaryStatisticResponse[]> {
    return this.http.get<SalaryStatisticResponse[]>(`http://localhost:8080/companies/${companyId}/salaries`);
  }

}
