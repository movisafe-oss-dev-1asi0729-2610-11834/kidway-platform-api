package com.kidway.platform.shared.infrastructure.seed;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kidway.platform.shared.application.internal.services.JsonResourceService;
import com.kidway.platform.shared.infrastructure.persistence.jpa.repositories.JsonResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class KidWayJsonDataSeeder implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(KidWayJsonDataSeeder.class);

    private final ObjectMapper objectMapper;
    private final JsonResourceService jsonResourceService;
    private final JsonResourceRepository repository;
    private final boolean seedEnabled;
    private final boolean resetOnStart;

    public KidWayJsonDataSeeder(
            ObjectMapper objectMapper,
            JsonResourceService jsonResourceService,
            JsonResourceRepository repository,
            @Value("${kidway.seed.enabled:true}") boolean seedEnabled,
            @Value("${kidway.seed.reset-on-start:false}") boolean resetOnStart
    ) {
        this.objectMapper = objectMapper;
        this.jsonResourceService = jsonResourceService;
        this.repository = repository;
        this.seedEnabled = seedEnabled;
        this.resetOnStart = resetOnStart;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (!seedEnabled) {
            LOGGER.info("KidWay JSON seed is disabled.");
            return;
        }
        if (!resetOnStart && repository.count() > 0) {
            LOGGER.info("KidWay JSON seed skipped because data already exists.");
            return;
        }
        if (resetOnStart) {
            repository.deleteAll();
        }
        var resource = new ClassPathResource("data/kidway-db.json");
        var root = objectMapper.readTree(resource.getInputStream());
        root.fields().forEachRemaining(entry -> jsonResourceService.upsertCollectionFromJson(entry.getKey(), entry.getValue()));
        LOGGER.info("KidWay JSON seed completed with {} collections.", root.size());
    }
}
