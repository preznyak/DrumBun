import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './home/header/header.component';
import { DropdownDirective } from './_shared/dropdown.directive';
import { ProfileComponent } from './home/profile/profile.component';
import { SearchbarComponent } from './home/searchbar/searchbar.component';
import { ProfileEditComponent } from './home/profile/profile-edit/profile-edit.component';
import { AppRoutingModule } from './app-routing.module';
import { RequestsComponent } from './home/profile/requests/requests.component';
import { OffersComponent } from './home/profile/offers/offers.component';

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
    OffersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
