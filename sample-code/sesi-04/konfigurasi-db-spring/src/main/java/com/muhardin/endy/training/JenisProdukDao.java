package com.muhardin.endy.training;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class JenisProdukDao {
    
    private DataSource dataSource;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psCariSemua;

    public void setDataSource(DataSource dataSource) throws Exception {
        this.dataSource = dataSource;

        String sqlInsert = "insert into jenis_produk (kode, nama) "
                + "values (?,?)";
        String sqlUpdate = "update jenis_produk set kode=?, nama=? "
                + "where id = ?";
        String sqlCariSemuaJenisProduk = "select * from jenis_produk order by kode";

        psInsert = dataSource.getConnection().prepareStatement(sqlInsert);
        psUpdate = dataSource.getConnection().prepareStatement(sqlUpdate);
        psCariSemua = dataSource.getConnection().prepareStatement(sqlCariSemuaJenisProduk);
    }
    
    public void simpan(JenisProduk jp) throws Exception {
        if (jp.getId() == null) {
            psInsert.setString(1, jp.getKode());
            psInsert.setString(2, jp.getNama());

            psInsert.executeUpdate();
        } else {
            psUpdate.setString(1, jp.getKode());
            psUpdate.setString(2, jp.getNama());
            psUpdate.setInt(5, jp.getId());

            psUpdate.executeUpdate();
        }
    }
    
    public List<JenisProduk> cariSemuaJenisProduk() throws Exception {
        List<JenisProduk> hasil = new ArrayList<JenisProduk>();
        
        ResultSet rs = psCariSemua.executeQuery();
        while(rs.next()){
            JenisProduk jp = new JenisProduk();
            jp.setId(rs.getInt("id"));
            jp.setKode(rs.getString("kode"));
            jp.setNama(rs.getString("nama"));
            hasil.add(jp);
        }
        
        return hasil;
    }
}
