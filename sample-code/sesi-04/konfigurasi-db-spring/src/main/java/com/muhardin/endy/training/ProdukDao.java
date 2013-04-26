/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhardin.endy.training;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author endy
 */
public class ProdukDao {

    private DataSource dataSource;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psCariSemuaProduk;

    public void setDataSource(DataSource dataSource) throws Exception {
        this.dataSource = dataSource;

        String sqlInsert = "insert into produk (kode, nama, harga, terakhir_update) "
                + "values (?,?,?,?)";
        String sqlUpdate = "update produk set kode=?, nama=?, harga=?, terakhir_update=? "
                + "where id = ?";
        String sqlCariSemuaProduk = "select * from produk order by kode";

        psInsert = dataSource.getConnection().prepareStatement(sqlInsert);
        psUpdate = dataSource.getConnection().prepareStatement(sqlUpdate);
        psCariSemuaProduk = dataSource.getConnection().prepareStatement(sqlCariSemuaProduk);
    }

    public void simpan(Produk p) throws Exception {
        if (p.getId() == null) {
            psInsert.setString(1, p.getKode());
            psInsert.setString(2, p.getNama());
            psInsert.setBigDecimal(3, p.getHarga());
            psInsert.setDate(4, new java.sql.Date(p.getTerakhirUpdate().getTime()));

            psInsert.executeUpdate();
        } else {
            psUpdate.setString(1, p.getKode());
            psUpdate.setString(2, p.getNama());
            psUpdate.setBigDecimal(3, p.getHarga());
            psUpdate.setDate(4, new java.sql.Date(p.getTerakhirUpdate().getTime()));
            psUpdate.setInt(5, p.getId());

            psUpdate.executeUpdate();
        }
    }

    public List<Produk> cariSemuaProduk() throws Exception {
        List<Produk> hasil = new ArrayList<Produk>();

        ResultSet rs = psCariSemuaProduk.executeQuery();
        while(rs.next()){
            Produk p = new Produk();
            p.setId(rs.getInt("id"));
            p.setKode(rs.getString("kode"));
            p.setNama(rs.getString("nama"));
            p.setHarga(rs.getBigDecimal("harga"));
            p.setTerakhirUpdate(rs.getDate("terakhir_update"));
            hasil.add(p);
        }
        
        return hasil;
    }
}
