package com.muhardin.endy.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HaloServlet extends HttpServlet {
    
    public void doGet(
            HttpServletRequest req, 
            HttpServletResponse resp) {
        
        PrintWriter xx = null;
        try {
            
            System.out.println("Menjalankan method doGet");
            System.out.println("Context Path : "+req.getContextPath());
            System.out.println("Path Info : "+req.getPathInfo());
            System.out.println("Path Translated : "+req.getPathTranslated());
            System.out.println("Query String : "+req.getQueryString());
            System.out.println("Request URI : "+req.getRequestURI());
            System.out.println("Isi parameter nama : "+req.getParameter("nama"));
            System.out.println("Isi parameter email : "+req.getParameter("email"));
            
            
            resp.setContentType("text/plain");
            resp.setHeader("Content-Disposition", "attachment; filename=halo.txt");
            
            xx = resp.getWriter();
            xx.println("Menjalankan method <b>doGet</b> <br>");
            xx.println("Context Path : "+req.getContextPath());
            xx.println("Path Info : "+req.getPathInfo());
            xx.println("Path Translated : "+req.getPathTranslated());
            xx.println("Query String : "+req.getQueryString());
            xx.println("Request URI : "+req.getRequestURI());
            xx.println("Isi parameter nama : "+req.getParameter("nama"));
            xx.println("Isi parameter email : "+req.getParameter("email"));
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(HaloServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            xx.close();
        }
        
    }
    
}
