package com.movisafe.kidway.platform.subscriptions.interfaces.rest;

import com.movisafe.kidway.platform.subscriptions.domain.model.aggregates.Subscription;
import com.movisafe.kidway.platform.subscriptions.domain.services.SubscriptionCommandService;
import com.movisafe.kidway.platform.subscriptions.domain.services.SubscriptionQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/subscriptions-payments", "/api/subscriptions-payments", "/api/subscriptions", "/api/payments"})
@Tag(name = "3BC - Subscription & Payments", description = "REST endpoints for 3BC - Subscription & Payments")
public class SubscriptionController {
    private final SubscriptionQueryService queryService;
    private final SubscriptionCommandService commandService;

    public SubscriptionController(SubscriptionQueryService queryService, SubscriptionCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    @GetMapping
    public List<Subscription> getAll() { return queryService.findAll(); }

    @GetMapping("/{id}")
    public Subscription getById(@PathVariable Long id) { return queryService.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subscription create(@RequestBody Subscription resource) { return commandService.create(resource); }

    @PutMapping("/{id}")
    public Subscription update(@PathVariable Long id, @RequestBody Subscription resource) { return commandService.update(id, resource); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { commandService.delete(id); }
}
