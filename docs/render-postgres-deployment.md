# Render PostgreSQL deployment

## Database

Recommended Render Postgres values:

```txt
Name: kidway-platform-db
Database: kidway_platform_db
User: kidway_user
Region: Oregon (US West)
Plan: Free
```

## Backend service environment variables

```txt
SPRING_PROFILES_ACTIVE=postgres
DATABASE_URL=<Internal Database URL>
KIDWAY_SEED_ENABLED=true
KIDWAY_SEED_RESET_ON_START=false
FRONTEND_URL=http://localhost:4200,http://127.0.0.1:4200
```

Use the Internal Database URL for a backend hosted in Render in the same region. Use the External Database URL only for local tools like pgAdmin, DBeaver, IntelliJ Database, or local backend testing.

## Verify after deploy

```txt
https://<backend-url>/swagger-ui/index.html
https://<backend-url>/api/v1/health
https://<backend-url>/api/v1/collections
```

The initial seed creates data only when the database is empty. Do not set `KIDWAY_SEED_RESET_ON_START=true` in production unless you intentionally want to erase and reload the demo seed.
