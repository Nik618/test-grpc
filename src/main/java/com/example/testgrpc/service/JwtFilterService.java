package com.example.testgrpc.service;

import com.example.testgrpc.JwtAuthentication;
import com.example.testgrpc.service.JwtProviderService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;
import java.util.ArrayList;

import io.jsonwebtoken.Claims;

@Component
public class JwtFilterService extends GenericFilterBean {

    private static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtProviderService jwtProviderService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String token = getTokenFromRequest((HttpServletRequest) request);
        if (token != null && jwtProviderService.validateAccessToken(token)) {
            Claims claims = jwtProviderService.getAccessClaims(token);
            JwtAuthentication jwtInfoToken = generate(claims);
            if (jwtInfoToken != null) {
                jwtInfoToken.setAuthenticated(true);
                SecurityContextHolder.getContext().setAuthentication(jwtInfoToken);
            }
        }

        chain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }

    private JwtAuthentication generate(Claims claims) {
        if (claims != null) {
            JwtAuthentication jwtInfoToken = new JwtAuthentication();
            jwtInfoToken.setRoles((ArrayList<String>) claims.get("roles"));
            jwtInfoToken.setFirstName(claims.get("sub", String.class));
            jwtInfoToken.setUsername(claims.getSubject());
            return jwtInfoToken;
        }
        return null;
    }
}