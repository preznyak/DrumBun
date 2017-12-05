export class OfferModel{
  constructor(public id: number,
              public path: Path,
              public username: string,
              public date: string,
              public comment: string,
              public passangers: string[],
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
