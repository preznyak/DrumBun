package hu.drumbun.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <h1>Need Entity class</h1>
 * A Nedd class that represents a Need in the db
 *
 * @author Preznyak Laszlo
 * @version 1.0
 */
@Entity
@Table(name = "need")
public class Need implements Serializable{

    /**
     * id of the need
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    /**
     * user
     */
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;

    /**
     * start place of the need
     */
    @Column(name = "start")
    private String start;

    /**
     * destination
     */
    @Column(name = "destination")
    private String destination;

    /**
     * additional comment to the need
     */
    @Column(name = "comment")
    private String comment;

    /**
     * need's date
     */
    @Column(name = "date")
    private Date date;


    /**
     * Constructor
     * @param user user who created the need
     * @param start start place
     * @param destination destination
     * @param comment additional comment
     * @param date date
     */
    public Need(User user, String start, String destination, String comment, Date date) {
        this.user = user;
        this.start = start;
        this.destination = destination;
        this.comment = comment;
        this.date = date;
    }

    /**
     * Getter method for the id
     * @return id of the need
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for the id
     * @param id id of the need
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
     * Setter method for the user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter method for the start place
     * @return start place
     */
    public String getStart() {
        return start;
    }

    /**
     * Setter method for the start place
     * @param start start place
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Getter method for the destination
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Setter method for the destination
     * @param destination destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Getter method for the comment
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter method for the comment
     * @param comment comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Getter method for the date.
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter method for the date.
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * toString method for Need class
     * @return string format of a need object
     */
    @Override
    public String toString() {
        return "Need{" +
                "id=" + id +
                ", user=" + user +
                ", start='" + start + '\'' +
                ", destination='" + destination + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
