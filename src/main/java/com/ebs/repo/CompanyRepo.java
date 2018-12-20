package com.ebs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebs.repo.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
