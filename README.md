# KidWay Platform API

Gateway backend for the KidWay school transport frontend.

This backend exposes IAM demo endpoints and generic CRUD endpoints for the frontend collections that were originally stored in `db.json`.

## Run locally with H2

```bash
mvn spring-boot:run
```

Swagger:

```txt
http://localhost:8080/swagger-ui/index.html
```

Base API:

```txt
http://localhost:8080/api/v1
```

The default local profile uses H2 and reloads the seed on each start.

## Run with Render PostgreSQL

Create a Render Postgres database and copy the **Internal Database URL** from the database Info page.

In your Render Web Service, add these environment variables:

```txt
SPRING_PROFILES_ACTIVE=postgres
DATABASE_URL=<Internal Database URL from Render Postgres>
KIDWAY_SEED_ENABLED=true
KIDWAY_SEED_RESET_ON_START=false
FRONTEND_URL=http://localhost:4200,http://127.0.0.1:4200
```

After deploying the frontend, replace `FRONTEND_URL` with your public frontend URL, for example:

```txt
FRONTEND_URL=https://kidway-frontend.onrender.com
```

The backend automatically converts Render's Postgres URL format:

```txt
postgresql://USER:PASSWORD@HOST:5432/DATABASE
```

into the JDBC format required by Spring Boot.

## Persistence behavior

With the `postgres` profile:

- The first deploy creates the table `json_resources`.
- If the database is empty, the backend loads the initial data from `src/main/resources/data/kidway-db.json`.
- If the database already has data, the seed is skipped.
- CRUD changes from Swagger or frontend remain stored in PostgreSQL after backend restarts.

## Useful endpoints

```txt
GET    /api/v1/collections
GET    /api/v1/{collectionName}
GET    /api/v1/{collectionName}/{resourceId}
POST   /api/v1/{collectionName}
PUT    /api/v1/{collectionName}/{resourceId}
PATCH  /api/v1/{collectionName}/{resourceId}
DELETE /api/v1/{collectionName}/{resourceId}
```

Example collections:

```txt
students
drivers
fleetVehicles
schoolRoutes
assignments
trips
attendance
notifications
incidents
currentSubscription
billingHistory
```

## IAM demo endpoints

```txt
POST /api/v1/auth/sign-in
POST /api/v1/auth/sign-up
POST /api/v1/auth/forgot-access
GET  /api/v1/auth/me?usernameOrEmail=maria.lopez
GET  /api/v1/auth/role-access/company-admin
```
