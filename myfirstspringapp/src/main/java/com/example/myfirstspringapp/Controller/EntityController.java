package com.example.myfirstspringapp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myfirstspringapp.Model.SimpleEntity;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/DBResposnse")
public class EntityController {
    private final SimpleEntityService simpleEntityService;

    public EntityController(SimpleEntityService simpleEntityService) {
        this.simpleEntityService = simpleEntityService;
    }

    @GetMapping
    public List<SimpleEntity> ListPersons() {
        return simpleEntityService.listAllEntities();
    }

    @PostMapping
    public SimpleEntity postMethodName(@RequestBody SimpleEntity simpleEntity) {
        return simpleEntityService.saveEntity(simpleEntity);
    }
}
