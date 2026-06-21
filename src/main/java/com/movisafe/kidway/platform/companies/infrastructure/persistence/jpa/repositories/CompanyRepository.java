package com.movisafe.kidway.platform.companies.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.companies.domain.model.aggregates.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> { }
