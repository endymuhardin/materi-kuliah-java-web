/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.webdb.servlet;

import belajar.webdb.dao.ProdukDao;
import belajar.webdb.domain.Produk;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author endy
 */
public class EditProdukServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Produk p = new Produk(); //defaultnya produk baru
        
        // cek id, kalau ada, artinya edit
        // ambil data dari database
        String strId = req.getParameter("id");
        if(strId != null && strId.trim().length() > 0){
            try {
                Integer id = Integer.valueOf(strId);
                ProdukDao pd = new ProdukDao();
                pd.connect();
                p = pd.cariProdukById(id);
                pd.disconnect();
            } catch (Exception ex) {
                Logger.getLogger(EditProdukServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        req.setAttribute("produk", p);
        req.getRequestDispatcher("/edit-produk.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // ambil data yang diisi user, masukkan ke object Produk
            Produk p = new Produk();
            
            // khusus untuk parameter id, kadang diisi kadang tidak
            String strId = req.getParameter("id");
            if(strId != null && strId.trim().length() > 0){
                p.setId(Integer.valueOf(strId));
            }
            
            p.setKode(req.getParameter("kode"));
            p.setNama(req.getParameter("nama"));
            p.setHarga(new BigDecimal(req.getParameter("harga")));
            p.setTerakhirUpdate(new Date());
            
            // simpan ke database
            ProdukDao pd = new ProdukDao();
            pd.connect();
            pd.simpan(p);
            pd.disconnect();
            
            // setelah simpan, tampilkan daftar produk
            resp.sendRedirect("daftar-produk");
        } catch (Exception ex) {
            Logger.getLogger(EditProdukServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
