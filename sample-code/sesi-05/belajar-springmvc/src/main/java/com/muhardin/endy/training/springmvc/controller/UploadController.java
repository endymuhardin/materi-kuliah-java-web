package com.muhardin.endy.training.springmvc.controller;

import com.muhardin.endy.training.springmvc.domain.InformasiFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    
    private String folderTujuanUpload = "/uploads";
    
    @RequestMapping(value="/upload/form", method = RequestMethod.GET)
    public void tampilkanFormUpload(){}
    
    @RequestMapping(value="/upload/form", method = RequestMethod.POST)
    public String prosesFormUpload(HttpSession session, @RequestParam("filegambar") MultipartFile hasilUpload) 
            {
    
        String lokasiUpload = tujuanUpload(session).getAbsolutePath();
        
        LOGGER.debug("Nama File : [{}]",hasilUpload.getOriginalFilename());
        LOGGER.debug("Ukuran File : [{}]",hasilUpload.getSize());
        LOGGER.debug("Tipe File : [{}]",hasilUpload.getContentType());
        
        File tujuan = new File(lokasiUpload + File.separator + hasilUpload.getOriginalFilename());

        try {
            hasilUpload.transferTo(tujuan);
            LOGGER.debug("File telah disimpan di [{}]", tujuan.getAbsolutePath());
        } catch (Exception ex) {
            LOGGER.error("Gagal menyimpan file hasil upload");
            LOGGER.error("Penyebab : {}", ex.getMessage());
        }
        
        return "redirect:list";
    }
    
    @RequestMapping(value="/upload/list")
    public ModelMap tampilkanHasilUpload(HttpSession session){
        ModelMap mm = new ModelMap();
        
        File folderUpload = tujuanUpload(session);
        File[] isi = folderUpload.listFiles();
        
        List<InformasiFile> daftarInformasiFile = new ArrayList<InformasiFile>();
        
        for (File f : isi) {
            InformasiFile inf = new InformasiFile();
            inf.setNama(f.getName());
            inf.setUkuran(f.length());
            daftarInformasiFile.add(inf);
        }
        
        mm.addAttribute("daftarInformasiFile", daftarInformasiFile);
        return mm;
    }

    private File tujuanUpload(HttpSession session) {
        
        String lokasiFullPath = session.getServletContext().getRealPath(folderTujuanUpload);
        LOGGER.debug("Lokasi full path : [{}]",lokasiFullPath);
        
        File hasil = new File(lokasiFullPath);
        if(!hasil.exists()){
            LOGGER.debug("Lokasi tujuan belum ada, kita buat baru saja");
            hasil.mkdirs();
        }
        
        return hasil;
    }
}
