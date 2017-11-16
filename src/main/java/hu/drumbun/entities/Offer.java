package hu.drumbun.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <h1>Offer Entity class</h1>
 * An Offer class that represents an offer in the db
 *
 * @author Preznyak Laszlo
 * @version 1.0
 */

@Entity
@Table(name = "offer")
public class Offer implements Serializable{

    private static final long serialVersionUID = 1L;


    /**
     * id of the offer
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    /**
     * user object
     */
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;

    /**
     * path object
     */
    @OneToOne(targetEntity = Path.class, fetch = FetchType.LAZY)
    private Path path;

    /**
     * starting place where the journey starts
     */
    @Column(name = "start_place",nullable = false)
    private String startPlace;

    /**
     * additional comment for the offer
     */
    @Column(name = "comment")
    private String comment;

    /**
     * starting time when the journey begins
     */
    @Column(name = "start_time", nullable = false)
    private Date startTime;

    /**
     * Constructor
     * @param user user
     * @param path path
     * @param startPlace start place
     * @param comment comment
     * @param startTime start time
     */
    public Offer(User user, Path path, String startPlace, String comment, Date startTime) {
        this.user = user;
        this.path = path;
        this.startPlace = startPlace;
        this.comment = comment;
        this.startTime = startTime;
    }

    public Offer() {
    }

    /**
     * Getter method for the id
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for the id
     * @param id offer's id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter method for the user
     * @return user
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
     * Getter method for path
     * @return the path
     */
    public Path getPath() {
        return path;
    }

    /**
     * Setter method for the path
     * @param path path
     */
    public void setPath(Path path) {
        this.path = path;
    }

    /**
     * Getter method for start place
     * @return start place
     */
    public String getStartPlace() {
        return startPlace;
    }

    /**
     * Setter method for start place
     * @param startPlace start place
     */
    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    /**
     * Getter method for comment
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter method for comment
     * @param comment comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Getter method for start time
     * @return start time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Setter method for start time
     * @param startTime start time
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * toString method for Offer class
     * @return string format of an Offer object
     */
    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", user=" + user +
                ", path=" + path +
                ", startPlace='" + startPlace + '\'' +
                ", comment='" + comment + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
