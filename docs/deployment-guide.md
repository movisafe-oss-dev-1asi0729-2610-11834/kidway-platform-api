# Deployment Guide

## Fast demo deployment

For the first backend evidence, deploy with the default profile. The API will use H2 in memory. This is enough to show the service deployed and Swagger working.

Render setup:

- Environment: Docker
- Dockerfile: included in repository
- Health check path: `/api/v1/health`
- No required environment variables for H2 demo

Swagger URL after deployment:

```txt
https://<service-name>.onrender.com/swagger-ui/index.html
```

## Persistent cloud database deployment

Add these environment variables to the web service:

```txt
SPRING_PROFILES_ACTIVE=mysql
DB_URL=jdbc:mysql://<host>:<port>/<database>?useSSL=true&serverTimezone=UTC&allowPublicKeyRetrieval=true
DB_USERNAME=<username>
DB_PASSWORD=<password>
DB_DRIVER=com.mysql.cj.jdbc.Driver
HIBERNATE_DIALECT=org.hibernate.dialect.MySQLDialect
```

After redeploying, Hibernate will create/update the tables and the initial data seeder will insert demo records.
