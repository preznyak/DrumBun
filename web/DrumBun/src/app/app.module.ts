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
import {TripItemComponent} from './home/trip-list/trip-item/trip-item.component';
import {HttpClientModule} from "@angular/common/http";
import {HttpModule} from "@angular/http";
import {RequestService} from "./_shared/request.service";


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
    TripItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CarouselModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [AuthenticationService, AuthenticationGuardService,RequestService, User],
  bootstrap: [AppComponent]
})
export class AppModule {
}
