package com.movisafe.kidway.platform.students.interfaces.rest;

import com.movisafe.kidway.platform.students.domain.model.aggregates.Student;
import com.movisafe.kidway.platform.students.domain.services.StudentCommandService;
import com.movisafe.kidway.platform.students.domain.services.StudentQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/students", "/api/students"})
@Tag(name = "8BC - Student Management", description = "REST endpoints for 8BC - Student Management")
public class StudentController {
    private final StudentQueryService queryService;
    private final StudentCommandService commandService;

    public StudentController(StudentQueryService queryService, StudentCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<Student> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
