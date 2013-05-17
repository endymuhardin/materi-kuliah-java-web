<%-- 
    Document   : form
    Created on : May 17, 2013, 2:05:31 PM
    Author     : endy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Upload</title>
    </head>
    <body>
        <h1>Form Upload</h1>
        
        <form method="POST" enctype="multipart/form-data">
            
            <table border="0">
                <tbody>
                    <tr>
                        <td>Pilih File</td>
                        <td>
                            
                            <input type="file" name="filegambar">
                            
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            
                            <input type="submit" value="Upload">
                            
                        </td>
                    </tr>
                </tbody>
            </table>

            
        </form>
        
    </body>
</html>
