import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {HomeComponent} from './home/home.component';
import {HeaderComponent} from './header/header.component';
import {DropdownDirective} from './_shared/dropdown.directive';
import {ProfileComponent} from './home/profile/profile.component';
import {SearchbarComponent} from './home/searchbar/searchbar.component';
import {ProfileEditComponent} from './home/profile/profile-edit/profile-edit.component';
import {AppRoutingModule} from './app-routing.module';
import {RequestsComponent} from './home/profile/requests/requests.component';
import {OffersComponent} from './home/profile/offers/offers.component';
import {FormsModule} from "@angular/forms";
import {AuthenticationService} from "./_shared/authentication.service";
import {AuthenticationGuardService} from "./_shared/authentication-guard.service";
import {User} from "./_models/user.model";
import {CarouselModule} from 'angular4-carousel';
import {SlideComponent} from './slide/slide.component';
import {TripListComponent} from './home/trip-list/trip-list.component';
import {NeedItemComponent} from './home/trip-list/need-item/need-item.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HttpModule} from "@angular/http";
import {UserService} from "./_shared/user.service";
import {TokenInterceptor} from "./_shared/token.interceptor";
import {TokenService} from "./_shared/token.service";
import {UserprofileService} from "./_shared/userprofile.service";
import {NeedService} from "./_shared/need.service";
import {OfferService} from "./_shared/offer.service";
import { OfferItemComponent } from './home/trip-list/offer-item/offer-item.component';
import { ForeignProfileComponent } from './home/profile/foreign-profile/foreign-profile.component';
import { UserOffersComponent } from './home/profile/offers/user-offers/user-offers.component';
import { UserNeedsComponent } from './home/profile/requests/user-needs/user-needs.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    HeaderComponent,
    DropdownDirective,
    ProfileComponent,
    SearchbarComponent,
    ProfileEditComponent,
    RequestsComponent,
    OffersComponent,
    SlideComponent,
    TripListComponent,
    NeedItemComponent,
    OfferItemComponent,
    ForeignProfileComponent,
    UserOffersComponent,
    UserNeedsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CarouselModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [
    AuthenticationService,
    AuthenticationGuardService,
    UserService,
    NeedService,
    OfferService,
    UserprofileService,
    User,
    TokenInterceptor,
    TokenService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
