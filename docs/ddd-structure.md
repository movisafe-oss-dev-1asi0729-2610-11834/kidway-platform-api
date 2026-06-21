# DDD Structure

The repository follows a DDD-style package organization inspired by the Learning Center Platform reference project.

Each bounded context is organized as:

```txt
<bounded-context>/
  domain/
    model/aggregates
    services
  application/
    internal
  infrastructure/
    persistence/jpa/repositories
  interfaces/
    rest
```

The current version prioritizes endpoint visibility in Swagger and a complete vertical slice per bounded context. It uses Spring Data JPA repositories, application services, domain service interfaces and REST controllers.
