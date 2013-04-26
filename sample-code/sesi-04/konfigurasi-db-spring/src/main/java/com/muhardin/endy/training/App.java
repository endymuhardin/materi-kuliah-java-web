package com.muhardin.endy.training;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx 
                = new ClassPathXmlApplicationContext("konfigurasi-db-spring.xml");
        
        ProdukDao pd = ctx.getBean(ProdukDao.class);
        
        Produk p = new Produk();
        p.setKode("P-001");
        p.setNama("Produk 001");
        p.setHarga(new BigDecimal(100000));
        p.setTerakhirUpdate(new Date());
        
        pd.simpan(p);
        
        List<Produk> hasil = pd.cariSemuaProduk();
        for (Produk produk : hasil) {
            System.out.println("ID : "+produk.getId());
            System.out.println("Kode : "+produk.getKode());
            System.out.println("Nama : "+produk.getNama());
            System.out.println("Harga : "+produk.getHarga());
            System.out.println("Terakhir Update : "+produk.getTerakhirUpdate());
        }
    }
}
