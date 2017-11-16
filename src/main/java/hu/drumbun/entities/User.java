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

    /**
     * first name for the user
     */
    @Column(name = "firstname",nullable = false)
    private String firstName;

    /**
     * last name for the user
     */
    @Column(name = "lastname", nullable = false)
    private String lastName;

    /**
     * email address for the user
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * password for the user
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * the provider of the given profile  when the user sign up with Facebook or Google account
     */
    @Column(name = "oauth_provider")
    private String oauth_provider;

    /**
     * the user id from the given provider
     */
    @Column(name = "oauth_uid")
    private String oauth_uid;

    /**
     * Constructor
     *
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email the user's email
     * @param password the user's password
     * @param oauth_provider the user's profile provider's name
     * @param oauth_uid the user's id by the provider
     */
    public User(String firstName, String lastName, String email, String password, String oauth_provider, String oauth_uid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.oauth_provider = oauth_provider;
        this.oauth_uid = oauth_uid;
    }


    public User(String firstName,String lastName,String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
     *
     * @return the user's profile provider name
     */
    public String getOauth_provider() {
        return oauth_provider;
    }

    /**
     * Sets the profile provider for the user
     * @param oauth_provider the user's profile provider
     */
    public void setOauth_provider(String oauth_provider) {
        this.oauth_provider = oauth_provider;
    }

    /**
     *
     * @return the user's id from the profile provider
     */
    public String getOauth_uid() {
        return oauth_uid;
    }

    /**
     * Sets the user's oauth_id
     * @param oauth_uid the user's id given by the privider
     */
    public void setOauth_uid(String oauth_uid) {
        this.oauth_uid = oauth_uid;
    }

    /**
     * toString method for the User class
     * @return String format of the user
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", oauth_provider='" + oauth_provider + '\'' +
                ", oauth_uid='" + oauth_uid + '\'' +
                '}';
    }
}

