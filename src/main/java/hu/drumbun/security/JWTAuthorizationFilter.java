package hu.drumbun.security;

import hu.drumbun.controller.user.model.LoginUser;
import hu.drumbun.entities.User;
import hu.drumbun.service.user.UserService;
import hu.drumbun.service.user.converter.LoginUserConverter;
import hu.drumbun.service.user.impl.CustomUserDetailsService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private final CustomUserDetailsService customUserDetailsService;
    private final UserService userService;

//    @Autowired
//    private LoginUserConverter loginUserConverter;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, UserService userService) {
        super(authenticationManager);
        this.customUserDetailsService = customUserDetailsService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConstants.HEADER_STRING);
        if(header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)){
            chain.doFilter(request,response);
            return;
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuth = getAuthenticationToken(request);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuth);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request){
        String token = request.getHeader(SecurityConstants.HEADER_STRING);
        if(token==null) return null;
        String username = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        User user = userService.findByUsername(username);
//        LoginUser loginUser = loginUserConverter.fromUserToLoginUser(user);
        return username != null ? new UsernamePasswordAuthenticationToken(user, null, userDetails.getAuthorities()) : null;
    }
}
