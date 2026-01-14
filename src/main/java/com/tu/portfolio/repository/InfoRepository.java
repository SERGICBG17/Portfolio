package com.tu.portfolio.repository;

import com.tu.portfolio.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
}
