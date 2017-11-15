import {Injectable} from "@angular/core";
import {Http} from "@angular/http";

@Injectable()
export class RequestService{
  constructor(private http: Http){}

  sendRequest(trips: any[]){
    return this.http.post('https://drumbun-backend.firebaseio.com/data.json',trips);
  }
}
