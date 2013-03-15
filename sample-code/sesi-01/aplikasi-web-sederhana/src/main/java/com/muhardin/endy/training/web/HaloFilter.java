package com.muhardin.endy.training.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HaloFilter implements Filter{

    public void init(FilterConfig fc) throws ServletException {
        System.out.println("Filter diinisialisasi");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        System.out.println("Mencegat request");
        fc.doFilter(request, response);
        System.out.println("Mencegat response");
    }

    public void destroy() {
        System.out.println("Filter di-destroy");
    }
    
}
