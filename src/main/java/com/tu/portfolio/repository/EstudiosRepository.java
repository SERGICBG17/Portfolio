package com.tu.portfolio.repository;

import com.tu.portfolio.model.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiosRepository extends JpaRepository<Estudio, Long> {
}
