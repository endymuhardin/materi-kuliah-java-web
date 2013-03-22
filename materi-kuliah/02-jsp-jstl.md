# JSP dan JSTL #

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

## JSTL ##







