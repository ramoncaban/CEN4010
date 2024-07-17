package CEN4010.project.profile_management.services;

import java.util.List;

import CEN4010.project.profile_management.domain.entities.CreditCardEntity;

public interface CreditCardService {
    public CreditCardEntity createCreditCard(String username, CreditCardEntity creditCard);
    public CreditCardEntity getCreditCard(String creditCardNumber);
    public List<CreditCardEntity> getCreditCardsByUsername(String username);
    public CreditCardEntity updateCreditCard(CreditCardEntity creditCard);
}
