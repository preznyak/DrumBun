export class UserdetailsModel {

  profilePicture: string;

  firstName: string;
  lastName: string;
  birthdate: string;
  gender: string;
  addressCity: string;
  addressCountry: string;

  email: string;
  phone: string;

  driverLicense: string;


  constructor(profilePicture: string, firstName: string, lastName: string, birthdate: string, gender: string, addressCity: string, addressCountry: string, email: string, phone: string, driverLicense: string) {
    this.profilePicture = profilePicture;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthdate = birthdate;
    this.gender = gender;
    this.addressCity = addressCity;
    this.addressCountry = addressCountry;
    this.email = email;
    this.phone = phone;
    this.driverLicense = driverLicense;
  }
}
