package CEN4010.project.wishlist.controller;

import CEN4010.project.wishlist.model.TestEntity;
import CEN4010.project.wishlist.service.TestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestEntityController {

    @Autowired
    private TestEntityService testEntityService;

    @PostMapping
    public TestEntity createTestEntity(@RequestParam String name) {
        return testEntityService.createTestEntity(name);
    }
}
