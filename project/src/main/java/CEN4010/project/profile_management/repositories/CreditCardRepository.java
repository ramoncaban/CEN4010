package CEN4010.project.profile_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import CEN4010.project.profile_management.domain.entities.CreditCardEntity;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Integer> {
    public CreditCardEntity findByCardNumber(String cardNumber);

    public CreditCardEntity save(CreditCardEntity creditCardNumber);

}
