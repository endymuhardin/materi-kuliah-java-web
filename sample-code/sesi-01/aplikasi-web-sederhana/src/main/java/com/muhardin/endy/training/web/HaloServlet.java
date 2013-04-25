package com.muhardin.endy.training.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HaloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
        
            System.out.println("Menjalankan method doGet");
            System.out.println("Context Path : "+req.getContextPath());
            System.out.println("Path Info : "+req.getPathInfo());
            System.out.println("Path Translated : "+req.getPathTranslated());
            System.out.println("Query String : "+req.getQueryString());
            System.out.println("Request URI : "+req.getRequestURI());
            System.out.println("Isi parameter nama : "+req.getParameter("nama"));
            System.out.println("Isi parameter email : "+req.getParameter("email"));
        
            String asal = request.getRemoteAddr();
            String nama = request.getParameter("nama");
                    
            String output = "<html>";
            output += "<body>";
            output += "<h1>Halo "+nama+"</h1>";
            output += "<h2>Anda datang dari "+asal+"</h2>";
            output += "</body>";
            output += "</html>";
            
            // content type = html
            response.setContentType("text/html");
            
            // supaya filenya didownload
            // resp.setHeader("Content-Disposition", "attachment; filename=halo.txt");
            
            response.getWriter().print(output);
        } catch (IOException ex) {
            Logger.getLogger(HaloServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
