import {Trip} from "../_models/trip.model";

export class TripService{
  private trips: Trip[] = [
    new Trip(1,1,"fromTestTrip1","toTestTrip","foo","now"),
    new Trip(2,2,"fromTestTrip2","toTestTrip","foo","now"),
    new Trip(3,3,"fromTestTrip3","toTestTrip","foo","now"),
  ];

  getTrips() {
    return this.trips.slice();
  }

}
