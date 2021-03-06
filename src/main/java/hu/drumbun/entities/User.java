package hu.drumbun.entities;

import javax.persistence.*;
import java.io.Serializable;



/**
 * <h1>User Entity class</h1>
 * A User class that represents a user in the db
 *
 * @author Preznyak Laszlo
 * @version 1.0
 */

@Entity
@Table(name = "d_user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * an id for the user
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    /**
     * first name for the user
     */
    @Column(name = "firstname")
    private String firstName;

    /**
     * last name for the user
     */
    @Column(name = "lastname")
    private String lastName;

    /**
     * email address for the user
     */
    @Column(name = "email", unique = true)
    private String email;

    /**
     * password for the user
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * the user's profile
     */
    @OneToOne(targetEntity = UserProfile.class,fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private UserProfile userProfile;

    /**
     * Constructor
     *
     * @param username user's username
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email the user's email
     * @param password the user's password
     * @param userProfile user's profile
     */
    public User(String username, String firstName, String lastName, String email, String password, String oauth_provider, String oauth_uid, UserProfile userProfile) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userProfile = userProfile;
    }

    public User(String username, String firstName,String lastName,String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Default constructor for the User class
     */
    protected User(){}

    /**
     *  @return the user's id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the user's id
     * @param id the user's id
     */
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * gets the user's first name
     * @return user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name
     * @param firstName user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user's last name.
     * @return user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name
     * @param lastName user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's email address
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address
     * @param email the user's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's password
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password
     * @param password the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's profile
     * @return UserProfile object
     */
    public UserProfile getUserProfile() {
        return userProfile;
    }

    /**
     * Sets the user's profile
     * @param userProfile user's profile
     */
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * toString method for the User class
     * @return String format of the user
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userProfile=" + userProfile +
                '}';
    }
}

