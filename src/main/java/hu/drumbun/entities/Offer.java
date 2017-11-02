package hu.drumbun.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Offer")
public class Offer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @OneToOne(targetEntity = Path.class)
    private Path path;

    @Column(name = "start_place",nullable = false)
    private String startPlace;

    @Column(name = "comment")
    private String comment;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    public Offer(User user, Path path, String startPlace, String comment, Date startTime) {
        this.user = user;
        this.path = path;
        this.startPlace = startPlace;
        this.comment = comment;
        this.startTime = startTime;
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

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

}
