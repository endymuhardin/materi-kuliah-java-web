package belajar.webdb.dao;

import belajar.webdb.domain.Produk;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdukDao {
    private Connection koneksi;
    
    public void connect() throws Exception {
        // 1. Variabel untuk koneksi
        String namaClassDbDriver = "com.mysql.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost/belajar";
        String username = "root";
        String password = "admin";
        
        // 2. Inisialisasi Driver Database
        Class.forName(namaClassDbDriver).newInstance();
        
        // 3. Connect ke database
        koneksi = DriverManager.getConnection(jdbcUrl,username, password);
    }
    
    public void disconnect() throws Exception {
        koneksi.close();
    }
    
    public void simpan(Produk p) throws Exception {
        if(p.getId() == null){
            String sql = "insert into produk (kode,nama,harga,gambar,terakhir_update) values (?,?,?,?,?)";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, p.getKode());
            ps.setString(2, p.getNama());
            ps.setBigDecimal(3, p.getHarga());
            ps.setString(4, p.getGambar());
            ps.setDate(5, new java.sql.Date(p.getTerakhirUpdate().getTime()));
            ps.executeUpdate();
        } else {
            String sql = "update produk set kode=?, nama=?, harga=?, gambar=?, terakhir_update=? where id=?";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, p.getKode());
            ps.setString(2, p.getNama());
            ps.setBigDecimal(3, p.getHarga());
            ps.setString(4, p.getGambar());
            ps.setDate(5, new java.sql.Date(p.getTerakhirUpdate().getTime()));
            ps.setInt(6, p.getId());
            ps.executeUpdate();
        }
    }
    
    public Produk cariProdukById(Integer id) throws Exception {
        String sql = "select * from produk where id=? order by kode";
        
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()){
            return null;
        }
        Produk p = konversiResultSetJadiProduk(rs);
        return p;
        
    }
    
    public List<Produk> semuaProduk() throws Exception {
        String sql = "select * from produk order by kode";
        
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<Produk> hasil = new ArrayList<Produk>();
        while(rs.next()){
            Produk p = konversiResultSetJadiProduk(rs);
            hasil.add(p);
        }
        
        return hasil;
    }

    private Produk konversiResultSetJadiProduk(ResultSet rs) throws SQLException {
        Produk p = new Produk();
        p.setId(rs.getInt("id"));
        p.setKode(rs.getString("kode"));
        p.setNama(rs.getString("nama"));
        p.setHarga(rs.getBigDecimal("harga"));
        p.setGambar(rs.getString("gambar"));
        p.setTerakhirUpdate(rs.getDate("terakhir_update"));
        return p;
    }

    public void hapus(Integer id) throws SQLException {
        String sql = "delete from produk where id = ?";
        PreparedStatement ps = koneksi.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
