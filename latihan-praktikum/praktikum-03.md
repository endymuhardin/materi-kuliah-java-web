# Praktikum 3 #

* Waktu : 200 menit

1. Buatlah project Java dengan Maven

2. Tambahkan dependensi Spring Framework pada project tersebut

        * groupId : org.springframework
        * artifactId : spring-jdbc
        * version : 3.2.2.RELEASE

3. Tambahkan dependensi MySQL 

        * groupId : mysql
        * artifactId : mysql-connector-java
        * version : 5.1.22

4. Tambahkan dependensi commons-dbcp

        * groupId : commons-dbcp
        * artifactId : commons-dbcp
        * version : 1.4

5. Deklarasikan object berikut di konfigurasi Spring Framework

        * id : dataSource
        * class : org.apache.commons.dbcp.BasicDataSource
        * property : 
            * driverClassName : com.mysql.jdbc.Driver
            * url : jdbc:mysql://localhost/<nama-database>
            * username : <username database mysql>
            * password : <password database mysql>

6. Buatlah class Produk yang memiliki property : 

        * id : Integer
        * kode : String
        * nama : String
        * harga : BigDecimal
        * terakhirUpdate : Date

    buatkan juga getter/setternya

7. Buatlah class ProdukDao yang memiliki property : 

        * dataSource : javax.sql.DataSource
    
    dan method : 
    
        * `public void simpan(Produk p)`
        * `public List<Produk> cariSemuaProduk()`

8. Deklarasikan object ProdukDao di konfigurasi Spring Framework

9. Buat main class yang berisi : temp-praktikum-3

        * Inisialisasi Spring Framework dari file konfigurasi
        * Mengambil object `ProdukDao` dari Spring Framework
        * Membuat object `Produk` dan mengisi propertynya.
        * Memasukkan data object `Produk` ke dalam tabel `produk` (yang sudah dibuat di praktikum sebelumnya) menggunakan method `simpan` dalam ProdukDao
        * Mengambil data produk menggunakan method `cariSemuaProduk` dalam `ProdukDao` dan menampilkannya di layar
    
