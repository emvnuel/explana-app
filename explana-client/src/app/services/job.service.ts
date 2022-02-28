import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {NamedResponse} from "../models/named-response.model";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  constructor(private http: HttpClient) { }

  public findAllJobs(): Observable<NamedResponse<string>[]> {
    return this.http.get<NamedResponse<string>[]>(`${environment.baseUrl}/jobs`);
  }

  public findAllJobLevels(): Observable<NamedResponse<string>[]> {
    return this.http.get<NamedResponse<string>[]>(`${environment.baseUrl}/jobs/levels`);
  }

}
