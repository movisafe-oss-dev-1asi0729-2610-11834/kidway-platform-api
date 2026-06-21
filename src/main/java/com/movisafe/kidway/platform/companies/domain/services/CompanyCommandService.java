package com.movisafe.kidway.platform.companies.domain.services;

import com.movisafe.kidway.platform.companies.domain.model.aggregates.Company;

public interface CompanyCommandService {
    Company create(Company resource);
    Company update(Long id, Company resource);
    void delete(Long id);
}
