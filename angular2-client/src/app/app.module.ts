import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { MemberComponent } from './member/member.component';
import { HallOfFameComponent } from './hall-of-fame/hall-of-fame.component';
import {routes} from "./app.router";

@NgModule({
  declarations: [
    AppComponent,
    MemberComponent,
    HallOfFameComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routes
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
