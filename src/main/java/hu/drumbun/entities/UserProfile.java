package hu.drumbun.entities;

import hu.drumbun.enums.DriverLicense;
import hu.drumbun.enums.Gender;

import javax.persistence.*;
import java.util.Date;

/**
 * <h1>User profile class</h1>
 * A class that stores the user's profile (birthdate,gender,etc.)
 *
 * @author Preznyak Laszlo
 * @version 1.0
 */

@Entity(name = "Profile")
public class UserProfile {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @OneToOne(targetEntity = User.class)
    private User user;

    @Column(name = "fullName",nullable = false)
    private String fullName;

    @Column(name = "birthDate",nullable = false)
    private Date birthDate;
    //Profile picture needed.

    @Column(name = "gender",nullable = false)
    private Gender gender;

    @Column(name = "driverLicense",nullable = false)
    private DriverLicense driverLicense;

    public UserProfile(User user, String fullName, Date birthDate, Gender gender, DriverLicense driverLicense) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", driverLicense=" + driverLicense +
                '}';
    }
}
