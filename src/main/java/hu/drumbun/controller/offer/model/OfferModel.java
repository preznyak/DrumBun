package hu.drumbun.controller.offer.model;

import hu.drumbun.entities.Path;

import java.util.Date;

public class OfferModel {

    private long id;
    private Path path;
    private String comment;
    private Date startTime;

    public OfferModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
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
