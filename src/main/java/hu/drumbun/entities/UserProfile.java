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
     * onetoone relation between a user and user profile
     */
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;

    /**
     * user's full name
     */
    @Column(name = "fullName",nullable = false)
    private String fullName;

    /**
     * user's birthdate
     */
    @Column(name = "birthDate",nullable = false)
    private Date birthDate;
    //Profile picture needed.

    /**
     * user's gender
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "gender",nullable = false)
    private Gender gender;

    /**
     * field that represents if a user have driver license
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "driverLicense",nullable = false)
    private DriverLicense driverLicense;

    /**
     * Constructor
     * @param user the user
     * @param fullName user's full name
     * @param birthDate user's birthdate
     * @param gender user's gender
     * @param driverLicense driverlicense
     */
    public UserProfile(User user, String fullName, Date birthDate, Gender gender, DriverLicense driverLicense) {
        this.user = user;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.driverLicense = driverLicense;
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
     * Getter method for user
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method for user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter method for full name attribute
     * @return user's full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Setter method for full name
     * @param fullName user's full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    /**
     * ToString method for UserProfile
     * @return string format of an UserProfile object
     */
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
