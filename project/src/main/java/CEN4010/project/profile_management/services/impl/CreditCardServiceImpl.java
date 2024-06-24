package CEN4010.project.profile_management.services.impl;

import org.springframework.stereotype.Service;

import CEN4010.project.profile_management.domain.entities.CreditCardEntity;
import CEN4010.project.profile_management.repositories.CreditCardRepository;
import CEN4010.project.profile_management.services.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public CreditCardEntity createCreditCard(CreditCardEntity creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCardEntity getCreditCard(String creditCardNumber) {
        return creditCardRepository.findByCardNumber(creditCardNumber);
    }
}
