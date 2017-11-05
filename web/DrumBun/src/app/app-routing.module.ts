import { NgModule } from '@angular/core';
import { Routes,RouterModule } from '@angular/router';

import { ProfileComponent } from './home/profile/profile.component';
import { ProfileEditComponent } from './home/profile/profile-edit/profile-edit.component';
import { SearchbarComponent } from './home/searchbar/searchbar.component';
import { RequestsComponent } from './home/profile/requests/requests.component';
import { OffersComponent } from './home/profile/offers/offers.component';


const appRoutes: Routes = [
    { path: '', component: SearchbarComponent, pathMatch: 'full' },    
    { path: 'myrequests', component: RequestsComponent },
    { path: 'myoffers', component: OffersComponent },    
    { path: 'profile', component: ProfileComponent },
    { path: 'profile-edit', component: ProfileEditComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
