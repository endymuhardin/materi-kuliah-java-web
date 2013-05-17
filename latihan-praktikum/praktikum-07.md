# Praktikum 7 #

* Waktu : 200 menit
* Keterangan : melanjutkan project praktikum sebelumnya

1. Tambahkan dependensi berikut : 
    
        * commons-io
            * groupId = commons-io
            * artifactId = commons-io
            * version = 2.4
        
        * commons-fileupload
            * groupId = commons-fileupload
            * artifactId = commons-fileupload
            * version = 1.3

2. Buat screen upload foto

    ![Screen Upload Foto](img/07/upload-foto.png?raw=true)

        *  enctype="multipart/form-data"
        *  <input type="file" name="photofile">

3. Buat controller untuk menampung hasil upload

        * method parameter : @RequestParam("photofile") MultipartFile hasilUpload
        * perintah untuk menulis hasil upload ke file : hasilUpload.transferTo

4. Buat folder tujuan untuk menampung file upload sesuai dengan coding di controller

5. Buat konfigurasi SpringMVC untuk mengaktifkan pemrosesan file upload

    ```xml
    <bean id="multipartResolver"
		class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<property name="maxUploadSize" value="1000000" />
	</bean>
    ```

6. Test aplikasi untuk mengupload file, pastikan file yang diupload sudah muncul di server

7. Buat controller untuk menampilkan isi folder tujuan upload. Untuk mendapatkan daftar file dalam folder, gunakan method [listFiles dalam class java.io.File](http://docs.oracle.com/javase/6/docs/api/java/io/File.html)

8. Buat template jsp untuk menampilkan isi folder tujuan upload

    ![Screen isi folder upload](img/07/isi-folder.png?raw=true)
