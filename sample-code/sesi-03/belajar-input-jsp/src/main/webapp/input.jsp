<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input Data</title>
    </head>
    <body>
        <h1>Input Data</h1>
        
        <form action="confirm.jsp" method="post">
            
            <table border="0">
                <tbody>
                    <tr>
                        <td>Nama</td>
                        <td> <input name="nama"> </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td> <input type="text" name="email" value="" /> </td>
                    </tr>
                    <tr>
                        <td> Jenis Kelamin </td>
                        <td>
                            
                            <input type="radio" name="jenis" value="Pria" /> Pria
                            <input type="radio" name="jenis" value="Wanita" /> Wanita
                            
                        </td>
                    </tr>
                    <tr>
                        <td>Jurusan</td>
                        <td>
                            
                            <select name="jurusan">
                                <option value="Informatika">Informatika</option>
                                <option value="Elektro">Elektro</option>
                                <option value="Mesin">Mesin</option>
                            </select>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>Tanggal Masuk</td>
                        <td>
                            <input type="text" name="tanggal_masuk" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">Minat</td>
                        <td>
                            <input type="checkbox" name="minat" value="Java" /> Java <br>
                            <input type="checkbox" name="minat" value="PHP" /> PHP <br>
                            <input type="checkbox" name="minat" value="SQL" /> SQL <br>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" value="Simpan" />
                        </td>
                    </tr>
                </tbody>
            </table>

            
        </form>
        
    </body>
</html>
