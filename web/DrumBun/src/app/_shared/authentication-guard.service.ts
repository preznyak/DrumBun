import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {AuthenticationService} from "./authentication.service";

@Injectable()
export class AuthenticationGuardService implements CanActivate{

  constructor(private authenticationServce: AuthenticationService){

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    return this.authenticationServce.isAuthenticated();
  }
}
