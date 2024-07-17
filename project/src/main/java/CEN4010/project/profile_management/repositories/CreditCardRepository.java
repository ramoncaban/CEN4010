package CEN4010.project.profile_management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import CEN4010.project.profile_management.domain.entities.CreditCardEntity;
import CEN4010.project.profile_management.domain.entities.ProfileEntity;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Integer> {
    public CreditCardEntity findByCardnumber(String cardnumber);
    public List<CreditCardEntity> findByUser(ProfileEntity user);
    public List<CreditCardEntity> findByUserUsername(String username);
}

