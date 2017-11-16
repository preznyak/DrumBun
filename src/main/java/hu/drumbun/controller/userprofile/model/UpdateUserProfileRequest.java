package hu.drumbun.controller.userprofile.model;

import hu.drumbun.entities.User;
import hu.drumbun.enums.DriverLicense;
import hu.drumbun.enums.Gender;

import java.util.Date;

public class UpdateUserProfileRequest {

    private long id;
    private Date birthDate;
    private Gender gender;
    private DriverLicense driverLicense;

    public UpdateUserProfileRequest() {
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }
}
