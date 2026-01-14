package com.tu.portfolio.service;

import com.tu.portfolio.model.Proyecto;
import com.tu.portfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> getAll() {
        return proyectoRepository.findAll();
    }

    public Proyecto getById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    public Proyecto create(Proyecto obj) {
        return proyectoRepository.save(obj);
    }

    public Proyecto add(Proyecto obj) {
        return proyectoRepository.save(obj);
    }

    public Proyecto update(Long id, Proyecto obj) {
        obj.setId(id);
        return proyectoRepository.save(obj);
    }

    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }
}
