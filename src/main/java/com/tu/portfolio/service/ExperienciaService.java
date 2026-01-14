package com.tu.portfolio.service;

import com.tu.portfolio.model.Experiencia;
import com.tu.portfolio.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExperienciaService {
    @Autowired
    private ExperienciaRepository experienciaRepository;

    public List<Experiencia> getAll() {
        return experienciaRepository.findAll();
    }

    public Experiencia getById(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    public Experiencia create(Experiencia obj) {
        return experienciaRepository.save(obj);
    }

    public Experiencia add(Experiencia obj) {
        return experienciaRepository.save(obj);
    }

    public Experiencia update(Long id, Experiencia obj) {
        obj.setId(id);
        return experienciaRepository.save(obj);
    }

    public void delete(Long id) {
        experienciaRepository.deleteById(id);
    }
}
