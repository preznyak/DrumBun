package hu.drumbun.controller.need.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hu.drumbun.entities.Path;
import hu.drumbun.service.JsonDateTimeSerializer;

import java.util.Date;
import java.util.List;

@JsonAutoDetect
public class NeedModel {

    private long id;
    private Path path;
    private String comment;

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private Date date;
    private String userUsername;
    private List<String> transporters;

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

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public List<String> getTransporters() {
        return transporters;
    }

    public void setTransporters(List<String> transporters) {
        this.transporters = transporters;
    }
}
