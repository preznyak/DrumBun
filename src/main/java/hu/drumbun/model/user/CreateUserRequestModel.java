package hu.drumbun.model.user;

public class CreateUserRequestModel {

    private String password;

    private String oauth_provider;

    public CreateUserRequestModel(String password, String oauth_provider) {
        this.password = password;
        this.oauth_provider = oauth_provider;
    }

    public CreateUserRequestModel() {
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
}
