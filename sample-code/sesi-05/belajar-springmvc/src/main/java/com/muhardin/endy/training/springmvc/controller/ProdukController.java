package com.muhardin.endy.training.springmvc.controller;

import com.muhardin.endy.training.Produk;
import com.muhardin.endy.training.ProdukDao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProdukController {
    
    @Autowired private ProdukDao produkDao;    
    
    @RequestMapping("/produk/list")
    public ModelMap daftarProduk() throws Exception {
        List<Produk> hasil = produkDao.cariSemuaProduk();
        ModelMap mm = new ModelMap();
        mm.addAttribute("daftarProduk", hasil);
        return mm;
    }
    
    @RequestMapping(value="/produk/form", method = RequestMethod.GET)
    public void tampilkanFormProduk(){
        System.out.println("Menampilkan Form Produk");
    }
    
    @RequestMapping(value = "/produk/form", method = RequestMethod.POST)
    public String prosesFormProduk(@ModelAttribute Produk p) throws Exception {
        
        p.setTerakhirUpdate(new Date());
        
        produkDao.simpan(p);
        
        return "redirect:list";
    }
}
