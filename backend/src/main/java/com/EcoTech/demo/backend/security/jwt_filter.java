package com.EcoTech.demo.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component

public class jwt_filter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            response.getWriter().println("Token não encontrado");
            response.setStatus(401);
            filterChain.doFilter(request, response);

        }
        String token = header.replace("Bearer ", "");
        jwt_service jwServ = new jwt_service();

        if (jwServ.valToken(token) == null) {
            response.setStatus(401);
            response.getWriter().println("Token invalido");
            filterChain.doFilter(request, response);
        } else {

            Long userId = jwServ.getUserId(token);
            Authentication auth = new UsernamePasswordAuthenticationToken(userId, null, null);
            context.setAuthentication(auth);
            SecurityContextHolder.getContext().setAuthentication(auth);
            filterChain.doFilter(request, response);
        }


    }
}
