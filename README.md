# CRUD MVC con Thymeleaf — RA3

## 1) Datos del alumno/a
- Entidad elegida (ej. Producto, Libro...): Eventos

## 2) Repositorio (fork) y gestión de versiones
- Repositorio base: https://github.com/profeInformatica101/tareasSpringBoot
- Enlace a MI fork: https://github.com/JuanJoseFernandez10/tareasSpringBoot
- Nº de commits realizados: (mínimo 5)

## 3) Arquitectura
Explica brevemente cómo has organizado:
- Controller: EventosController
- Service: EventosService
- Repository: EventosRepository
- Entity: Eventos

## 4) Base de datos elegida (marca una)
- [*] H2
- [ ] MySQL
- [ ] PostgreSQL

## 5) Configuración de la base de datos
### 5.1 Dependencias añadidas
Thymeleaf
H2 DataBase
Sprinig Web
JPA
Dev Tool

### 5.2 application.properties / application.yml
spring.application.name=tareaCRUD
server.port=9090

spring.h2.console.enabled=true
spring.h2.console.path=/h2
spring.datasource.url=jdbc:h2:mem:testdb 
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver


### 5.3 Pasos para crear la BD (si aplica)
- MySQL: CREATE DATABASE ...
- PostgreSQL: createdb ...

## 6) Cómo ejecutar el proyecto
1. Requisitos (jdk 17, Maven, H2(dentro del proyecto))
2. Comando de arranque:
   - ./mvnw spring-boot:run   (o equivalente)
3. URL de acceso:
   - http://localhost:9090/...

## 7) Pantallas / Rutas MVC
- GET /entidad (listar)
- GET /entidad/nuevo (formulario alta)
- POST /entidad (crear)
- GET /entidad/{id}/editar (editar)
- POST /entidad/{id} (actualizar)
- POST /entidad/{id}/borrar (eliminar)


## 8) Mejoras extra (opcional)
- Validaciones
- Estilos Bootstrap
- Búsqueda
- Pruebas
- Paginación
