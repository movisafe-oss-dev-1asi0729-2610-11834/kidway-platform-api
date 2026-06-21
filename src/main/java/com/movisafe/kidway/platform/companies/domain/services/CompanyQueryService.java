package com.movisafe.kidway.platform.companies.domain.services;

import com.movisafe.kidway.platform.companies.domain.model.aggregates.Company;
import java.util.List;

public interface CompanyQueryService {
    List<Company> findAll();
    Company findById(Long id);
}
