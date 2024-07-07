package CEN4010.project.wishlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CEN4010.project.wishlist.model.TestEntity;
import CEN4010.project.wishlist.service.TestEntityService;

@RestController
@RequestMapping("/api/test")
public class TestEntityController {

    @Autowired
    private TestEntityService testEntityService;

    @PostMapping
    public TestEntity createTestEntity(@RequestParam String name) {
        return testEntityService.createTestEntity(name);
    }// Testing new push
}
