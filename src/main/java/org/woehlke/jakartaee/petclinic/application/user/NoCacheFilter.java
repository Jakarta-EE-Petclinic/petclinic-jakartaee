package org.woehlke.jakartaee.petclinic.application.user;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter(servletNames = { "Faces Servlet" })
public class NoCacheFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader(
                "Cache-Control",
                "no-store, no-cache, must-revalidate, max-age=0");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setHeader("Pragma", "no-cache");
        chain.doFilter(request, response);
    }
}
