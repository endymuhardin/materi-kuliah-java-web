<!DOCTYPE html>
<html>
    <head>
        <title>Contoh JSP</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Contoh JSP</h1>
        
        Beberapa fitur JSP : 
        <ul>
            <li>Scriptlet</li>
            <li>Expression</li>
            <li>Variabel Built-in / Implicit Object</li>
        </ul>
        
        <h2>Contoh Scriptlet</h2>
        
        <% out.println("Halo JSP"); %>
        <br>
        <% out.println("Waktu saat ini : "+new java.util.Date()); %>
        
        <h2>Expression</h2>
        
        Waktu saat ini : <%= new java.util.Date() %>
        
        <h2>Variabel Built-in / Implicit Object</h2>
        
        Halo <%= request.getParameter("nama") %>
        
    </body>
</html>
