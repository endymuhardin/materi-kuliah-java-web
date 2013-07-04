<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Produk</title>
    </head>
    <body>
        <h1>Daftar Produk</h1>
        
        <a href="edit-produk">Tambah Data Produk</a> <br>
       
        Download data produk <a href="download-produk?format=xls">XLS</a> | 
        <a href="download-produk?format=pdf">PDF</a> 
        
        <table border="1">
            <thead>
                <tr>
                    <th>Kode</th>
                    <th>Nama</th>
                    <th>Harga</th>
                    <th>Terakhir Update</th>
                    <th>Foto</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produk" items="${daftarProduk}">
                <tr>
                    <td>${produk.kode}</td>
                    <td>${produk.nama}</td>
                    <td>${produk.harga}</td>
                    <td>${produk.terakhirUpdate}</td>
                    <td>
                        <img src="${produk.gambar}">
                    </td>
                    <td>
                        <a href="edit-produk?id=${produk.id}">edit</a> | 
                        <a href="hapus-produk?id=${produk.id}">hapus</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
