/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author endy
 */
public class HaloListener implements ServletContextListener, HttpSessionListener{

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Aplikasi start");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Aplikasi stop");
    }

    public void sessionCreated(HttpSessionEvent hse) {
        System.out.println("Ada session baru");
    }

    public void sessionDestroyed(HttpSessionEvent hse) {
        System.out.println("Session di-destroy");
    }
    
}
