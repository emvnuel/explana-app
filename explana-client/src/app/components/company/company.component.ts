import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {CompanyResponse} from "../../models/company.response.model";

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  @Input() company: CompanyResponse | undefined;

  constructor() {
  }

  ngOnInit(): void {
  }

}
