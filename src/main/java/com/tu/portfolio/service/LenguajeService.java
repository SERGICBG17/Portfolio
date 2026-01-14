package com.tu.portfolio.service;

import com.tu.portfolio.model.Lenguaje;
import com.tu.portfolio.repository.LenguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenguajeService {
    @Autowired
    private LenguajeRepository lenguajeRepository;

    public List<Lenguaje> getAll() {
        return lenguajeRepository.findAll();
    }

    public Lenguaje getById(Long id) {
        return lenguajeRepository.findById(id).orElse(null);
    }

    public Lenguaje create(Lenguaje obj) {
        return lenguajeRepository.save(obj);
    }

    public Lenguaje add(Lenguaje obj) {
        return lenguajeRepository.save(obj);
    }

    public Lenguaje update(Long id, Lenguaje obj) {
        obj.setId(id);
        return lenguajeRepository.save(obj);
    }

    public void delete(Long id) {
        lenguajeRepository.deleteById(id);
    }
}
