import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DefaultComponent} from "./default.component";
import {RouterModule} from "@angular/router";
import {FlexLayoutModule} from "@angular/flex-layout";
import {SharedModule} from "../../shared/shared.module";
import {DashboardComponent} from "../../pages/dashboard/dashboard.component";
import {IssueComponent} from "../../pages/issue/issue.component";
import {ProjectComponent} from "../../pages/project/project.component";



@NgModule({
  declarations: [
    DefaultComponent,
    DashboardComponent,
    IssueComponent,
    ProjectComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FlexLayoutModule,
    SharedModule
  ]
})
export class DefaultModule { }
