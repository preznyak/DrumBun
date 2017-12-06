export class NeedModel{
  constructor(public id: number,
              public path: Path,
              public userUsername: string,
              public date: string,
              public comment: string,
              public offers: string[]){}
}

export class Path{
  constructor(public id: number,
              public start: string,
              public enroute: string,
              public destination: string){
  }
}
