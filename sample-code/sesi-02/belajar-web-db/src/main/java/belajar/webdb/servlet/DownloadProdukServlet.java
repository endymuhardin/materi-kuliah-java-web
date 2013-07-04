/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.webdb.servlet;

import belajar.webdb.dao.ProdukDao;
import belajar.webdb.domain.Produk;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 *
 * @author endy
 */
public class DownloadProdukServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String format = req.getParameter("format");

            // 1. Compile jrxml menjadi jasper
            JasperReport jasper = JasperCompileManager
                    .compileReport(this.getClass().getResourceAsStream("/jrxml/daftar-produk.jrxml"));

            // 2. Isi data
            ProdukDao pd = new ProdukDao();
            pd.connect();
            List<Produk> hasil = pd.semuaProduk();
            pd.disconnect();

            Map<String, Object> daftarParameter = new HashMap<String, Object>();
            daftarParameter.put("namaManager", "Endy Muhardin");
            daftarParameter.put("tanggalCetak", new Date());

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(hasil);

            JasperPrint jrprint = JasperFillManager.fillReport(jasper, daftarParameter, dataSource);

            if ("xls".equalsIgnoreCase(format)) {
                // 3.a. Export menjadi XLS
                resp.setContentType("application/vnd.ms-excel");
                resp.setHeader("Content-Disposition", "attachment; filename=daftar-produk.xls");
                JRXlsExporter xlsExporter = new JRXlsExporter();
                xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jrprint);
                xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, resp.getOutputStream());
                xlsExporter.exportReport();
            } else if ("pdf".equalsIgnoreCase(format)) {
                // 3.b. Export menjadi PDF
                resp.setContentType("application/pdf");
                resp.setHeader("Content-Disposition", "attachment; filename=daftar-produk.pdf");
                //resp.setHeader("Content-Disposition", "inline; filename=daftar-produk.pdf");
                JasperExportManager.exportReportToPdfStream(jrprint, resp.getOutputStream());
            } 

        } catch (JRException ex) {
            Logger.getLogger(DownloadProdukServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DownloadProdukServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
