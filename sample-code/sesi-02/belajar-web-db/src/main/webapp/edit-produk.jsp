<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Produk</title>
    </head>
    <body>
        <h1>Edit Produk</h1>
        
        <!-- kalau mau upload, formnya harus menggunakan encoding multipart/form-data -->
        <form action="edit-produk" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${produk.id}">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Kode</td>
                        <td>
                            <input name="kode" value="${produk.kode}">
                        </td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>
                            <input name="nama" value="${produk.nama}">
                        </td>
                    </tr>
                    <tr>
                        <td>Harga</td>
                        <td>
                            <input name="harga" value="${produk.harga}">
                        </td>
                    </tr>
                    <tr>
                        <td>Gambar</td>
                        <td>
                            <input name="gambar" type="file">
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" value="Simpan">
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
