package CEN4010.project.profile_management.services;

import CEN4010.project.profile_management.domain.entities.CreditCardEntity;

public interface CreditCardService {
    CreditCardEntity createCreditCard(CreditCardEntity creditCard);

    CreditCardEntity getCreditCard(String creditCardNumber);
}
