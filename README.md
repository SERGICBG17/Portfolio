# Portfolio Personal - Spring Boot

Este proyecto consiste en un CV web interactivo y dinámico desarrollado con **Spring Boot 3.x**. La aplicación permite mostrar información profesional, formación académica, experiencia laboral y proyectos realizados, gestionando todo el contenido a través de una base de datos.

## Requisitos Previos

* Java JDK 17 o superior.
* Maven 3.6+.
* Base de datos (H2, MySQL o PostgreSQL) según configuración.

## Configuración e Instalación

Debido a que el archivo de configuración contiene credenciales sensibles, este se encuentra ignorado en el repositorio. Sigue estos pasos para poner en marcha el proyecto:

### 1. Configurar el entorno (application.properties)
Crea un archivo llamado `application.properties` dentro de la carpeta `src/main/resources/` con el siguiente contenido base:

```properties
# Configuración de la Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/portfolio_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

# Configuración de Thymeleaf
spring.thymeleaf.cache=false

# Carga de datos iniciales
spring.sql.init.mode=always
```

## Estructura y Navegación

### Vista Pública
Es la página principal (`/`) donde se muestra la información profesional procesada íntegramente desde la base de datos. Se compone de las siguientes secciones dinámicas:
<img width="1873" height="900" alt="image" src="https://github.com/user-attachments/assets/5fcf3fdd-8cd7-46e4-b84f-930aa9971eaf" />

* **Información Personal:** Biografía, foto y datos de contacto cargados desde la tabla `info`.
* **Trayectoria:** Listado cronológico de experiencia laboral y formación académica.
* **Proyectos:** Galería de trabajos con visualización de tecnologías asociadas.

### Panel de Administración (Acceso CRUD)
Para gestionar el contenido sin necesidad de modificar el código fuente, la aplicación incluye una zona privada de administración.
<img width="1280" height="609" alt="image" src="https://github.com/user-attachments/assets/ddabbc62-14d6-4f9d-ac2d-3c686f875f46" />

**URL de acceso:** `http://localhost:8080/admin`

Desde este panel se pueden realizar operaciones **CRUD completas** sobre las 6 tablas requeridas en la práctica:

* **Altas:** Añadir nuevos proyectos, experiencias o estudios.
* **Bajas:** Eliminar registros obsoletos de la base de datos.
* **Modificaciones:** Editar cualquier campo de la trayectoria o información personal.
* **Gestión N:M:** Asignar y desvincular lenguajes de programación a cada proyecto de forma dinámica.

---

## Arquitectura del Proyecto

El código sigue el patrón **MVC (Modelo-Vista-Controlador)** con una capa de servicios intermedia para garantizar la separación de responsabilidades y la escalabilidad:

* **Model (Entidades):** Clases JPA (`Info`, `Experiencia`, `Estudios`, `Proyecto`, `Lenguaje`) que definen la estructura y relaciones de la base de datos.
* **Repository:** Interfaces que extienden de `JpaRepository` para la comunicación fluida con la BD.
* **Service Layer:** Capa de lógica de negocio que procesa los datos antes de enviarlos a la vista.
* **Controller:** Gestión de las rutas web tanto para la parte pública como para la zona `/admin`.
* **Templates:** Vistas dinámicas creadas con **Thymeleaf** que eliminan el uso de contenido estático en el HTML.



---

## Tecnologías Utilizadas

* **Backend:** Spring Boot 3.x, Spring Data JPA.
* **Frontend:** Thymeleaf, HTML5, CSS3, Bootstrap.
* **Base de Datos:** MySQL / H2.
* **Control de Versiones:** Git (GitHub).

---


## Licencia y Copyright 

© **2026 - Sergio Casín** (SERGICBG17) - Todos los derechos reservados.

Este proyecto es de código abierto para fines de consulta, aprendizaje y exhibición de competencias técnicas.

* **Uso Permitido:** Se permite a cualquier usuario, empresa o reclutador clonar, ejecutar y estudiar el código fuente. Se fomenta su uso como material de referencia o aprendizaje.
* **Atribución y Créditos:** Si utilizas fragmentos de este código o te basas en su arquitectura para tus propios proyectos, se requiere dar el crédito correspondiente mencionando al autor original (**Sergio Casín**) e incluyendo un enlace a este repositorio.
* **Prohibiciones:** * No se permite la copia exacta (plagio) de este portfolio para su publicación como propio.
    * Queda estrictamente prohibida la redistribución, venta o uso comercial de esta aplicación, de su estructura lógica o de su diseño sin autorización previa.
* **Propiedad Intelectual:** La arquitectura del software y la lógica de integración de datos son propiedad exclusiva del autor.

---
*Si te gusta este proyecto o estás interesado en mi perfil profesional, te invito a conectar conmigo a través de mi GitHub o los canales de contacto de la web.*
