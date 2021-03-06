import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {OfferModel, Path} from "../_models/offer.model";
import {UserprofileService} from "./userprofile.service";

@Injectable()
export class OfferService{
  private apiUrl = 'http://localhost:8080';

  private offers: OfferModel[];
    // = [
  //   new OfferModel(1, new Path(1,"Szekelyhid","Dioszeg","Nagyvarad"),"kovaxarny","2017-12-05 17:03","Ez itt a komment helye",["ecetke","asd"],4,3),
  //   new OfferModel(2, new Path(1,"Misifalva","Dioszeg","Nagyvarad"),"kovaxarny","2017-12-05 17:03","Ez itt a komment helye",["ecetke","asd"],4,3),
  //   new OfferModel(3, new Path(1,"Karoly","Dioszeg","Nagyvarad"),"kovaxarny","2017-12-05 17:03","Ez itt a komment helye",["ecetke","asd"],4,3)
  // ];

  constructor(private httpClient: HttpClient,
              private userProfileService: UserprofileService) {
  }

  fetchData(from: string, to: string, type: string, date: string, time: string) {
    return this.httpClient.get("/api/offers/find/" + from + "/" + to + "/" + date + "T" +  time);
    // return this.httpClient.get("/api/offers");
  }

  getIn(id: number){
    return this.httpClient.post("/api/offers/joinOffer/" + id + "/" + this.userProfileService.getUserProfile().username, JSON.stringify({id: id, username: this.userProfileService.getUserProfile().username}))
      .subscribe(
        (response) => console.log(response),
        (error) => console.log(error)
      )
  }

  getOffers() {
    return this.offers.slice();
  }
}
