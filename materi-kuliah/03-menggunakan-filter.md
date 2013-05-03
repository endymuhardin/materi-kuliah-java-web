# Filter #

## Menggunakan Sitemesh untuk mendekorasi response ##

Sitemesh adalah library yang bisa digunakan untuk mendekorasi 
response yang dihasilkan oleh aplikasi web kita. 
Dengan menggunakan sitemesh, kita bisa mengaplikasikan suatu template/theme
tanpa harus copy/paste di seluruh halaman jsp/html/servlet kita.

Berikut adalah langkah-langkah untuk menggunakan Sitemesh.

1. Siapkan maven project untuk aplikasi web. Cara menyiapkan aplikasi web bisa dibaca di [materi intro](https://github.com/endymuhardin/materi-kuliah-java-web/blob/master/materi-kuliah/01-intro.md). Hasil akhir dari tutorial ini bisa dilihat [di sini](https://github.com/endymuhardin/materi-kuliah-java-web/tree/master/sample-code/sesi-01/aplikasi-web-sederhana), bila memerlukan panduan tentang struktur folder dan posisi meletakkan berbagai file yang dibahas di sini.


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

7. Buat template sitemesh sesuai konfigurasi di langkah 6, yaitu file bernama `template-utama.jsp` dalam folder `src/main/webapp/WEB-INF/decorators`
   
   * tambahkan deklarasi taglib sitemesh
   
   ```jsp
   <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
   ```

   * gunakan taglib sitemesh, yaitu `<decorator:head>`, `<decorator:title>`, dan `<decorator:body>`, bisa dilihat [contohnya di sini](https://github.com/endymuhardin/materi-kuliah-java-web/blob/master/sample-code/sesi-01/aplikasi-web-sederhana/src/main/webapp/WEB-INF/decorators/template-utama.jsp) di baris `2` dan `100`. Perhatikan juga link ke `css`, `js`, dan `img` juga dibuat dinamis di baris `13`, `32`, `116`, `117`. Demikian juga dengan link URL di baris `67`.


## Menggunakan Spring Security untuk mencegat request ##

Spring Security adalah library yang memiliki fitur:

* mendefinisikan aturan keamanan untuk URL di aplikasi web kita
* mencegat semua HTTP request yang datang
* memeriksa apakah request tersebut sudah login
* memeriksa username/password pada proses login
* memeriksa apakah user yang sudah login memiliki ijin untuk mengakses URL tertentu


Berikut adalah cara menggunakan Spring Security : 

1. Tambahkan dependensi di `pom.xml`

    ```xml
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-web</artifactId>
        <version>3.1.3.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-config</artifactId>
        <version>3.1.3.RELEASE</version>
    </dependency>
    ```

2. Deklarasikan filternya di `web.xml`

    ```xml
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>
            /WEB-INF/konfig-spring-security.xml
        </param-value>
    </context-param>
    
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    
    <filter>
        <filter-name>springSecurityFilterChain</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>springSecurityFilterChain</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    ```


3. Buat file `konfig-spring-security.xml` dalam folder `src/main/webapp/WEB-INF` seperti konfigurasi di `web.xml` untuk mendefinisikan ijin akses

    ```xml
    <beans:beans xmlns="http://www.springframework.org/schema/security"
             xmlns:beans="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
            http://www.springframework.org/schema/security
            http://www.springframework.org/schema/security/spring-security-3.1.xsd">


        <http auto-config='true'>
            <intercept-url pattern="/input.jsp" access="ROLE_USER" />
        </http>
        
        <authentication-manager>
            <authentication-provider>
                <user-service>
                    <user name="endy" password="123" authorities="ROLE_USER, ROLE_ADMIN" />
                    <user name="greg" password="123" authorities="ROLE_USER" />
                </user-service>
            </authentication-provider>
        </authentication-manager>
    </beans:beans>
    ```


