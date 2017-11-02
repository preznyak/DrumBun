package hu.drumbun.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name ="Need")
public class Need {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @Column(name = "start")
    private String start;

    @Column(name = "destination")
    private String destination;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private Date date;

    public Need(User user, String start, String destination, String comment, Date date) {
        this.user = user;
        this.start = start;
        this.destination = destination;
        this.comment = comment;
        this.date = date;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
