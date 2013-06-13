package belajar.webdb.servlet;

import belajar.webdb.dao.ProdukDao;
import belajar.webdb.domain.Produk;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HapusProdukServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProdukDao pd = new ProdukDao();
            pd.connect();
            
            Integer id = Integer.valueOf(req.getParameter("id"));
            
            // hapus dulu gambarnya
            Produk p = pd.cariProdukById(id);
            if(p != null) {
                String lokasiGambar = req.getSession().getServletContext().getRealPath(p.getGambar());
                File gambar = new File(lokasiGambar);
                if(gambar.exists() && gambar.isFile()) {
                    gambar.delete();
                }
            
                // baru hapus di database
                pd.hapus(id);
            }
            
            pd.disconnect();
            resp.sendRedirect("daftar-produk");
        } catch (Exception ex) {
            Logger.getLogger(HapusProdukServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
