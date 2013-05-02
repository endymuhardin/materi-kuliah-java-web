# Filter #

## Menggunakan Sitemesh untuk mendekorasi response ##

Sitemesh adalah library yang bisa digunakan untuk mendekorasi 
response yang dihasilkan oleh aplikasi web kita. 
Dengan menggunakan sitemesh, kita bisa mengaplikasikan suatu template/theme
tanpa harus copy/paste di seluruh halaman jsp/html/servlet kita.

Berikut adalah langkah-langkah untuk menggunakan Sitemesh.

1. Siapkan maven project untuk aplikasi web. Cara menyiapkan aplikasi web bisa dibaca di [materi intro](https://github.com/endymuhardin/materi-kuliah-java-web/blob/master/materi-kuliah/01-intro.md).


2. Download template css gratis yang banyak tersedia di internet. Misalnya di [Website Free Css Template](http://www.freecsstemplates.org/)


3. Extract dan masukkan di folder `src/main/webapp`


4. Tambahkan dependensi sitemesh di `pom.xml`

    ```xml
    <dependency>
        <groupId>opensymphony</groupId>
        <artifactId>sitemesh</artifactId>
        <version>2.4.2</version>
    </dependency>
    ```

5. Pasang filter sitemesh di `web.xml`

    ```xml
    <filter>
        <filter-name>sitemesh</filter-name>
        <filter-class>com.opensymphony.sitemesh.webapp.SiteMeshFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>sitemesh</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    ```

6. Buat konfigurasi `decorators.xml`

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <decorators defaultdir="/WEB-INF/decorators">
        <excludes>
            <pattern>/login.html</pattern>
        </excludes>
        <decorator name="utama" page="template-utama.jsp">
            <pattern>/*</pattern>
        </decorator>
    </decorators>
    ```

7. Buat template sitemesh
   
   * tambahkan deklarasi taglib sitemesh
   
   ```jsp
   <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
   ```

   * gunakan taglib sitemesh, yaitu `<decorator:head>`, `<decorator:title>`, dan `<decorator:body>`
   
