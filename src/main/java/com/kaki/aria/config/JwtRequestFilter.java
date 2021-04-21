/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.config;

import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.model.User;
import com.kaki.aria.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Jose
 */
@Component
@JsonView(User.class)
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTU jwtTokenUtil;

    @Override
    @Transactional(readOnly = true)
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
                    throws ServletException, IOException {

            final String requestTokenHeader = request.getHeader("Authorization");

            String username = null;
            String jwtToken = null;
            // JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                    jwtToken = requestTokenHeader.substring(7);
                    try {
                            username = jwtTokenUtil.extractUsername(jwtToken);
                    } catch (IllegalArgumentException e) {
                            System.out.println("Unable to get JWT Token");
                    } catch (ExpiredJwtException e) {
                            System.out.println("JWT Token has expired");
                    }
            } else {
                    logger.warn("JWT Token does not begin with Bearer String");
            }

            //Once we get the token validate it.
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                    User user = this.userService.findUserByUsername(username);

                    // if token is valid configure Spring Security to manually set authentication
                    if (jwtTokenUtil.validateToken(jwtToken, user)) {

                            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                            user, null, null);
                            usernamePasswordAuthenticationToken
                                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            // After setting the Authentication in the context, we specify
                            // that the current user is authenticated. So it passes the Spring Security Configurations successfully.
                            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
            }
            chain.doFilter(request, response);
    }

}