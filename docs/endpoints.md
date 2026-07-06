# KidWay Platform API Endpoints

## Swagger

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Identity & Access Management

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/auth/sign-in` | Login with a user from `identityUsers`. |
| POST | `/api/v1/auth/sign-up` | Creates a pending demo account. |
| POST | `/api/v1/auth/forgot-access` | Mock recovery flow. |
| GET | `/api/v1/auth/me?usernameOrEmail=maria.lopez` | Get a sanitized user profile. |
| GET | `/api/v1/auth/role-access/{role}` | Return visible modules for a role. |

## Generic Resource Gateway

All data from the frontend `server/db.json` is seeded into the backend. The same collection names are available through `/api` and `/api/v1`.

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1/collections` | List all collection names. |
| GET | `/api/v1/{collection}` | Get a collection or singleton object. |
| GET | `/api/v1/{collection}/{id}` | Get a resource by id. |
| POST | `/api/v1/{collection}` | Create a resource. |
| PUT | `/api/v1/{collection}/{id}` | Replace a resource. |
| PATCH | `/api/v1/{collection}/{id}` | Partially update a resource. |
| DELETE | `/api/v1/{collection}/{id}` | Delete a resource. |

Examples:

```http
GET /api/v1/fleetVehicles
GET /api/v1/fleetVehicles/veh-kw-204
POST /api/v1/fleetVehicles
PATCH /api/v1/fleetVehicles/veh-kw-204
DELETE /api/v1/fleetVehicles/veh-kw-204
GET /api/v1/dashboardViews?role=company
```

## Collections seeded from frontend

- currentUser
- dashboard
- notifications
- modules
- currentSubscription
- subscriptionPlans
- paymentMethods
- billingHistory
- assignments
- attendance
- attendanceActions
- students
- dashboardViews
- fleetSummary
- fleetVehicles
- fleetMaintenanceAlerts
- driverSummary
- drivers
- driverReviews
- driverShifts
- routeSummary
- schoolRoutes
- routeReviews
- routeActivities
- studentSummary
- studentRecords
- studentReviews
- studentActivities
- assignmentDashboard
- trackingDashboard
- tripDashboard
- attendanceDashboard
- alertNotificationCenter
- incidentManagement
- analyticsDashboard
- companyManagement
- userProfileDashboard
- identityUsers
