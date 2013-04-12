# Praktikum 2 #

* Waktu : 200 menit

1. Buatlah project java web dengan Maven sampai bisa dijalankan dari command prompt. Jangan lupa ditest dulu dengan browser dan dibuatkan screenshotnya.

2. Buatlah tampilan seperti pada screenshot berikut. Tanggal dan waktu dinamis tergantung waktu saat ini.
    
    ![Waktu sekarang](img/02/waktu-sekarang.png?raw=true)

3. Buatlah form buku alamat dan tampilan verifikasi seperti pada screenshot berikut ini:

    ![Input Data](img/02/input-data.png?raw=true)
    
    ![Verifikasi Data](img/02/verifikasi-data.png?raw=true)

4. Tampilkan data produk dari database menggunakan JSTL seperti screenshot berikut:

    ![Daftar Produk](img/02/daftar-produk.png?raw=true)


Struktur tabel : 

```sql
create table produk (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    kode VARCHAR(30), 
    nama VARCHAR(255),
    harga DECIMAL(19,2),
    terakhir_update DATETIME
);
```


















