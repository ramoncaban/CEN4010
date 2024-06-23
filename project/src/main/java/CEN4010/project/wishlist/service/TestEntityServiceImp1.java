package CEN4010.project.wishlist.service;

import CEN4010.project.wishlist.model.TestEntity;
import CEN4010.project.wishlist.repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestEntityServiceImp1 implements TestEntityService {

    @Autowired
    private TestEntityRepository testEntityRepository;

    @Override
    public TestEntity createTestEntity(String name) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName(name);
        return testEntityRepository.save(testEntity);
    }
}
