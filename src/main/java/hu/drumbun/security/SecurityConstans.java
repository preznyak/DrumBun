package hu.drumbun.security;

public class SecurityConstans {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_DATE = 840_000_000; //10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/registeruser";

}
