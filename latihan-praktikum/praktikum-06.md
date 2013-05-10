# Praktikum 6 #

* Waktu : 200 menit
* Keterangan : melanjutkan project praktikum sebelumnya

1. Tambahkan dependensi `hibernate-validator`

2. Gunakan annotation untuk validasi di domain object
   - @NotNull : tidak boleh null
   - @NotEmpty : mencegah string kosong "", "   "
   - @Size : membatasi panjang string
   - @Min dan @Max : membatasi nilai minimum dan maksimum
   - @Past : tanggal harus sebelum waktu sekarang

3. Aktifkan validasi di controller : 
   - pasang annotation `@Valid` di method yang menangani submit form
   - Deklarasikan BindingResult untuk menampung hasil validasi
   - kalau hasil validasi ada error, kembalikan ke form input
   - kalau tidak ada, baru save ke db dan redirect ke halaman berikut

4. Tampilkan pesan error bila validasi gagal
   - deklarasikan spring taglib
   - gunakan tag form:input untuk membuat input field 
     supaya otomatis menampilkan data sebelumnya.

5. Implementasi edit produk
   - implement cari by id di produk dao
   - dalam controller : 
     pada waktu menampilkan form, cek dulu apakah ada id. 
     Kalau ada, cari ke db. 
     Kalau tidak ketemu, new Produk
