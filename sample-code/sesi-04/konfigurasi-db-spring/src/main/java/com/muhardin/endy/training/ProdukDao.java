/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author endy
 */
@Repository
public class ProdukDao {

    @Autowired private DataSource dataSource;
    
    private String sqlInsert = "insert into produk (kode, nama, harga, terakhir_update) "
            + "values (?,?,?,?)";
    private String sqlUpdate = "update produk set kode=?, nama=?, harga=?, terakhir_update=? "
            + "where id = ?";
    private String sqlCariSemuaProduk = "select * from produk order by kode";
    private String sqlCariById = "select * from produk where id = ?";
    private String sqlHapusById = "delete from produk where id = ?";

    public void simpan(Produk p) throws Exception {
        Connection c = dataSource.getConnection();

        if (p.getId() == null) {
            PreparedStatement psInsert = c.prepareStatement(sqlInsert);
            psInsert.setString(1, p.getKode());
            psInsert.setString(2, p.getNama());
            psInsert.setBigDecimal(3, p.getHarga());
            psInsert.setDate(4, new java.sql.Date(p.getTerakhirUpdate().getTime()));

            psInsert.executeUpdate();
        } else {
            PreparedStatement psUpdate = c.prepareStatement(sqlUpdate);
            psUpdate.setString(1, p.getKode());
            psUpdate.setString(2, p.getNama());
            psUpdate.setBigDecimal(3, p.getHarga());
            psUpdate.setDate(4, new java.sql.Date(p.getTerakhirUpdate().getTime()));
            psUpdate.setInt(5, p.getId());

            psUpdate.executeUpdate();
        }
        c.close();
    }

    public List<Produk> cariSemuaProduk() throws Exception {
        List<Produk> hasil = new ArrayList<Produk>();

        Connection c = dataSource.getConnection();
        PreparedStatement psCariSemuaProduk = c.prepareStatement(sqlCariSemuaProduk);
        
        ResultSet rs = psCariSemuaProduk.executeQuery();
        while (rs.next()) {
            Produk p = konversiResultSetKeProduk(rs);
            hasil.add(p);
        }

        c.close();
        return hasil;
    }

    public Produk cariById(Integer id) throws Exception {
        if(id == null){
            return null;
        }
        Connection c = dataSource.getConnection();
        PreparedStatement psCariById = c.prepareStatement(sqlCariById);
        psCariById.setInt(1, id);
        ResultSet rs = psCariById.executeQuery();
        if(!rs.next()) {
            return null;
        }
        Produk p = konversiResultSetKeProduk(rs);
        c.close();
        return p;
    }

    private Produk konversiResultSetKeProduk(ResultSet rs) throws SQLException {
        Produk p = new Produk();
        p.setId(rs.getInt("id"));
        p.setKode(rs.getString("kode"));
        p.setNama(rs.getString("nama"));
        p.setHarga(rs.getBigDecimal("harga"));
        p.setTerakhirUpdate(rs.getDate("terakhir_update"));
        return p;
    }

    public void hapus(Integer id) throws Exception {
        if(id == null){
            return;
        }
        Connection c = dataSource.getConnection();
        PreparedStatement psHapusById = c.prepareStatement(sqlHapusById);
        psHapusById.setInt(1, id);
        psHapusById.executeUpdate();
        c.close();
    }
}
