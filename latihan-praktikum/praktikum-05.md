# Praktikum 5 #

* Waktu : 200 menit
* Keterangan : melanjutkan project praktikum sebelumnya

1. Buatlah controller SpringMVC berupa class `ProdukController` yang berisi method `daftarProduk`
untuk menampilkan data produk dari database

2. Buatlah file `daftar-produk.jsp` untuk menampilkan data yang sudah disediakan oleh `ProdukController`

3. Buatlah file `input-produk.jsp` untuk menginput data produk ke database

4. Buatlah method `tampilkanForm` dan `prosesForm` dalam `ProdukController` 
untuk menampilkan dan memproses `input-produk.jsp`. Setelah selesai menyimpan data, redirect user ke tampilan daftar produk

5. Pasang servlet Spring MVC di `web.xml`

6. Buatlah konfigurasi Spring MVC

7. Gunakan ProdukDao dari praktikum sebelumnya untuk mengambil dan menyimpan data dalam database
