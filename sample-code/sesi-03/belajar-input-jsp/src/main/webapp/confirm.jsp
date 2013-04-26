<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Konfirmasi Input</title>
    </head>
    <body>
        <h1>Periksa Input Anda</h1>

        <table border="0">
            <tbody>
                <tr>
                    <td>Nama</td>
                    <td> <%= request.getParameter("nama") %> </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td> <%= request.getParameter("email") %> </td>
                </tr>
                <tr>
                    <td> Jenis Kelamin </td>
                    <td>
                        <%= request.getParameter("jenis") %>
                    </td>
                </tr>
                <tr>
                    <td>Jurusan</td>
                    <td>
                        <%= request.getParameter("jurusan") %>
                    </td>
                </tr>
                <tr>
                    <td>Tanggal Masuk</td>
                    <td>
                        <%= request.getParameter("tanggal_masuk") %>
                    </td>
                </tr>
                <tr>
                    <td valign="top">Minat</td>
                    <td>
                        <% String[] minat = request.getParameterValues("minat"); %>
                        <ul>
                            <% for(int i = 0; i<minat.length; i++) { %>
                                <li><%= minat[i] %></li>
                            <% } %>
                        </ul>
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

    </body>
</html>
