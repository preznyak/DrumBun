import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {ProfileComponent} from './home/profile/profile.component';
import {ProfileEditComponent} from './home/profile/profile-edit/profile-edit.component';
import {RequestsComponent} from './home/profile/requests/requests.component';
import {OffersComponent} from './home/profile/offers/offers.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {AuthenticationGuardService} from "./_shared/authentication-guard.service";
import {HomeComponent} from "./home/home.component";
import {ForeignProfileComponent} from "./home/profile/foreign-profile/foreign-profile.component";

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'myrequests', component: RequestsComponent, canActivate: [AuthenticationGuardService]},
  {path: 'myoffers', component: OffersComponent, canActivate: [AuthenticationGuardService]},
  {path: 'profile', component: ProfileComponent}, //, canActivate: [AuthenticationGuardService]
  {path: 'profileof/:username', component: ForeignProfileComponent},
  {path: 'profile-edit', component: ProfileEditComponent}, //, canActivate: [AuthenticationGuardService]
  {path: 'search', redirectTo: 'home'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: '**', redirectTo: 'login'}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
