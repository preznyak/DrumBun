package hu.drumbun.controller.need.model;

import hu.drumbun.entities.Path;

public class NeedModel {

    private Path path;
    private String comment;

    public NeedModel() {
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
}
