package belajar.webdb.dao;

import belajar.webdb.domain.Produk;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class ProdukDaoTest {
    
    //@Test
    public void testSimpan() throws Exception {
        ProdukDao pd = new ProdukDao();
        pd.connect();
        
        // siapkan data
        Produk x = new Produk();
        x.setKode("X-001");
        x.setNama("Produk X");
        x.setHarga(new BigDecimal(175000));
        x.setTerakhirUpdate(new Date());
        
        // jalankan method
        pd.simpan(x);
        
        
        pd.disconnect();
    }
    
    @Test 
    public void testCariById() throws Exception{
        ProdukDao pd = new ProdukDao();
        pd.connect();
        
        Produk p = pd.cariProdukById(2);
        tampilkanDataProduk(p);
        
        pd.disconnect();
    }
    
    //@Test
    public void testSemuaProduk() throws Exception {
        System.out.println("Menjalankan Test Semua Produk");
        
        ProdukDao pd = new ProdukDao();
        pd.connect();
        
        List<Produk> hasil = pd.semuaProduk();
        for (Produk produk : hasil) {
            tampilkanDataProduk(produk);
        }
        
        pd.disconnect();
    }

    private void tampilkanDataProduk(Produk produk) {
        System.out.println("============");
        System.out.println("ID : "+produk.getId());
        System.out.println("Kode : "+produk.getKode());
        System.out.println("Nama : "+produk.getNama());
        System.out.println("Harga : "+produk.getHarga());
        System.out.println("Terakhir Update : "+produk.getTerakhirUpdate());
    }
    
}
