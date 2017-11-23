export class UserprofileModel{
  constructor(
    public username: string,
    public firstName: string,
    public lastName: string,
    public email: string,
    public details: DetailsModel
  ){}
}

export class DetailsModel{
  constructor(
    public image: string,
    public bio: string,

    public phoneNumber: string,
    public facebookProfile: string,

    public city: string,
    public country: string,

    public gender: string,
    public driverLicense: string,

    public birthDate: string){}

}

