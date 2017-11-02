package hu.drumbun.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Offer")
public class Offer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @JoinColumn(table = "User", name = "user_id", referencedColumnName = "id")
    private long userId;

    @JoinColumn(table = "Path", name = "path_id", referencedColumnName = "id")
    private long pathId;

    @Column(name = "start_place",nullable = false)
    private String startPlace;

    @Column(name = "comment")
    private String comment;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    public Offer(long id, long userId, long pathId, String startPlace, String comment, Date startTime) {
        this.id = id;
        this.userId = userId;
        this.pathId = pathId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPathId() {
        return pathId;
    }

    public void setPathId(long pathId) {
        this.pathId = pathId;
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

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", userId=" + userId +
                ", pathId=" + pathId +
                ", startPlace='" + startPlace + '\'' +
                ", comment='" + comment + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
