import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {en_US, NZ_I18N} from 'ng-zorro-antd/i18n';
import {CurrencyPipe, registerLocaleData} from '@angular/common';
import en from '@angular/common/locales/en';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {IconsProviderModule} from './icons-provider.module';
import {NzLayoutModule} from 'ng-zorro-antd/layout';
import {NzMenuModule} from 'ng-zorro-antd/menu';
import {NzBreadCrumbModule} from "ng-zorro-antd/breadcrumb";
import {WelcomeComponent} from "./pages/welcome/welcome.component";
import {NzGridModule} from "ng-zorro-antd/grid";
import {NzStatisticModule} from "ng-zorro-antd/statistic";
import {NzSpaceModule} from "ng-zorro-antd/space";
import {CompaniesComponent} from './pages/companies/companies.component';
import {SalariesComponent} from './pages/salaries/salaries.component';
import {AboutUsComponent} from './pages/about-us/about-us.component';
import {NzCardModule} from "ng-zorro-antd/card";
import {CompanyComponent} from './components/company/company.component';
import {NzPaginationModule} from "ng-zorro-antd/pagination";
import {NzSkeletonModule} from "ng-zorro-antd/skeleton";
import {CardListSkeletonComponent} from "./components/card-list-skeleton/card-list-skeleton.component";
import {CompanyDetailsComponent} from './pages/companies/company-details/company-details.component';
import {NzPageHeaderModule} from "ng-zorro-antd/page-header";
import {NzAvatarModule} from "ng-zorro-antd/avatar";
import {NzDropDownModule} from "ng-zorro-antd/dropdown";
import {NzTagModule} from "ng-zorro-antd/tag";
import {NzTabsModule} from "ng-zorro-antd/tabs";
import {NzButtonModule} from "ng-zorro-antd/button";
import {NzRateModule} from "ng-zorro-antd/rate";
import { ReviewComponent } from './components/review/review.component';
import { ReviewsComponent } from './pages/reviews/reviews.component';
import {NzFormModule} from "ng-zorro-antd/form";
import {NzSelectModule} from "ng-zorro-antd/select";
import {NzInputModule} from "ng-zorro-antd/input";
import { JobSelectComponent } from './components/job-select/job-select.component';
import { JobLevelsSelectComponent } from './components/job-levels-select/job-levels-select.component';
import {NzInputNumberModule} from "ng-zorro-antd/input-number";
import {NzNotificationModule} from "ng-zorro-antd/notification";
import {NzTypographyModule} from "ng-zorro-antd/typography";

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    CompaniesComponent,
    SalariesComponent,
    AboutUsComponent,
    CompanyComponent,
    CardListSkeletonComponent,
    CompanyDetailsComponent,
    ReviewComponent,
    ReviewsComponent,
    JobSelectComponent,
    JobLevelsSelectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    IconsProviderModule,
    NzLayoutModule,
    NzMenuModule,
    NzBreadCrumbModule,
    NzGridModule,
    NzStatisticModule,
    NzSpaceModule,
    NzCardModule,
    NzPaginationModule,
    NzSkeletonModule,
    NzPageHeaderModule,
    NzAvatarModule,
    NzDropDownModule,
    NzTagModule,
    NzTabsModule,
    NzButtonModule,
    NzRateModule,
    NzFormModule,
    NzSelectModule,
    NzInputModule,
    NzInputNumberModule,
    NzNotificationModule,
    NzTypographyModule
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }, CurrencyPipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
