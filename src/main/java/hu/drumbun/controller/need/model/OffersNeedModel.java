package hu.drumbun.controller.need.model;

public class OffersNeedModel {
    private long id;
    private String userUsername;

    public OffersNeedModel() {
    }

    public OffersNeedModel(long id, String userUsername) {
        this.id = id;
        this.userUsername = userUsername;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
}
