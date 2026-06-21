package com.movisafe.kidway.platform.shared.infrastructure.persistence.jpa.seed;

    import com.movisafe.kidway.platform.iam.infrastructure.persistence.jpa.repositories.PlatformUserRepository;
import com.movisafe.kidway.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.movisafe.kidway.platform.iam.domain.model.aggregates.PlatformUser;
import com.movisafe.kidway.platform.iam.domain.model.entities.Role;
import com.movisafe.kidway.platform.iam.application.internal.outboundservices.hashing.HashingService;
import com.movisafe.kidway.platform.userprofiles.domain.model.aggregates.UserProfile;
import com.movisafe.kidway.platform.userprofiles.infrastructure.persistence.jpa.repositories.UserProfileRepository;
import com.movisafe.kidway.platform.subscriptions.domain.model.aggregates.Subscription;
import com.movisafe.kidway.platform.subscriptions.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import com.movisafe.kidway.platform.dashboard.domain.model.aggregates.DashboardMetric;
import com.movisafe.kidway.platform.dashboard.infrastructure.persistence.jpa.repositories.DashboardMetricRepository;
import com.movisafe.kidway.platform.fleet.domain.model.aggregates.Vehicle;
import com.movisafe.kidway.platform.fleet.infrastructure.persistence.jpa.repositories.VehicleRepository;
import com.movisafe.kidway.platform.drivers.domain.model.aggregates.Driver;
import com.movisafe.kidway.platform.drivers.infrastructure.persistence.jpa.repositories.DriverRepository;
import com.movisafe.kidway.platform.routes.domain.model.aggregates.SchoolRoute;
import com.movisafe.kidway.platform.routes.infrastructure.persistence.jpa.repositories.SchoolRouteRepository;
import com.movisafe.kidway.platform.students.domain.model.aggregates.Student;
import com.movisafe.kidway.platform.students.infrastructure.persistence.jpa.repositories.StudentRepository;
import com.movisafe.kidway.platform.assignments.domain.model.aggregates.RouteAssignment;
import com.movisafe.kidway.platform.assignments.infrastructure.persistence.jpa.repositories.RouteAssignmentRepository;
import com.movisafe.kidway.platform.tracking.domain.model.aggregates.TrackingEvent;
import com.movisafe.kidway.platform.tracking.infrastructure.persistence.jpa.repositories.TrackingEventRepository;
import com.movisafe.kidway.platform.trips.domain.model.aggregates.Trip;
import com.movisafe.kidway.platform.trips.infrastructure.persistence.jpa.repositories.TripRepository;
import com.movisafe.kidway.platform.attendance.domain.model.aggregates.AttendanceRecord;
import com.movisafe.kidway.platform.attendance.infrastructure.persistence.jpa.repositories.AttendanceRecordRepository;
import com.movisafe.kidway.platform.alerts.domain.model.aggregates.AlertNotification;
import com.movisafe.kidway.platform.alerts.infrastructure.persistence.jpa.repositories.AlertNotificationRepository;
import com.movisafe.kidway.platform.incidents.domain.model.aggregates.IncidentReport;
import com.movisafe.kidway.platform.incidents.infrastructure.persistence.jpa.repositories.IncidentReportRepository;
import com.movisafe.kidway.platform.analytics.domain.model.aggregates.AnalyticsReport;
import com.movisafe.kidway.platform.analytics.infrastructure.persistence.jpa.repositories.AnalyticsReportRepository;
import com.movisafe.kidway.platform.companies.domain.model.aggregates.Company;
import com.movisafe.kidway.platform.companies.infrastructure.persistence.jpa.repositories.CompanyRepository;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.stereotype.Component;

    @Component
    public class InitialDataSeeder implements CommandLineRunner {
        private final PlatformUserRepository userRepository;
private final RoleRepository roleRepository;
private final HashingService hashingService;
private final UserProfileRepository userprofilesRepository;
private final SubscriptionRepository subscriptionsRepository;
private final DashboardMetricRepository dashboardRepository;
private final VehicleRepository fleetRepository;
private final DriverRepository driversRepository;
private final SchoolRouteRepository routesRepository;
private final StudentRepository studentsRepository;
private final RouteAssignmentRepository assignmentsRepository;
private final TrackingEventRepository trackingRepository;
private final TripRepository tripsRepository;
private final AttendanceRecordRepository attendanceRepository;
private final AlertNotificationRepository alertsRepository;
private final IncidentReportRepository incidentsRepository;
private final AnalyticsReportRepository analyticsRepository;
private final CompanyRepository companiesRepository;

        public InitialDataSeeder(PlatformUserRepository userRepository, RoleRepository roleRepository, HashingService hashingService, UserProfileRepository userprofilesRepository, SubscriptionRepository subscriptionsRepository, DashboardMetricRepository dashboardRepository, VehicleRepository fleetRepository, DriverRepository driversRepository, SchoolRouteRepository routesRepository, StudentRepository studentsRepository, RouteAssignmentRepository assignmentsRepository, TrackingEventRepository trackingRepository, TripRepository tripsRepository, AttendanceRecordRepository attendanceRepository, AlertNotificationRepository alertsRepository, IncidentReportRepository incidentsRepository, AnalyticsReportRepository analyticsRepository, CompanyRepository companiesRepository) {
            this.userRepository = userRepository;
this.roleRepository = roleRepository;
this.hashingService = hashingService;
this.userprofilesRepository = userprofilesRepository;
this.subscriptionsRepository = subscriptionsRepository;
this.dashboardRepository = dashboardRepository;
this.fleetRepository = fleetRepository;
this.driversRepository = driversRepository;
this.routesRepository = routesRepository;
this.studentsRepository = studentsRepository;
this.assignmentsRepository = assignmentsRepository;
this.trackingRepository = trackingRepository;
this.tripsRepository = tripsRepository;
this.attendanceRepository = attendanceRepository;
this.alertsRepository = alertsRepository;
this.incidentsRepository = incidentsRepository;
this.analyticsRepository = analyticsRepository;
this.companiesRepository = companiesRepository;
        }

        @Override
        public void run(String... args) {

        seedRole("INDEPENDENT_DRIVER", "Independent driver who manages routes, students, trips and parent trust", "Segment 1 - Independent Drivers");
        seedRole("COMPANY_ADMIN", "Owner or administrator of a school transportation company", "Segment 2 - School Transportation Companies");
        seedRole("COMPANY_DRIVER", "Driver employed by a company and assigned to routes", "Segment 2 - School Transportation Companies");
        seedRole("PARENT_GUARDIAN", "Parent or guardian who checks student attendance, route and alerts", "Both target segments as final service recipient");
        seedRole("KIDWAY_ADMIN", "KidWay platform administrator with complete operational visibility", "Internal platform administration");


        seedUser("Juan", "Rojas", "juan.rojas", "juan.rojas@kidway.pe", "INDEPENDENT_DRIVER", "+51911111111");
        seedUser("Maria", "Lopez", "maria.lopez", "maria.lopez@movisafe.pe", "COMPANY_ADMIN", "+51922222222");
        seedUser("Carlos", "Perez", "carlos.perez", "carlos.perez@movisafe.pe", "COMPANY_DRIVER", "+51933333333");
        seedUser("Ana", "Torres", "ana.torres", "ana.torres@familia.pe", "PARENT_GUARDIAN", "+51944444444");
        seedUser("KidWay", "Admin", "admin", "admin@kidway.pe", "KIDWAY_ADMIN", "+51999999999");

        if (userprofilesRepository.count() == 0) {
            userprofilesRepository.save(new UserProfile("juan.rojas@kidway.pe", "Juan Rojas", "INDEPENDENT_DRIVER", "+51911111111", "es-419", "America/Lima", "Critical alerts"));
            userprofilesRepository.save(new UserProfile("maria.lopez@movisafe.pe", "Maria Lopez", "COMPANY_ADMIN", "+51922222222", "en-US", "America/Lima", "Daily summary"));
        }
        if (subscriptionsRepository.count() == 0) {
            subscriptionsRepository.save(new Subscription("Transportes Lopez", "Company Plan", 149.9, "PEN", "PAID", "2026-07-01"));
            subscriptionsRepository.save(new Subscription("Juan Rojas", "Driver Starter", 49.9, "PEN", "PENDING", "2026-07-05"));
        }
        if (dashboardRepository.count() == 0) {
            dashboardRepository.save(new DashboardMetric("active_trips", "Active trips", 12.0, "trips", "company", "up"));
            dashboardRepository.save(new DashboardMetric("attendance_rate", "Attendance rate", 96.8, "%", "company", "stable"));
        }
        if (fleetRepository.count() == 0) {
            fleetRepository.save(new Vehicle("XYZ-987", "Hyundai H1", 12, "ACTIVE", "Transportes Lopez", "Ruta Norte"));
            fleetRepository.save(new Vehicle("ABC-456", "Toyota Hiace", 15, "MAINTENANCE", "Transportes Lopez", "Ruta Este"));
        }
        if (driversRepository.count() == 0) {
            driversRepository.save(new Driver("Juan Rojas", "B-II-123456", "+51911111111", "ACTIVE", "XYZ-987", 4.8));
            driversRepository.save(new Driver("Carlos Perez", "A-II-987654", "+51933333333", "ACTIVE", "KLM-221", 4.6));
        }
        if (routesRepository.count() == 0) {
            routesRepository.save(new SchoolRoute("Ruta Norte", "Los Olivos", "Colegio San Agustin", "06:30 AM", "ACTIVE", 55));
            routesRepository.save(new SchoolRoute("Ruta Este", "La Molina", "Colegio Santa Maria", "06:45 AM", "ACTIVE", 48));
        }
        if (studentsRepository.count() == 0) {
            studentsRepository.save(new Student("Valeria Torres", "Colegio San Agustin", "4th grade", "Ana Torres", "+51944444444", "ACTIVE"));
            studentsRepository.save(new Student("Mateo Salas", "Colegio Santa Maria", "2nd grade", "Luis Salas", "+51955555555", "ACTIVE"));
        }
        if (assignmentsRepository.count() == 0) {
            assignmentsRepository.save(new RouteAssignment("Ruta Norte", "Juan Rojas", "XYZ-987", "Valeria Torres", "Av. Universitaria 1200", "ASSIGNED"));
            assignmentsRepository.save(new RouteAssignment("Ruta Este", "Carlos Perez", "KLM-221", "Mateo Salas", "Javier Prado 3300", "ASSIGNED"));
        }
        if (trackingRepository.count() == 0) {
            trackingRepository.save(new TrackingEvent("XYZ-987", -12.0464, -77.0428, "24 km/h", "2026-06-20T06:45:00", "ON_ROUTE"));
            trackingRepository.save(new TrackingEvent("KLM-221", -12.0875, -76.971, "18 km/h", "2026-06-20T06:47:00", "ON_ROUTE"));
        }
        if (tripsRepository.count() == 0) {
            tripsRepository.save(new Trip("Ruta Norte", "Juan Rojas", "XYZ-987", "2026-06-20T06:30:00", null, "IN_PROGRESS"));
            tripsRepository.save(new Trip("Ruta Este", "Carlos Perez", "KLM-221", "2026-06-20T06:35:00", null, "IN_PROGRESS"));
        }
        if (attendanceRepository.count() == 0) {
            attendanceRepository.save(new AttendanceRecord("Valeria Torres", "Ruta Norte", "2026-06-20", "ON_BOARD", "2026-06-20T06:40:00", "Checked by driver"));
            attendanceRepository.save(new AttendanceRecord("Mateo Salas", "Ruta Este", "2026-06-20", "ABSENT", null, "Guardian notified"));
        }
        if (alertsRepository.count() == 0) {
            alertsRepository.save(new AlertNotification("Vehicle delay", "Vehicle XYZ-987 delayed by 8 minutes", "WARNING", "ACTIVE", "COMPANY_ADMIN", "2026-06-20 06:45"));
            alertsRepository.save(new AlertNotification("Student absent", "Mateo Salas was marked as absent", "INFO", "ACKNOWLEDGED", "PARENT_GUARDIAN", "2026-06-20 06:48"));
        }
        if (incidentsRepository.count() == 0) {
            incidentsRepository.save(new IncidentReport("Minor traffic issue", "Driver reported congestion near Javier Prado", "Ruta Este", "Carlos Perez", "LOW", "OPEN"));
            incidentsRepository.save(new IncidentReport("Student pickup delay", "Student did not arrive at pickup stop on time", "Ruta Norte", "Juan Rojas", "MEDIUM", "IN_REVIEW"));
        }
        if (analyticsRepository.count() == 0) {
            analyticsRepository.save(new AnalyticsReport("Weekly operation summary", "2026-W25", 96.8, 92.0, 2, "PDF"));
            analyticsRepository.save(new AnalyticsReport("Monthly fleet efficiency", "2026-06", 94.5, 88.0, 5, "CSV"));
        }
        if (companiesRepository.count() == 0) {
            companiesRepository.save(new Company("Transportes Lopez SAC", "20601234567", "Maria Lopez", "+51922222222", "ACTIVE", 8));
            companiesRepository.save(new Company("MoviSafe Demo Company", "20607654321", "KidWay Admin", "+51999999999", "ACTIVE", 4));
        }
        }

        private void seedRole(String name, String description, String segment) {
            if (!roleRepository.existsByName(name)) roleRepository.save(new Role(name, description, segment));
        }

        private void seedUser(String firstName, String lastName, String username, String email, String role, String phone) {
            if (!userRepository.existsByUsername(username) && !userRepository.existsByEmail(email)) {
                userRepository.save(new PlatformUser(firstName, lastName, username, email, hashingService.encode("Demo1234"), role, phone, "ACTIVE"));
            }
        }
    }
