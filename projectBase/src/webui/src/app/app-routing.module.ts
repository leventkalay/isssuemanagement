import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DefaultComponent} from "./_layout/default/default.component";
import {DashboardComponent} from "./pages/dashboard/dashboard.component";
import {ProjectComponent} from "./pages/project/project.component";
import {IssueComponent} from "./pages/issue/issue.component";

const routes: Routes = [
  {
    path: '', component: DefaultComponent,
    children: [
      {path: '', pathMatch: 'full', redirectTo: 'dashboard'},
      {path: 'issue', component: IssueComponent},
      {path: 'dashboard', component: DashboardComponent},
      {path: 'project', component: ProjectComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
