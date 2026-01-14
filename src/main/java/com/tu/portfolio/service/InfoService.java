package com.tu.portfolio.service;

import com.tu.portfolio.model.Info;
import com.tu.portfolio.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InfoService {
    @Autowired
    private InfoRepository infoRepository;

    public List<Info> getAll() {
        return infoRepository.findAll();
    }

    public Info getById(Long id) {
        return infoRepository.findById(id).orElse(null);
    }

    public Info create(Info obj) {
        return infoRepository.save(obj);
    }

    public Info add(Info obj) {
        return infoRepository.save(obj);
    }

    public Info update(Long id, Info obj) {
        obj.setId(id);
        return infoRepository.save(obj);
    }

    public void delete(Long id) {
        infoRepository.deleteById(id);
    }
}
