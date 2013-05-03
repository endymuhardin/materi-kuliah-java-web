<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Produk</title>
    </head>
    <body>
        <h1>Edit Produk</h1>
        
        <form method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Kode</td>
                        <td>
                            <input name="kode">
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>
                            <input type="text" name="nama" value="" />
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Harga</td>
                        <td>
                            <input type="text" name="harga" value="" />
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td> <input type="submit" value="Simpan"> </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
    </body>
</html>
