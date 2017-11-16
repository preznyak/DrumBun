package hu.drumbun.controller.user.model;

public class UpdateUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String oauth_provider;
    private String oauth_uid;

    public UpdateUserRequest() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOauth_provider() {
        return oauth_provider;
    }

    public void setOauth_provider(String oauth_provider) {
        this.oauth_provider = oauth_provider;
    }

    public String getOauth_uid() {
        return oauth_uid;
    }

    public void setOauth_uid(String oauth_uid) {
        this.oauth_uid = oauth_uid;
    }
}