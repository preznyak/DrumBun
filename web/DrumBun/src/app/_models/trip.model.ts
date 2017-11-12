export class Trip {
  public id: number;
  public userId: number;
  public fromLocation: string;
  public toLocation: string;
  public description: string;
  public when: string;

  constructor(id: number, userId: number, fromLocation: string, toLocation: string, description: string, when: string) {
    this.id = id;
    this.userId = userId;
    this.fromLocation = fromLocation;
    this.toLocation = toLocation;
    this.description = description;
    this.when = when;
  }
}
