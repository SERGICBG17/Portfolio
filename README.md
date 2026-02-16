# Portfolio Personal - Guía de Instalación y Configuración

## Descripción del Proyecto

Plataforma web de portfolio personal y currículum profesional construida con **Spring Boot 3** y **Thymeleaf**. Presenta mi información profesional, experiencia, proyectos y habilidades de forma dinámica y atractiva. Incluye un panel de administración completo para gestionar todo el contenido en tiempo real, sistema de contacto integrado, y soporte para múltiples bases de datos (MySQL/H2).


<img width="2502" height="1178" alt="image" src="https://github.com/user-attachments/assets/ee366dd1-0b66-4116-ae08-059ff836a0e3" />

---

## Tabla de Contenidos

1. [Requisitos Previos](#requisitos-previos)
2. [Instalación](#instalación)
3. [Configuración de Base de Datos](#configuración-de-base-de-datos)
4. [Configuración de Email](#configuración-de-email)
5. [Ejecución de la Aplicación](#ejecución-de-la-aplicación)
6. [Acceso a la Aplicación](#acceso-a-la-aplicación)
7. [Personalización del Portfolio](#personalización-del-portfolio)
8. [Configuración Avanzada](#configuración-avanzada)
9. [Resolución de Problemas](#resolución-de-problemas)

---

## Requisitos Previos

Antes de comenzar, asegúrese de tener instalados los siguientes componentes:

- **Java JDK 17 o superior** - [Descargar](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.6 o superior** - [Descargar](https://maven.apache.org/download.cgi)
- **Git** - [Descargar](https://git-scm.com/downloads)
- **MySQL 8.0 o superior** (Opcional - recomendado para producción) - [Descargar](https://dev.mysql.com/downloads/)
- IDE de desarrollo (IntelliJ IDEA, Eclipse o Visual Studio Code)

### Verificación de Requisitos

Ejecute los siguientes comandos para verificar las instalaciones:
```bash
java -version
mvn -version
git --version
```

---

## Instalación

### Paso 1: Clonar el Repositorio
```bash
git clone https://github.com/SERGICBG17/Portfolio.git
cd Portfolio
```

### Paso 2: Configurar application.properties

Navegue al archivo `src/main/resources/application.properties` y configure las propiedades según sus necesidades. A continuación se presenta la plantilla completa:
```properties
spring.application.name=Portfolio

# ========================================
# CONFIGURACIÓN DEL SERVIDOR
# ========================================
server.port=8080

# Hidden Method Filter (para formularios PUT/DELETE)
spring.mvc.hiddenmethod.filter.enabled=true

# ========================================
# THYMELEAF
# ========================================
spring.thymeleaf.cache=false

# ========================================
# JPA/HIBERNATE
# ========================================
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# ========================================
# SQL INITIALIZATION
# ========================================
spring.sql.init.mode=always
spring.sql.init.encoding=UTF-8
spring.jpa.defer-datasource-initialization=true

# ========================================
# CONFIGURACIÓN DE EMAIL (Gmail SMTP)
# ========================================
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=tu-email@gmail.com
spring.mail.password=xxxx xxxx xxxx xxxx
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# ========================================
# H2 CONSOLE
# ========================================
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# ========================================
# LOGGING
# ========================================
logging.level.org.springframework=INFO
logging.level.org.hibernate.SQL=DEBUG
```

---

## Configuración de Base de Datos

La aplicación soporta dos modos de persistencia: H2 (desarrollo) y MySQL (producción).

### Opción A: Base de Datos H2 (Desarrollo)

**Configuración por defecto.** No requiere pasos adicionales.

**Características:**
- Base de datos en memoria
- Configuración automática
- Ideal para desarrollo y pruebas
- Los datos se reinician al detener la aplicación

### Opción B: Base de Datos MySQL (Producción)

#### Paso 1: Crear la Base de Datos

Ejecute el siguiente comando SQL en MySQL:
```sql
CREATE DATABASE portfolio_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

#### Paso 2: Configurar la Conexión

Añada las siguientes líneas al final de `application.properties`:
```properties
# ========================================
# MYSQL CONFIGURATION
# ========================================
spring.datasource.url=jdbc:mysql://localhost:3306/portfolio_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario_mysql
spring.datasource.password=tu_contraseña_mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

**Parámetros a reemplazar:**
- `tu_usuario_mysql`: Usuario de MySQL (generalmente `root`)
- `tu_contraseña_mysql`: Contraseña del usuario MySQL
- `portfolio_db`: Nombre de la base de datos (modificable según preferencia)

---

## Configuración de Email

El formulario de contacto del portfolio utiliza Gmail SMTP para enviar mensajes. Se requiere una contraseña de aplicación específica.

### Generación de Contraseña de Aplicación

1. Acceda a [https://myaccount.google.com/security](https://myaccount.google.com/security)
2. Active la verificación en dos pasos (si no está activada)
3. Busque "Contraseñas de aplicaciones"
4. Seleccione "Correo" como aplicación y "Otro" como dispositivo
5. Ingrese "Portfolio" como nombre
6. Copie la contraseña generada (formato: `xxxx xxxx xxxx xxxx`)

### Configuración en application.properties
```properties
spring.mail.username=su-email@gmail.com
spring.mail.password=abcd efgh ijkl mnop
```

**Importante:** Utilice la contraseña de aplicación generada, no su contraseña personal de Gmail.

---

## Ejecución de la Aplicación

### Método 1: Línea de Comandos
```bash
mvn clean install
mvn spring-boot:run
```

### Método 2: IDE

1. Importe el proyecto como proyecto Maven
2. Localice la clase principal (anotada con `@SpringBootApplication`)
3. Ejecute la aplicación desde el IDE

### Método 3: JAR Ejecutable
```bash
mvn clean package
java -jar target/Portfolio-0.0.1-SNAPSHOT.jar
```

---

## Acceso a la Aplicación

Una vez iniciada la aplicación, acceda a través de:

- **Portfolio público:** `http://localhost:8080`
- **Panel de administración:** `http://localhost:8080/admin`
- **Consola H2** (solo con H2): `http://localhost:8080/h2-console`

### Credenciales de H2 Console

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Usuario:** `sa`
- **Contraseña:** (dejar en blanco)

---

## Personalización del Portfolio

### Panel de Administración

Acceda al panel de administración en `http://localhost:8080/admin` para gestionar su información profesional:

- **Información Personal:** Nombre, título profesional, biografía, foto de perfil
- **Experiencia Laboral:** Empresas, cargos, períodos, descripciones
- **Educación:** Instituciones, títulos, fechas
- **Proyectos:** Nombre, descripción, tecnologías, enlaces
- **Habilidades:** Tecnologías, niveles de competencia
- **Redes Sociales:** LinkedIn, GitHub, correo electrónico, etc.

### Datos Iniciales

Para poblar el portfolio con su información personal, cree o edite el archivo `src/main/resources/data.sql` con sus datos profesionales. Este archivo se ejecutará automáticamente al iniciar la aplicación.

**Ejemplo de estructura:**
```sql
INSERT INTO personal_info (nombre, titulo, biografia, email) VALUES 
('Su Nombre', 'Desarrollador Full Stack', 'Su biografía profesional...', 'su-email@ejemplo.com');

INSERT INTO experiencia (empresa, cargo, fecha_inicio, fecha_fin, descripcion) VALUES 
('Empresa XYZ', 'Desarrollador Senior', '2020-01-01', '2023-12-31', 'Descripción de responsabilidades...');
```

---

## Configuración Avanzada

### Modificar Puerto del Servidor

Edite la propiedad en `application.properties`:
```properties
server.port=8081
```

### Perfiles de Spring

Para diferentes entornos, cree archivos:
- `application-dev.properties` (desarrollo)
- `application-prod.properties` (producción)

Active el perfil deseado:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

### Personalización de Estilos

Los archivos CSS y recursos estáticos se encuentran en `src/main/resources/static/`. Modifíquelos para personalizar la apariencia de su portfolio según su marca personal.

---

## Resolución de Problemas

### Error: "Access denied for user"

**Causa:** Credenciales incorrectas de MySQL.

**Solución:** Verifique usuario y contraseña en `application.properties`.

### Error: "Could not open JDBC Connection"

**Causa:** MySQL no está en ejecución o la base de datos no existe.

**Solución:**
1. Verifique que el servicio MySQL esté activo
2. Confirme que la base de datos `portfolio_db` exista
3. Valide la URL de conexión

### Error: "Port 8080 was already in use"

**Causa:** El puerto está ocupado por otra aplicación.

**Solución:** Cambie el puerto en `application.properties`:
```properties
server.port=8081
```

### El Formulario de Contacto no Envía Emails

**Causa:** Configuración incorrecta de Gmail SMTP.

**Solución:**
1. Confirme el uso de contraseña de aplicación (no contraseña personal)
2. Verifique que la verificación en dos pasos esté activa
3. Revise los logs para errores de autenticación

### Los Datos no Persisten con H2

**Causa:** H2 es una base de datos en memoria.

**Solución:** Configure MySQL para persistencia permanente de su información profesional.

---

## Checklist de Configuración

Antes de ejecutar la aplicación, verifique:

- [ ] Java 17+ instalado y configurado
- [ ] Maven instalado y en PATH
- [ ] Repositorio clonado correctamente
- [ ] `application.properties` configurado con sus datos personales
- [ ] Base de datos MySQL creada (si aplica)
- [ ] Contraseña de aplicación Gmail generada
- [ ] Puerto 8080 disponible (o alternativo configurado)
- [ ] Dependencias de Maven descargadas
- [ ] Archivo `data.sql` con su información profesional (opcional)

---

## Licencia

Este proyecto está bajo la Licencia MIT.

---

---

**Desarrollado por Sergio Casín**
