import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {NeedModel, Path} from "../_models/need.model";
import {UserprofileService} from "./userprofile.service";

@Injectable()
export class NeedService{
  private apiUrl = 'http://localhost:8080';

  private needs: NeedModel[] = [
    new NeedModel(1, new Path(1,"Szekelyhid","Dioszeg","Nagyvarad"),"kovaxarny","2017-12-05 17:03","Ez itt a komment helye",["ecetke","asd"]),
    new NeedModel(2, new Path(1,"Mihalyfalva","Dioszeg","Nagyvarad"),"kovaxarny","2017-12-05 17:03","Ez itt a komment helye",["ecetke","asd"]),
    new NeedModel(3, new Path(1,"Karoly","Dioszeg","Nagyvarad"),"kovaxarny","2017-12-05 17:03","Ez itt a komment helye",["ecetke","asd"])
  ];

  constructor(private httpClient: HttpClient,
              private userProfileService: UserprofileService) {
  }


  fetchData(from: string, to: string, type: string, date: string, time: string) {
    // return this.httpClient.get(this.apiUrl + "/fetchneeds/" + from + "/" + to + "/" + type + "/" + date + "/" + time)
    return this.httpClient.get("/api/needs");
  }

  giveOffer(id: number){
    this.httpClient.post(this.apiUrl + "/giveoffer", JSON.stringify({id: id, username: this.userProfileService.getUserProfile().username}))
      .subscribe(
        (response) => console.log(response),
        (error) => console.log(error)
      )
  }

  getNeeds() {
    return this.needs.slice();
  }
}
