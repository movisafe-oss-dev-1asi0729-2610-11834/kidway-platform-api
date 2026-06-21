package com.movisafe.kidway.platform.attendance.interfaces.rest;

import com.movisafe.kidway.platform.attendance.domain.model.aggregates.AttendanceRecord;
import com.movisafe.kidway.platform.attendance.domain.services.AttendanceRecordCommandService;
import com.movisafe.kidway.platform.attendance.domain.services.AttendanceRecordQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/attendance", "/api/attendance", "/api/attendance-tracking"})
@Tag(name = "12BC - Attendance Tracking", description = "REST endpoints for 12BC - Attendance Tracking")
public class AttendanceRecordController {
    private final AttendanceRecordQueryService queryService;
    private final AttendanceRecordCommandService commandService;

    public AttendanceRecordController(AttendanceRecordQueryService queryService, AttendanceRecordCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<AttendanceRecord> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public AttendanceRecord getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AttendanceRecord create(@RequestBody AttendanceRecord resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public AttendanceRecord update(@PathVariable Long id, @RequestBody AttendanceRecord resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
