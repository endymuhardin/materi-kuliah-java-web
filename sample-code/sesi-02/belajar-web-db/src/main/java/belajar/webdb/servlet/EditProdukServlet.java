/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.webdb.servlet;

import belajar.webdb.dao.ProdukDao;
import belajar.webdb.domain.Produk;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
        if (strId != null && strId.trim().length() > 0) {
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
            p.setTerakhirUpdate(new Date());

            if (ServletFileUpload.isMultipartContent(req)) {
                // lokasi penyimpanan gambar
                String lokasi = req.getSession().getServletContext().getRealPath("/gambar");
                System.out.println("Lokasi : " + lokasi);

                // objectnya commons-fileupload
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setRepository(new File(lokasi));
                ServletFileUpload upload = new ServletFileUpload(factory);

                // proses requestnya
                List<FileItem> hasil = upload.parseRequest(req);

                // ambil datanya
                for (FileItem fileItem : hasil) {
                    if (fileItem.isFormField()) {
                        if ("id".equals(fileItem.getFieldName())) {
                            // khusus untuk parameter id, kadang diisi kadang tidak
                            String strId = fileItem.getString();
                            if (strId != null && strId.trim().length() > 0) {
                                p.setId(Integer.valueOf(strId));
                            }
                        }
                        if ("kode".equals(fileItem.getFieldName())) {
                            p.setKode(fileItem.getString());
                        }
                        if ("nama".equals(fileItem.getFieldName())) {
                            p.setNama(fileItem.getString());
                        }
                        if ("harga".equals(fileItem.getFieldName())) {
                            p.setHarga(new BigDecimal(fileItem.getString()));
                        }
                    } else {
                        // namafile harus unik
                        String namaFile = UUID.randomUUID().toString();
                        
                        // ambil extension
                        String extensionFile = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                        
                        // tulis ke file
                        fileItem.write(new File(lokasi + File.separator + namaFile + extensionFile));
                        
                        // simpan lokasi di tabel produk
                        p.setGambar("gambar/"+namaFile + extensionFile);
                    }
                }

            } else {

                // khusus untuk parameter id, kadang diisi kadang tidak
                String strId = req.getParameter("id");
                if (strId != null && strId.trim().length() > 0) {
                    p.setId(Integer.valueOf(strId));
                }

                p.setKode(req.getParameter("kode"));
                p.setNama(req.getParameter("nama"));
                p.setHarga(new BigDecimal(req.getParameter("harga")));

            }

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
