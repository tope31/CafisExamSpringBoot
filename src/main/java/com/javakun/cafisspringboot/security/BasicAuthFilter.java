package com.javakun.cafisspringboot.security;

import com.javakun.cafisspringboot.util.MD5Hash;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;

@Component
public class BasicAuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String authHeader = httpRequest.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, "UTF-8");

            final String[] values = credentials.split(":", 2);

            if (values.length == 2) {
                String username = values[0];
                String password = values[1];

                MD5Hash md5Hash = new MD5Hash();
                String hashedPassword = md5Hash.toMD5(password);

                if (md5Hash.authenticate(username, password)) {
                    Authentication auth = new UsernamePasswordAuthenticationToken(username, hashedPassword);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    chain.doFilter(request, response);
                } else {
                    httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    httpResponse.setContentType("application/json");
                    httpResponse.getWriter().write("{\"message\": \"Login Failed!\"}");
                }
            }
        }
    }
}
