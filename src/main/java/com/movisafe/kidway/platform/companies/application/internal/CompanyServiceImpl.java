package com.movisafe.kidway.platform.companies.application.internal;

import com.movisafe.kidway.platform.companies.domain.model.aggregates.Company;
import com.movisafe.kidway.platform.companies.domain.services.CompanyCommandService;
import com.movisafe.kidway.platform.companies.domain.services.CompanyQueryService;
import com.movisafe.kidway.platform.companies.infrastructure.persistence.jpa.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompanyServiceImpl implements CompanyCommandService, CompanyQueryService {
    private final CompanyRepository repository;
    public CompanyServiceImpl(CompanyRepository repository) { this.repository = repository; }

    @Override
    public List<Company> findAll() { return repository.findAll(); }

    @Override
    public Company findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Company not found with id " + id)); }

    @Override
    public Company create(Company resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public Company update(Long id, Company resource) {
        var existing = findById(id);
    existing.setLegalName(resource.getLegalName());
    existing.setRuc(resource.getRuc());
    existing.setAdminName(resource.getAdminName());
    existing.setPhone(resource.getPhone());
    existing.setStatus(resource.getStatus());
    existing.setFleetSize(resource.getFleetSize());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
