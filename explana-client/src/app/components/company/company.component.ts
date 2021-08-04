import {Component, Input, OnInit} from '@angular/core';
import {CompanyResponse} from "../../models/company-response.model";

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  @Input() company!: CompanyResponse;

  constructor() {
  }

  ngOnInit(): void {
  }

}
