package belajar.webdb.servlet;

import belajar.webdb.dao.ProdukDao;
import belajar.webdb.domain.Produk;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DaftarProdukServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProdukDao pd = new ProdukDao();
            pd.connect();
            List<Produk> hasil = pd.semuaProduk();
            pd.disconnect();
            
            req.setAttribute("daftarProduk", hasil);
            req.getRequestDispatcher("/daftar-produk.jsp").forward(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(DaftarProdukServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
