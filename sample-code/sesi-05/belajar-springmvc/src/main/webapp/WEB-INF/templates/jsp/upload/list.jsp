<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hasil Upload</title>
    </head>
    <body>
        <h1>Hasil Upload</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Nama</th>
                    <th>Ukuran</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="f" items="${daftarInformasiFile}">
                <tr>
                    <td>${f.nama}</td>
                    <td>${f.ukuran}</td>
                    <td>
                        <a href="#">unduh</a> | 
                        <a href="#">hapus</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
