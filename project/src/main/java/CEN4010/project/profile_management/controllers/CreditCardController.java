package CEN4010.project.profile_management.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CEN4010.project.profile_management.domain.dto.CreditCardDto;
import CEN4010.project.profile_management.domain.entities.CreditCardEntity;
import CEN4010.project.profile_management.domain.entities.ProfileEntity;
import CEN4010.project.profile_management.mappers.Mapper;
import CEN4010.project.profile_management.services.CreditCardService;
import CEN4010.project.profile_management.services.ProfileService;

@RestController
public class CreditCardController {
    private final CreditCardService creditCardService;
    private final ProfileService profileService;
    private final Mapper<CreditCardEntity, CreditCardDto> creditCardMapper;

    public CreditCardController(CreditCardService creditCardService, ProfileService profileService, Mapper<CreditCardEntity, CreditCardDto> creditCardMapper) {
        this.creditCardService = creditCardService;
        this.profileService = profileService;
        this.creditCardMapper = creditCardMapper;
    }

    @GetMapping(path = "/creditcard/{creditCardNumber}")
    public ResponseEntity<CreditCardDto> getCreditCard(@PathVariable String creditCardNumber) {
        CreditCardEntity creditCardEntity = creditCardService.getCreditCard(creditCardNumber);
        if (creditCardEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(creditCardMapper.mapTo(creditCardEntity), HttpStatus.OK);
    }

    @PostMapping(path = "/user/{username}/creditcard")
    public ResponseEntity<CreditCardDto> createCreditCard(@PathVariable String username, @RequestBody CreditCardDto creditCard) {
        ProfileEntity profileEntity = profileService.getProfileUsername(username);
        if (profileEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CreditCardEntity creditCardEntity = creditCardMapper.mapFrom(creditCard);
        creditCardEntity.setUser(profileEntity);

        creditCardEntity.setCardowner(profileEntity.getName());
        CreditCardEntity savedCreditCard = creditCardService.createCreditCard(username, creditCardEntity);

        return new ResponseEntity<>(creditCardMapper.mapTo(savedCreditCard), HttpStatus.CREATED);
    }

}
