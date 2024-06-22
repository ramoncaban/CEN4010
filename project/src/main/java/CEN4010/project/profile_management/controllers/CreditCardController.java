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
import CEN4010.project.profile_management.mappers.Mapper;
import CEN4010.project.profile_management.services.CreditCardService;

@RestController
public class CreditCardController {
    private final CreditCardService creditCardService;

    private final Mapper<CreditCardEntity, CreditCardDto> creditCardMapper;

    public CreditCardController(CreditCardService creditCardService, Mapper<CreditCardEntity, CreditCardDto> creditCardMapper) {
        this.creditCardService = creditCardService;
        this.creditCardMapper = creditCardMapper;
    }

    @GetMapping(path = "/creditcard/{username}")
    public ResponseEntity<CreditCardDto> getCreditCard(@PathVariable String creditCardNumber) {
        CreditCardEntity creditCardEntity = creditCardService.getCreditCard(creditCardNumber);
        if (creditCardEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(creditCardMapper.mapTo(creditCardEntity), HttpStatus.OK);
    }

    @PostMapping(path = "/creditcard")
    public ResponseEntity<CreditCardDto> createCreditCard(@RequestBody CreditCardDto creditCard) {
        CreditCardEntity creditCardEntity = creditCardMapper.mapFrom(creditCard);
        CreditCardEntity savedCreditCard =  creditCardService.createCreditCard(creditCardEntity);
        return new ResponseEntity<>(creditCardMapper.mapTo(savedCreditCard), HttpStatus.CREATED);
    }

    // @PutMapping(path = "/profile/{username}")
    // public ResponseEntity<ProfileDto> updateProfile(@PathVariable String username, @RequestBody ProfileDto profile) {
    //     ProfileEntity profileEntity = profileMapper.mapFrom(profile);
    //     ProfileEntity updatedProfile = profileService.updateProfileUsername(username, profileEntity);
    //     if (updatedProfile == null) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(profileMapper.mapTo(updatedProfile), HttpStatus.OK);
    // }
}
