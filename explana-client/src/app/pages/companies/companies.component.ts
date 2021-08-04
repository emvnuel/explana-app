import {Component, OnInit} from '@angular/core';
import {CompanyResponse} from "../../models/company-response.model";
import {CompanyService} from "../../services/company.service";

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  companies: CompanyResponse[] = [];
  paginationIndex: number = 1;
  paginationTotalElements: number = 0;
  paginationPageSize: number = 12;
  isLoading: boolean = true;

  constructor(private companyService: CompanyService) {
  }

  ngOnInit(): void {
    this.findCompanies();
  }

  onPageIndexChange(index: number) {
    window.scrollTo(0,0);
    this.findCompanies(index);
  }

  private findCompanies(index = 1) {
    this.isLoading = true;
    this.companyService.findAll(index - 1).subscribe(data => {
      this.companies = data.content;
      this.paginationIndex = data.pageable.pageNumber + 1;
      this.paginationTotalElements = data.totalElements;
      this.paginationPageSize = data.pageable.pageSize;
      this.isLoading = false;
    });
  }


}
