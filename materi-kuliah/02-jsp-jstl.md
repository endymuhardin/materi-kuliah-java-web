# JSP dan JSTL #

* Referensi : [Tutorials Point](http://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm)

## JSP ##

* Singkatan dari Java Server Pages
* **Berbeda** dengan Java Server Faces (JSF)

### JSP Scriptlet ###

* Scriptlet adalah potongan kode program Java di dalam JSP. 
* Scriptlet ditandai dengan `<% kode program %>`

Contoh kode program

```jsp
Waktu saat ini : <% out.println(new java.util.Date()); %>
```

### JSP Expression ###

* Expression adalah potongan kode program yang setelah dijalankan 
akan langsung ditampilkan ke halaman HTML. 
* Ini biasa dipakai untuk menghilangkan penulisan `out.println`

Contoh kode program

```jsp
Waktu saat ini : <%= new java.util.Date() %>
```

### JSP Built-in Variabel ###

JSP memiliki beberapa variabel yang siap kita gunakan, yaitu : 

* request : HttpServletRequest object
* response : HttpServletResponse object
* out : PrintWriter object yang bisa digunakan untuk menampilkan tulisan ke halaman HTML
* session : HttpSession object
* application : ServletContext object
* config : ServletConfig object untuk page yang sedang diakses.
* pageContext : fitur khusus di server, misalnya JspWriters.
* page : sama dengan `this`
* Exception : Exception object (kalau ada) bila ingin ditampilkan

Contoh kode program

```jsp
Halo <%= request.getParameter("nama") %>
```

## JSTL ##

* JSTL adalah singkatan dari Java Standard Tag Library
* JSTL adalah seperangkat tag di luar tag standar HTML yang bisa kita gunakan dalam file JSP
* Bila kita menggunakan Maven, konfigurasi dependensinya adalah:

    * groupId : javax.servlet
    * artifactId : jstl
    * version : 1.2

* Agar JSTL bisa digunakan, kita harus mendeklarasikannya dulu di bagian atas file JSP seperti ini: 

    ```jsp
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    ```

* JSTL memiliki beberapa tag, yaitu : 
    
    * Core. URI : http://java.sun.com/jsp/jstl/core
    * Formatting. URI : http://java.sun.com/jsp/jstl/fmt
    * SQL. URI : http://java.sun.com/jsp/jstl/sql
    * XML. URI : http://java.sun.com/jsp/jstl/xml
    * Functions. URI : http://java.sun.com/jsp/jstl/fn


### Contoh Kode Program ###

* Untuk melakukan looping, kita bisa menggunakan tag `foreach` dalam paket `core`
* Untuk memformat tanggal dan angka, kita menggunakan tag `formatDate` dan `formatNumber` dalam paket `fmt`

Contoh kode program : 

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table>
    <tr>
        <th>No</th>
        <th>NPM</th>
        <th>Nama</th>
        <th>Tanggal Masuk</th>
        <th>IPK</th>
    </tr>
    
    <c:forEach var="mhs" items="${daftarMahasiswa}" varStatus="counter">
        <tr>
            <td><c:out value="${counter}" /></td>
            <td><c:out value="${mhs.npm}" /></td>
            <td><c:out value="${mhs.nama}" /></td>
            <td><fmt:formatDate value="${mhs.tanggalMasuk}" pattern="dd-MMM-yyyy"/></td>
            <td><fmt:formatNumber value="${mhs.ipk}" type="number" maxIntegerDigits="1" maxFractionDigits="2"/></td>
        </tr>
    </c:forEach>
</table>

```



