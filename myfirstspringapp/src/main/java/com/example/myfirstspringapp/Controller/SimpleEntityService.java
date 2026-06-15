package com.example.myfirstspringapp.Controller;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myfirstspringapp.Model.SimpleEntity;
import com.example.myfirstspringapp.Repository.SimpleRepository;

@Service
public class SimpleEntityService {
    private final SimpleRepository simpleRepository;

    public SimpleEntityService(SimpleRepository simpleRepository) {
        this.simpleRepository = simpleRepository;
    }

    public List<SimpleEntity> listAllEntities() {
        return simpleRepository.findAll();
    }

    public SimpleEntity saveEntity(SimpleEntity simpleEntity) {
        return simpleRepository.save(simpleEntity);
    }

    public void deleteEntity(SimpleEntity simpleEntity) {
        simpleRepository.delete(simpleEntity);
    }
}
