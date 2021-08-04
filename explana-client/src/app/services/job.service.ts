import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {NamedResponse} from "../models/named-response.model";

@Injectable({
  providedIn: 'root'
})
export class JobService {

  constructor(private http: HttpClient) { }

  public findAllJobs(): Observable<NamedResponse<string>[]> {
    return this.http.get<NamedResponse<string>[]>('http://localhost:8080/jobs');
  }

  public findAllJobLevels(): Observable<NamedResponse<string>[]> {
    return this.http.get<NamedResponse<string>[]>('http://localhost:8080/jobs/levels');
  }

}
