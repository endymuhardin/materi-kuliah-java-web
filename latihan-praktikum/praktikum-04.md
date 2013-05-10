# Praktikum 4 #

* Waktu : 200 menit
* Keterangan : melanjutkan project praktikum sebelumnya

1. Konversi project menjadi aplikasi web

2. Buatlah form JSP untuk entri data produk

3. Buatlah halaman JSP untuk menampilkan data produk

4. Tambahkan dependensi Spring MVC 

        * groupId : org.springframework
        * artifactId : spring-webmvc
        * version : 3.2.2.RELEASE

5. Tambahkan dependensi JSTL

        * groupId : javax.servlet
        * artifactId : jstl
        * version : 1.2

6. Inisialisasi konfigurasi Spring di web.xml

        * contextConfigLocation : classpath:nama-file-konfigurasi-spring.xml
        * listener-class : org.springframework.web.context.ContextLoaderListener

7. Buatlah servlet yang:

        * membaca input dari form entri produk JSP
        * membuat object Produk
        * mengambil object produkDao dari Spring
        * menyimpan object Produk menggunakan produkDao

8. Buatlah servlet yang : 

        * mengambil object produkDao dari Spring
        * mengambil data produk dari database menggunakan produkDao
        * memasukkan data produk ke request attribute
        * forward ke halaman JSP yang menampilkan data dalam bentuk tabel
