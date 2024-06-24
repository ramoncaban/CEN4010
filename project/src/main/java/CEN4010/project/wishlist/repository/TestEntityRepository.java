package CEN4010.project.wishlist.repository;

import CEN4010.project.wishlist.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
}
