# Frontend Integration Notes

This backend already exposes compatible routes for the current Angular frontend.

## Current static frontend route style

The current frontend calls endpoints such as:

```txt
/api/fleetVehicles
/api/studentRecords
/api/assignmentDashboard
/api/identityUsers
```

This backend supports those routes directly. During local frontend development, configure Angular proxy or environment to point `/api` to `http://localhost:8080/api`.

## Recommended future route style

For a cleaner backend version, migrate frontend services progressively to:

```txt
http://localhost:8080/api/v1/<collection>
```

Examples:

```txt
GET http://localhost:8080/api/v1/fleetVehicles
GET http://localhost:8080/api/v1/userProfileDashboard
POST http://localhost:8080/api/v1/auth/sign-in
```

## IAM migration path

The current frontend can keep its static auth flow temporarily. Later, replace the local user lookup with:

```http
POST /api/v1/auth/sign-in
```

Request:

```json
{
  "usernameOrEmail": "maria.lopez",
  "password": "KidWay123$"
}
```

Response includes:

```json
{
  "token": "...",
  "tokenType": "Bearer",
  "user": {},
  "allowedModules": []
}
```
