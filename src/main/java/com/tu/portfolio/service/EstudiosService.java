package com.tu.portfolio.service;

import com.tu.portfolio.model.Estudio;
import com.tu.portfolio.repository.EstudiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiosService {
    @Autowired
    private EstudiosRepository estudiosRepository;

    public List<Estudio> getAll() {
        return estudiosRepository.findAll();
    }

    public Estudio getById(Long id) {
        return estudiosRepository.findById(id).orElse(null);
    }

    public Estudio create(Estudio obj) {
        return estudiosRepository.save(obj);
    }

    public Estudio add(Estudio obj) {
        return estudiosRepository.save(obj);
    }

    public Estudio update(Long id, Estudio obj) {
        obj.setId(id);
        return estudiosRepository.save(obj);
    }

    public void delete(Long id) {
        estudiosRepository.deleteById(id);
    }
}
