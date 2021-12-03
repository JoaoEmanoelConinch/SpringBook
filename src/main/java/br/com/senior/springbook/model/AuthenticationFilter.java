package br.com.senior.springbook.model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AuthenticationFilter implements Filter{

    @Autowired
    Environment env;

    @Override
    public void doFilter(ServletRequest request, //
            ServletResponse response, //
            FilterChain chain)//
        throws IOException, ServletException {
        
        final HttpServletRequest servletRequest = (HttpServletRequest) request;
        final String authorization = servletRequest.getHeader("authorization");

        if(Tokens.tokens.contains(authorization) || env.getActiveProfiles().equals("prod") //
                || servletRequest.getRequestURI().equals("/login")){
            chain.doFilter(request, response);
        } else {
            final HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
        }
    }
    
}
