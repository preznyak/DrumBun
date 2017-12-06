package hu.drumbun.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @OneToOne(targetEntity = Path.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Path path;

    /**
     * additional comment for the offer
     */
    @Column(name = "comment")
    private String comment;

    /**
     * starting time when the journey begins
     */
    @Column(name = "date", nullable = false)
    private Date date;

    @OneToMany
    private List<User> passengers;

    @Column
    private int maxSeats;

    @Column
    private int occupiedSeats;

    /**
     * Constructor
     * @param user user
     * @param path path
     * @param comment comment
     * @param date start time
     * @param passengers passengers
     * @param maxSeats maxSeats
     * @param occupiedSeats occupied seats
     */

    public Offer(User user, Path path, String comment, Date date, List<User> passengers, int maxSeats, int occupiedSeats) {
        this.user = user;
        this.path = path;
        this.comment = comment;
        this.date = date;
        this.passengers = passengers;
        this.maxSeats = maxSeats;
        this.occupiedSeats = occupiedSeats;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public void setOccupiedSeats(int occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
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
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", passengers=" + passengers +
                ", maxSeats=" + maxSeats +
                ", occupiedSeats=" + occupiedSeats +
                '}';
    }
}
