<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Produk</title>
    </head>
    <body>
        <h1>Edit Produk</h1>
        
        <spring:form modelAttribute="produk">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Kode</td>
                        <td>
                            <spring:input path="kode"/>
                        </td>
                        <td>
                            <spring:errors path="kode" />                            
                        </td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>
                            <spring:input path="nama"/>
                        </td>
                        <td>
                            <spring:errors path="nama" />    
                        </td>
                    </tr>
                    <tr>
                        <td>Harga</td>
                        <td>
                            <spring:input path="harga"/>
                        </td>
                        <td>
                            <spring:errors path="harga" />    
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td> <input type="submit" value="Simpan"> </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </spring:form>
        
    </body>
</html>
