# Praktikum 2 #

* Waktu : 200 menit

1. Meneruskan aplikasi dari praktikum sebelumnya, buatlah link export data produk seperti gambar berikut

    ![Link Export Produk](img/08/export-data-produk.png?raw=true)

2. Buat desain template Jasper Report di folder `WEB-INF/templates/jrxml` menggunakan aplikasi iReport seperti pada gambar berikut

    ![Link Export Produk](img/02/daftar-produk.png?raw=true)

3. Tambahkan dependensi Jasper Report di `pom.xml`. Tambahkan juga dependensi Apache POI supaya bisa membuat file XLS.

4. Buat controller untuk menangani link export produk yang dibuat di no.1. Deteksi apakah user meminta file XLS atau PDF. Kemudian masukkan data produk yang diambil dari database dan format yang diminta ke `ModelAndView`. Kembalikan `ModelAndView` sebagai return value.

5. Buat konfigurasi Spring MVC agar terhubung dengan controller yang dibuat di no.4 dan bisa memproses template `jrxml` Jasper Report yang telah dibuat di langkah 2.
