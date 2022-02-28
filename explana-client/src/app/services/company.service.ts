import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CompanyResponse} from "../models/company-response.model";
import {Page} from "../models/page.model";
import {CompanyDetailsResponse} from "../models/company-details-response.model";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) { }

  public findAll(page: number, size?: number): Observable<Page<CompanyResponse>> {
    return this.http.get<Page<CompanyResponse>>(`${environment.baseUrl}/companies?page=${page}`);
  }

  findById(id: string): Observable<CompanyDetailsResponse> {
    return this.http.get<CompanyDetailsResponse>(`${environment.baseUrl}/companies/${id}`);
  }
}
