# KidWay Platform API Endpoints

Swagger UI exposes all endpoints at `/swagger-ui/index.html` or `/swagger-ui.html`.

| Bounded Context | HTTP Verb | Endpoint | Purpose |
|---|---:|---|---|
| 1BC - IAM | POST | `/api/v1/authentication/sign-in` | Authenticate an existing user. |
| 1BC - IAM | POST | `/api/v1/authentication/sign-up` | Register a new user. |
| 1BC - IAM | GET | `/api/v1/users` | List users. |
| 1BC - IAM | GET | `/api/v1/roles` | List platform roles. |
| 2BC - User Profiles | GET/POST/PUT/DELETE | `/api/v1/user-profiles` | CRUD endpoints for 2BC - User Profiles. |
| 3BC - Subscription & Payments | GET/POST/PUT/DELETE | `/api/v1/subscriptions-payments` | CRUD endpoints for 3BC - Subscription & Payments. |
| 4BC - Dashboard | GET/POST/PUT/DELETE | `/api/v1/dashboard` | CRUD endpoints for 4BC - Dashboard. |
| 5BC - Fleet Management | GET/POST/PUT/DELETE | `/api/v1/fleet` | CRUD endpoints for 5BC - Fleet Management. |
| 6BC - Driver Management | GET/POST/PUT/DELETE | `/api/v1/drivers` | CRUD endpoints for 6BC - Driver Management. |
| 7BC - Route Management | GET/POST/PUT/DELETE | `/api/v1/routes` | CRUD endpoints for 7BC - Route Management. |
| 8BC - Student Management | GET/POST/PUT/DELETE | `/api/v1/students` | CRUD endpoints for 8BC - Student Management. |
| 9BC - Assignment Management | GET/POST/PUT/DELETE | `/api/v1/assignments` | CRUD endpoints for 9BC - Assignment Management. |
| 10BC - Real-Time Tracking | GET/POST/PUT/DELETE | `/api/v1/real-time-tracking` | CRUD endpoints for 10BC - Real-Time Tracking. |
| 11BC - Trip Management | GET/POST/PUT/DELETE | `/api/v1/trips` | CRUD endpoints for 11BC - Trip Management. |
| 12BC - Attendance Tracking | GET/POST/PUT/DELETE | `/api/v1/attendance` | CRUD endpoints for 12BC - Attendance Tracking. |
| 13BC - Alerts & Notifications | GET/POST/PUT/DELETE | `/api/v1/alerts-notifications` | CRUD endpoints for 13BC - Alerts & Notifications. |
| 14BC - Incident Management | GET/POST/PUT/DELETE | `/api/v1/incidents` | CRUD endpoints for 14BC - Incident Management. |
| 15BC - Monitoring & Analytics | GET/POST/PUT/DELETE | `/api/v1/monitoring-analytics` | CRUD endpoints for 15BC - Monitoring & Analytics. |
| 16BC - Company Management | GET/POST/PUT/DELETE | `/api/v1/companies` | CRUD endpoints for 16BC - Company Management. |

## Demo credentials

All seeded users use password `Demo1234`.

- `juan.rojas@kidway.pe` - INDEPENDENT_DRIVER
- `maria.lopez@movisafe.pe` - COMPANY_ADMIN
- `carlos.perez@movisafe.pe` - COMPANY_DRIVER
- `ana.torres@familia.pe` - PARENT_GUARDIAN
- `admin@kidway.pe` - KIDWAY_ADMIN
