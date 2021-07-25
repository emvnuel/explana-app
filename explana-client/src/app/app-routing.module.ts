import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {WelcomeComponent} from "./pages/welcome/welcome.component";
import {CompaniesComponent} from "./pages/companies/companies.component";
import {SalariesComponent} from "./pages/salaries/salaries.component";
import {AboutUsComponent} from "./pages/about-us/about-us.component";
import {CompanyDetailsComponent} from "./pages/companies/company-details/company-details.component";

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/welcome' },
  {path: 'welcome', component: WelcomeComponent},
  {path: 'companies', component: CompaniesComponent},
  {path: 'companies/:id', component: CompanyDetailsComponent},
  {path: 'salaries', component: SalariesComponent},
  {path: 'about', component: AboutUsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
