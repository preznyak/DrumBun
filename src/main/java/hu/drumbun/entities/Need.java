package hu.drumbun.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Path.class, cascade = CascadeType.ALL)
    private Path path;

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

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Offer> offers;

    /**
     * Constructor
     * @param user user who created the need
     * @param path path
     * @param comment additional comment
     * @param date date
     * @param offers offers
     */
    public Need(User user, Path path, String comment, Date date, List<Offer> offers) {
        this.user = user;
        this.path = path;
        this.comment = comment;
        this.date = date;
        this.offers = offers;
    }

    public Need() {
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
     * Getter method for path
     * @return path
     */
    public Path getPath() {
        return path;
    }

    /**
     * Setter method for path
     * @param path path
     */
    public void setPath(Path path) {
        this.path = path;
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

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
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
                ", path=" + path +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", offers=" + offers +
                '}';
    }
}
