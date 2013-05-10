package com.muhardin.endy.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JenisProdukDao {

    @Autowired private DataSource dataSource;
    private String sqlInsert = "insert into jenis_produk (kode, nama) "
            + "values (?,?)";
    private String sqlUpdate = "update jenis_produk set kode=?, nama=? "
            + "where id = ?";
    private String sqlCariSemuaJenisProduk = "select * from jenis_produk order by kode";

    public void simpan(JenisProduk jp) throws Exception {
        Connection c = dataSource.getConnection();
        if (jp.getId() == null) {

            PreparedStatement psInsert = c.prepareStatement(sqlInsert);
            psInsert.setString(1, jp.getKode());
            psInsert.setString(2, jp.getNama());

            psInsert.executeUpdate();
        } else {
            PreparedStatement psUpdate = c.prepareStatement(sqlUpdate);
            psUpdate.setString(1, jp.getKode());
            psUpdate.setString(2, jp.getNama());
            psUpdate.setInt(5, jp.getId());

            psUpdate.executeUpdate();
        }
        c.close();
    }

    public List<JenisProduk> cariSemuaJenisProduk() throws Exception {
        List<JenisProduk> hasil = new ArrayList<JenisProduk>();
        Connection c = dataSource.getConnection();
        PreparedStatement psCariSemua = dataSource.getConnection().prepareStatement(sqlCariSemuaJenisProduk);
        ResultSet rs = psCariSemua.executeQuery();
        while (rs.next()) {
            JenisProduk jp = new JenisProduk();
            jp.setId(rs.getInt("id"));
            jp.setKode(rs.getString("kode"));
            jp.setNama(rs.getString("nama"));
            hasil.add(jp);
        }
        c.close();
        return hasil;
    }
}
