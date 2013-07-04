/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.webdb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class DownloadProdukServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String format = req.getParameter("format");
        
        resp.getWriter().print("Ini servlet download produk, parameter format berisi: "+format);
    }
    
}
