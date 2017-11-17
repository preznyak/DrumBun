package hu.drumbun.controller.need.model;

import hu.drumbun.entities.Path;

import java.util.Date;

public class NeedModel {

    private long id;
    private Path path;
    private String comment;
    private Date date;

    public NeedModel() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
