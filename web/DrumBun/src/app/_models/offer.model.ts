export class OfferModel{
  constructor(public id: number,
              public path: Path,
              public userUsername: string,
              public date: string,
              public comment: string,
              public passengers: Passengers[],
              public maxSeats: number,
              public occupiedSeats: number){}
}

export class Path{
  constructor(public id: number,
              public start: string,
              public enroute: string,
              public destination: string){
  }
}

export class Passengers{
  constructor(public username: string){}
}
