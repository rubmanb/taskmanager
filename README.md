# 📝 Gestor de Tareas (To-Do List API) - TaskManager

Proyecto de práctica desarrollado con **Spring Boot (Java 17)** y **PostgreSQL**, acompañado de un **frontend en Angular**.  
La aplicación permite crear, actualizar, listar y eliminar tareas, funcionando como una API REST que consume el cliente web.

---

## 🚀 Tecnologías utilizadas

### Backend
- [Java 17](https://adoptium.net/)
- [Spring Boot 3](https://spring.io/projects/spring-boot)
  - Spring Web
  - Spring Data JPA
  - Spring Validation
  - Spring Security (JWT) *(opcional, si implementas autenticación)*
  - DevTools
- [PostgreSQL](https://www.postgresql.org/)
- [Maven](https://maven.apache.org/)

### Frontend
- [Angular](https://angular.io/)
- [Bootstrap](https://getbootstrap.com/)

---

## 📂 Estructura del proyecto

taskmanager/
├── backend/ # Proyecto Spring Boot (API REST)
│ ├── src/main/java/com/miapp/taskmanager
│ ├── src/main/resources/application.yml
│ └── pom.xml
└── frontend/ # Proyecto Angular
├── src/
└── package.json
---

## ⚙️ Configuración del Backend

### 1. Clonar repositorio
```bash
git clone https://github.com/tuusuario/gestor-tareas.git
cd gestor-tareas/backend
```
### 2. Configurar PostgreSQL
Crea una base de datos en PostgreSQL:

sql

```sql
CREATE DATABASE taskmanager_db;
```
### 3. Configurar application.yml
Archivo: src/main/resources/application.yml

yaml
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/gestor_tareas
    username: tu_usuario
    password: tu_password
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
    database-platform: org.hibernate.dialect.PostgreSQLDialect

server:
  port: 8080
```

### 4. Ejecutar el backend
```bash
mvn spring-boot:run
```
### ⚙️ Configuración del Frontend
## 1. Instalar dependencias
```bash
cd ../frontend
npm install
```
## 2. Ejecutar el frontend
```bash
ng serve --open
```
El frontend se levantará en http://localhost:4200 y consumirá la API del backend en http://localhost:8080.

📖 Endpoints principales
GET /api/tareas → Listar todas las tareas

POST /api/tareas → Crear nueva tarea

PUT /api/tareas/{id} → Actualizar tarea

DELETE /api/tareas/{id} → Eliminar tarea

La documentación de la API estará disponible en Swagger UI:
👉 http://localhost:8080/swagger-ui.html

✅ Futuras mejoras
Implementar autenticación con Spring Security + JWT.

Agregar paginación y filtros avanzados.

Desplegar en la nube (Heroku, Railway o Render).

Crear contenedores con Docker para backend, frontend y PostgreSQL.

📜 Licencia
Este proyecto es de uso libre para fines educativos y demostrativos. 🚀
