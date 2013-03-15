# Intro Aplikasi Web Java #

## Membuat Aplikasi Web Java ##

1. Buat project maven standar

```
 mvn archetype:create -DgroupId=com.muhardin.endy.training.web -DartifactId=aplikasi-web-sederhana
```

2. Ubah tipe packaging dari `jar` menjadi `war`

```xml
  <groupId>com.muhardin.endy.training.web</groupId>
  <artifactId>aplikasi-web-sederhana</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>
```

3. Buat struktur folder aplikasi web : `src/main/webapp/WEB-INF/web.xml'

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

</web-app>
```

4. Buka di Netbeans

5. Test Jalankan

`mvn tomcat:run`
