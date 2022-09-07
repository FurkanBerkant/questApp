package com.example.questapp.security;

import com.example.questapp.service.concretes.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    try {
        String jwtToken = extractJwtFromRequest(request);
        if (StringUtils.hasText(jwtToken) && jwtTokenProvider.validateToken(jwtToken)) {
            Long id = jwtTokenProvider.getUserIdFromJwt(jwtToken);
            System.out.println("userıd" + id);
            UserDetails user = userDetailsService.loadUserById(id);

            if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
    }
    catch(Exception e) {
        System.out.println(e.getMessage() + " hata mesaji");
        return;
    }
    filterChain.doFilter(request, response);
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        if(StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")){


            return bearer.substring("Bearer".length() + 1);
        }
        return null;
    }

}
