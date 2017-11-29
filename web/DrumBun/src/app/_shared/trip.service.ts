import {Trip} from "../_models/trip.model";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class TripService {

  private apiUrl = 'http://localhost:8080';

  private trips: Trip[] = [
    new Trip(1, 1, "fromTestTrip1", "toTestTrip", "foo", "now"),
    new Trip(2, 2, "fromTestTrip2", "toTestTrip", "foo", "now"),
    new Trip(3, 3, "fromTestTrip3", "toTestTrip", "foo", "now"),
  ];

  constructor(private httpClient: HttpClient) {
  }

  fetchData(from: string, to: string, type: string, when: string) {
    return this.httpClient.get(this.apiUrl + "/getsomething/" + from + "/" + to + "/" + type + "/" + when)
    // return this.httpClient.get(this.apiUrl + "/getsomething", JSON.stringify({
    //   from: from,
    //   to: to,
    //   type: type,
    //   date: when
    // }))
      .subscribe(
        (response: Trip[]) => this.trips = response,
        (error) => console.log(error)
      )
  }

  getTrips() {
    return this.trips.slice();
  }

}
