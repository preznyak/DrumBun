package hu.drumbun.entities;

import hu.drumbun.enums.DriverLicense;
import hu.drumbun.enums.Gender;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class UserProfile {

    private long id;
    private long userId;
    private String fullName;
    private Date birthDate;
    //Profile picture needed.
    private Gender gender;
    private DriverLicense driverLicense;

    public UserProfile(long id, long userId, String fullName, Date birthDate, Gender gender, DriverLicense driverLicense) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.driverLicense = driverLicense;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", driverLicense=" + driverLicense +
                '}';
    }
}
