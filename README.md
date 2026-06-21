> Windows note: this repository includes `mvnw.cmd`, a project launcher that downloads Maven locally if `mvn` is not installed. Use `./mvnw.cmd spring-boot:run` from PowerShell. See `RUN_ON_WINDOWS.md`.

# KidWay Platform API

    Backend RESTful API for the KidWay / MobiSafe school transportation monitoring platform.

    ## Summary

    This project is the first backend version for the KidWay frontend. It follows the same technology direction used in the Learning Center Platform reference: Java, Spring Boot Framework, Spring Data JPA, Validation, Swagger UI / OpenAPI and a DDD-style package organization.

    The API is ready to be uploaded to GitHub and deployed. It runs immediately with an in-memory H2 database for demos, and it can also be connected to a cloud MySQL database by setting environment variables.

    ## Main features

    - RESTful API with Spring Boot.
    - OpenAPI documentation through Swagger UI.
    - Spring Data JPA persistence.
    - H2 database for immediate local/demo execution.
    - MySQL profile for local or cloud database deployment.
    - DDD-style layers per bounded context.
    - Seed data for users, roles and all KidWay contexts.
    - CORS enabled for Angular frontend integration.
    - Dockerfile and Render configuration included.

    ## Bounded contexts implemented

    - **1BC - Identity & Access Management**: `/api/v1/authentication`, `/api/v1/users`, `/api/v1/roles`
    - **2BC - User Profiles**: `/api/v1/user-profiles`
- **3BC - Subscription & Payments**: `/api/v1/subscriptions-payments`
- **4BC - Dashboard**: `/api/v1/dashboard`
- **5BC - Fleet Management**: `/api/v1/fleet`
- **6BC - Driver Management**: `/api/v1/drivers`
- **7BC - Route Management**: `/api/v1/routes`
- **8BC - Student Management**: `/api/v1/students`
- **9BC - Assignment Management**: `/api/v1/assignments`
- **10BC - Real-Time Tracking**: `/api/v1/real-time-tracking`
- **11BC - Trip Management**: `/api/v1/trips`
- **12BC - Attendance Tracking**: `/api/v1/attendance`
- **13BC - Alerts & Notifications**: `/api/v1/alerts-notifications`
- **14BC - Incident Management**: `/api/v1/incidents`
- **15BC - Monitoring & Analytics**: `/api/v1/monitoring-analytics`
- **16BC - Company Management**: `/api/v1/companies`

    ## Target roles

    - `INDEPENDENT_DRIVER`: independent school transport driver.
    - `COMPANY_ADMIN`: company owner or fleet administrator.
    - `COMPANY_DRIVER`: driver working for a company fleet.
    - `PARENT_GUARDIAN`: parent or guardian who receives tracking, attendance and alerts.
    - `KIDWAY_ADMIN`: platform administrator.

    ## Requirements

    - Java JDK 21.
    - Maven 3.9+ or an IDE with bundled Maven.
    - Optional: MySQL 8+ for persistent local/cloud database.

    ## Run locally with terminal

    ```bash
    mvn spring-boot:run
    ```

    Then open:

    ```txt
    http://localhost:8080/swagger-ui/index.html
    ```

    Alternative Swagger URL:

    ```txt
    http://localhost:8080/swagger-ui.html
    ```

    Health check:

    ```txt
    http://localhost:8080/api/v1/health
    ```

    H2 console for the default demo database:

    ```txt
    http://localhost:8080/h2-console
    JDBC URL: jdbc:h2:mem:kidway_platform
    User: sa
    Password: empty
    ```

    ## Demo credentials

    All seeded users use this password:

    ```txt
    Demo1234
    ```

    Users:

    ```txt
    juan.rojas@kidway.pe        INDEPENDENT_DRIVER
    maria.lopez@movisafe.pe    COMPANY_ADMIN
    carlos.perez@movisafe.pe   COMPANY_DRIVER
    ana.torres@familia.pe      PARENT_GUARDIAN
    admin@kidway.pe            KIDWAY_ADMIN
    ```

    ## Run with MySQL locally

    Option 1: using Docker Compose:

    ```bash
    docker compose up --build
    ```

    Option 2: using your own MySQL database:

    ```bash
    SPRING_PROFILES_ACTIVE=mysql \
    DB_URL="jdbc:mysql://localhost:3306/kidway_platform?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true" \
    DB_USERNAME=root \
    DB_PASSWORD=admin \
    mvn spring-boot:run
    ```

    ## Cloud database configuration

    Create a MySQL database in Railway, Aiven, Clever Cloud, PlanetScale-compatible MySQL, or another provider. Then set these environment variables in your deployment platform:

    ```txt
    SPRING_PROFILES_ACTIVE=mysql
    DB_URL=jdbc:mysql://<host>:<port>/<database>?useSSL=true&serverTimezone=UTC&allowPublicKeyRetrieval=true
    DB_USERNAME=<username>
    DB_PASSWORD=<password>
    DB_DRIVER=com.mysql.cj.jdbc.Driver
    HIBERNATE_DIALECT=org.hibernate.dialect.MySQLDialect
    ```

    ## Deploy on Render using Docker

    1. Push this repository to GitHub.
    2. Go to Render and create a new Web Service from the GitHub repository.
    3. Select Docker as environment.
    4. Use the included `Dockerfile`.
    5. For the first demo deployment, you can keep the default H2 database. Swagger will be visible without extra database setup.
    6. For persistent data, add the MySQL environment variables described above.

    After deploy, open:

    ```txt
    https://<your-render-service>.onrender.com/swagger-ui/index.html
    ```

    ## About Rider

    For Java and Spring Boot, the recommended JetBrains IDE is IntelliJ IDEA. Rider is mainly focused on .NET. If you only have Rider, you can still open the folder and run the Maven command from Rider's terminal, but the smoother experience for this backend is IntelliJ IDEA or the terminal.

    In IntelliJ IDEA:

    1. Open the project folder or `pom.xml`.
    2. Select JDK 21.
    3. Wait for Maven dependencies to load.
    4. Run `KidWayPlatformApplication`.
    5. Open Swagger at `http://localhost:8080/swagger-ui/index.html`.

    ## GitFlow suggestion

    ```bash
    git checkout -b develop
    git checkout -b feature/av2-backend-api-foundation
    git add .
    git commit -m "feat: add kidway backend api foundation"
    git push origin feature/av2-backend-api-foundation
    ```

    ## Documentation

    - `docs/endpoints.md`: endpoint summary.
    - `docs/ddd-structure.md`: DDD package structure.
