package hu.drumbun.entities;

import hu.drumbun.enums.DriverLicense;
import hu.drumbun.enums.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <h1>User profile class</h1>
 * A class that stores the user's profile (birthdate,gender,etc.)
 *
 * @author Preznyak Laszlo
 * @version 1.0
 */

@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable{

    private static final long serialVersionUID = 1L;


    /**
     * an id for the User Profile entity
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;


    /**
     * user's birthdate
     */
    @Column(name = "birthDate")
    private Date birthDate;
    //Profile picture needed.

    /**
     * user's gender
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    /**
     * field that represents if a user have driver license
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "driverLicense")
    private DriverLicense driverLicense;

    @Column
    private String image;

    @Column
    private String bio;

    @Column
    private String phoneNumber;

    @Column
    private String facebookProfile;

    @Column
    private String city;

    @Column
    private String country;

    public UserProfile(Date birthDate, Gender gender, DriverLicense driverLicense, String image, String bio, String phoneNumber, String facebookProfile, String city, String country) {
        this.birthDate = birthDate;
        this.gender = gender;
        this.driverLicense = driverLicense;
        this.image = image;
        this.bio = bio;
        this.phoneNumber = phoneNumber;
        this.facebookProfile = facebookProfile;
        this.city = city;
        this.country = country;
    }

    public UserProfile() {
    }

    /**
     * Getter method for id
     * @return the user's id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for id
     * @param id user's id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter method for birthdate
     * @return user's birthdate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Setter method for birthdate
     * @param birthDate user's birthdate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Getter method for gender
     * @return user's gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Setter method for gender
     * @param gender user's gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Getter method for Driver license
     * @return user's driver license (yes/no)
     */
    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    /**
     * Setter method for driver license
     * @param driverLicense user's driver license
     */
    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFacebookProfile() {
        return facebookProfile;
    }

    public void setFacebookProfile(String facebookProfile) {
        this.facebookProfile = facebookProfile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * ToString method for UserProfile
     * @return string format of an UserProfile object
     */



    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", driverLicense=" + driverLicense +
                '}';
    }
}
