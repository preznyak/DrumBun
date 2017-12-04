package hu.drumbun.controller.offer.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.entities.Path;
import hu.drumbun.service.JsonDateTimeSerializer;

import java.util.Date;
import java.util.List;

@JsonAutoDetect
public class OfferModel {

    private long id;
    private Path path;
    private String comment;

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private Date startTime;
    private List<NeedModel> needModels;
    private int maxSeats;

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

    public List<NeedModel> getNeedModels() {
        return needModels;
    }

    public void setNeedModels(List<NeedModel> needModels) {
        this.needModels = needModels;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }
}
