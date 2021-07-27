import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CompanyResponse} from "../../../models/company-response.model";
import {CompanyService} from "../../../services/company.service";
import {CompanyDetailsResponse} from "../../../models/company-details-response.model";

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {
  company: CompanyDetailsResponse | undefined;

  constructor(private route: ActivatedRoute,private companyService: CompanyService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      let id: string = params['id'];
      this.companyService.findById(id).subscribe(value => {
        this.company = value;
      });

    });
  }

  onBack() {
    //this.router.navigate
  }
}
