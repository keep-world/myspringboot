package com.test.repository;

import com.test.pojo.jpa.dao.TestOneJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestOneJpaRepository extends JpaRepository<TestOneJpa,Integer>{
}
