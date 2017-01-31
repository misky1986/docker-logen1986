import { ModuleWithProviders } from "@angular/core";
import { Routes, RouterModule } from  "@angular/router";

import { MemberComponent } from "./member/member.component";
import { HallOfFameComponent } from "./hall-of-fame/hall-of-fame.component";

export const router: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full'},
  { path: 'member', component: MemberComponent },
  { path: 'hall-of-fame', component: HallOfFameComponent }
];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);
