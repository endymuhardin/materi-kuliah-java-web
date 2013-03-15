# Intro Aplikasi Web Java #

## Membuat Aplikasi Web Java ##

1. Buat project maven standar

        mvn archetype:create -DgroupId=com.muhardin.endy.training.web -DartifactId=aplikasi-web-sederhana

2. Ubah tipe packaging dari `jar` menjadi `war`

          <groupId>com.muhardin.endy.training.web</groupId>
          <artifactId>aplikasi-web-sederhana</artifactId>
          <version>1.0-SNAPSHOT</version>
          <packaging>war</packaging>

3. Buat struktur folder aplikasi web : `src/main/webapp/WEB-INF/web.xml'

        <?xml version="1.0" encoding="UTF-8"?>
        <web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
	        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

        </web-app>

4. Buka di Netbeans

5. Test Jalankan

        `mvn tomcat:run`

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

6. Test browse ke http://localhost:8080/aplikasi-web-sederhana/halo.php?nama=endy








        
