# Intro Aplikasi Web Java #

## Membuat Aplikasi Web Java ##

1. Buat project maven standar

        mvn archetype:create -DgroupId=com.muhardin.endy.training.web -DartifactId=aplikasi-web-sederhana

2. Ubah tipe packaging dari `jar` menjadi `war`

    ```xml
    <groupId>com.muhardin.endy.training.web</groupId>
    <artifactId>aplikasi-web-sederhana</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>
    ```

3. Buat struktur folder aplikasi web : `src/main/webapp/WEB-INF/web.xml`

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

    </web-app>
    ```

4. Buka di Netbeans

5. Test Jalankan

        mvn tomcat:run

## Membuat handler untuk HTTP request ##

Di Java, handler untuk HTTP request disebut dengan istilah `Servlet`. 
Cara membuat `Servlet` :

1. Add dependency maven (kalau belum ada)

    ```xml
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
        <scope>provided</scope>
    </dependency>
    ```

2. Buat class yang extends `HttpServlet`

    ```java
    public class HaloServlet extends HttpServlet {
    
    }
    ```

3. Implement method sesuai HTTP method yang akan kita gunakan. 

        * GET -> doGet(HttpServletRequest req, HttpServletResponse res)
        * POST -> doPost(HttpServletRequest req, HttpServletResponse res)
        * dst

    ```java
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String asal = request.getRemoteAddr();
            String nama = request.getParameter("nama");
                    
            String output = "<html>";
            output += "<body>";
            output += "<h1>Halo "+nama+"</h1>";
            output += "<h2>Anda datang dari "+asal+"</h2>";
            output += "</body>";
            output += "</html>";
            
            // content type = html
            response.setContentType("text/html");
            response.getWriter().print(output);
        } catch (IOException ex) {
            Logger.getLogger(HaloServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ```

4. Buat mappingnya di `web.xml`

    ```xml
    <servlet>
        <servlet-name>halo</servlet-name>
        <servlet-class>com.muhardin.endy.training.web.HaloServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>halo</servlet-name>
        <url-pattern>/halo.php</url-pattern>
    </servlet-mapping>
    ```

5. Compile dan jalankan

        mvn clean package tomcat:run

6. Test browse ke `http://localhost:8080/aplikasi-web-sederhana/halo.php?nama=endy`


## Konsep Aplikasi Web Java ##

1. Struktur Folder

    ![Struktur Folder Aplikasi Web Java](img/struktur-folder-web-java.png?raw=true)

2. Packaging

        * folder dikompres dengan format zip
        * extension zip direname menjadi war

3. Deploy

        * masukkan file `war` ke folder deployment sesuai merek application server yang digunakan
        * contoh: untuk Tomcat, folder deploymentnya adalah `webapps`
        * Tomcat akan meng-extract file `war` tersebut
        * Setelah deployment selesai (ditandai dengan file telah diextract dan tidak ada error di log)
          aplikasi bisa dibrowse

4. Undeploy

        * hapus file `war` dari folder deployment
        * setelah folder aplikasi terhapus, undeploy berarti sukses


## Komponen Aplikasi Web Java ##

### Servlet ###

Digunakan untuk menerima HTTP request dan membuat HTTP response

Cara membuat: 

1. Extends class HttpServlet
2. Override method doXXX

Contoh implementasi : 

* Java (kode program)

    ```java
    public class HaloServlet extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) {
            try {
                String asal = request.getRemoteAddr();
                String nama = request.getParameter("nama");
                        
                String output = "<html>";
                output += "<body>";
                output += "<h1>Halo "+nama+"</h1>";
                output += "<h2>Anda datang dari "+asal+"</h2>";
                output += "</body>";
                output += "</html>";
                
                // content type = html
                response.setContentType("text/html");
                response.getWriter().print(output);
            } catch (IOException ex) {
                Logger.getLogger(HaloServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    ```

* web.xml (konfigurasi)

    ```xml
    <servlet>
        <servlet-name>halo</servlet-name>
        <servlet-class>com.muhardin.endy.training.web.HaloServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>halo</servlet-name>
        <url-pattern>/halo.php</url-pattern>
    </servlet-mapping>
    ```

### Filter ###

Digunakan untuk : 

* mencegat HTTP request sebelum ditangani servlet
* mencegat HTTP response sebelum dikirim ke requester

Contoh penggunaan : 

* memproteksi URL yang membutuhkan login (Spring Security)
* mendekorasi HTML dengan header/footer/sidebar (Sitemesh)
* kompresi response

Contoh implementasi : 

* Java (kode program)

    ```java
    public class HaloFilter implements Filter{

        public void init(FilterConfig fc) throws ServletException {
            System.out.println("Filter diinisialisasi");
        }

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
            System.out.println("Mencegat request");
            fc.doFilter(request, response);
            System.out.println("Mencegat response");
        }

        public void destroy() {
            System.out.println("Filter di-destroy");
        }
        
    }
    ```

* web.xml (konfigurasi) :

    ```xml
    <filter>
        <filter-name>haloFilter</filter-name>
        <filter-class>com.muhardin.endy.training.web.HaloFilter</filter-class>
    </filter>
    
    <filter-mapping>
        <filter-name>haloFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    ```

### Listener ###

Digunakan untuk merespon event dalam aplikasi, misalnya: 

* aplikasi distart / deploy (context created)
* aplikasi distop / undeploy (context destroyed)
* session dibuat
* session timeout
* session dihapus (invalidation)


Contoh implementasi:

* Java (kode program)

    ```java
    public class HaloListener implements ServletContextListener, HttpSessionListener{

        public void contextInitialized(ServletContextEvent sce) {
            System.out.println("Aplikasi start");
        }

        public void contextDestroyed(ServletContextEvent sce) {
            System.out.println("Aplikasi stop");
        }

        public void sessionCreated(HttpSessionEvent hse) {
            System.out.println("Ada session baru");
        }

        public void sessionDestroyed(HttpSessionEvent hse) {
            System.out.println("Session di-destroy");
        }
        
    }
    ```

* web.xml (konfigurasi) :

    ```xml
    <listener>
        <listener-class>com.muhardin.endy.training.web.HaloListener</listener-class>
    </listener>
    ```










