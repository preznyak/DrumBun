package hu.drumbun.controller.user.model;

import hu.drumbun.controller.userprofile.model.UserProfileResponse;
import hu.drumbun.entities.UserProfile;

public class UserResponse {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private UserProfile userProfile;

    public UserResponse() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
