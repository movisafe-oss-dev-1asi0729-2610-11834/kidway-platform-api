# KidWay Platform API

Backend Java/Spring Boot para la aplicación frontend de KidWay. Este repositorio se generó tomando como referencia la estructura del `learning-center-platform` y los datos del `server/db.json` del frontend.

## Stack

- Java 21
- Spring Boot 3.5.7
- Spring Web
- Spring Data JPA
- Bean Validation
- Springdoc OpenAPI / Swagger
- H2 por defecto para correr sin instalar base de datos
- MySQL opcional para integración local

## Ejecutar en IntelliJ IDEA

1. Abre este folder como proyecto Maven.
2. Verifica que el SDK sea Java 21.
3. Ejecuta la clase:

```txt
src/main/java/com/kidway/platform/KidWayPlatformApiApplication.java
```

También puedes ejecutar por terminal:

```bash
mvn spring-boot:run
```

## URLs principales

```txt
API base:     http://localhost:8080/api/v1
Swagger UI:  http://localhost:8080/swagger-ui/index.html
H2 Console:  http://localhost:8080/h2-console
```

Con H2 Console usa:

```txt
JDBC URL: jdbc:h2:file:./data/kidway-platform-api
User: sa
Password: 
```

## Ejecutar con MySQL opcional

El proyecto corre solo con H2. Para usar MySQL local/XAMPP:

```bash
SPRING_PROFILES_ACTIVE=mysql mvn spring-boot:run
```

Configuración MySQL incluida:

```txt
Database: kidway_platform_api
User: root
Password: 12345Mysql$
```

## Credenciales demo IAM

Las credenciales están sembradas en la colección `identityUsers` del backend.

```txt
maria.lopez / KidWay123$
juan.ruiz / Parent123$
carlos.perez / Driver123$
admin.kidway / Admin123$
```

## Endpoints clave

### IAM

```http
POST /api/v1/auth/sign-in
POST /api/v1/auth/sign-up
POST /api/v1/auth/forgot-access
GET  /api/v1/auth/me?usernameOrEmail=maria.lopez
GET  /api/v1/auth/role-access/Company Admin
```

### Data Gateway

El backend expone los datos del frontend con CRUD genérico:

```http
GET    /api/v1/fleetVehicles
GET    /api/v1/fleetVehicles/veh-kw-204
POST   /api/v1/fleetVehicles
PUT    /api/v1/fleetVehicles/veh-kw-204
PATCH  /api/v1/fleetVehicles/veh-kw-204
DELETE /api/v1/fleetVehicles/veh-kw-204
```

También se mantienen rutas compatibles con el frontend actual:

```http
GET /api/fleetVehicles
GET /api/studentRecords
GET /api/assignmentDashboard
GET /api/userProfileDashboard
```

## Bounded Contexts cubiertos

- Identity & Access Management
- User Profiles
- Subscription & Payments
- Dashboard
- Fleet Management
- Driver Management
- Route Management
- Student Management
- Assignment Management
- Real-Time Tracking
- Trip Management
- Attendance Tracking
- Alerts & Notifications
- Incident Management
- Monitoring & Analytics
- Company Management

## Nota técnica

Esta primera versión funciona como backend gateway para reemplazar progresivamente JSON Server. Los datos se cargan desde `src/main/resources/data/kidway-db.json` hacia una tabla genérica `json_resources`. Esto permite tener endpoints CRUD funcionales y preparar la conexión del frontend sin bloquear el proyecto con decenas de entidades específicas en esta etapa.
