package hu.drumbun.entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "Offer")
public class Offer {
    private long id;
    private long userId;
    private long pathId;
    private String startPlace;
    private String comment;
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
