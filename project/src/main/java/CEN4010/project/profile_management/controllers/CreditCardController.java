package CEN4010.project.profile_management.controllers;

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

    // @GetMapping(path = "/profile/{username}")
    // public ResponseEntity<CreditCardDto> getProfile(@PathVariable String username) {
    //     CreditCardEntity creditCardEntity = creditCardService.getProfileUsername(username);
    //     if (profileEntity == null) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(profileMapper.mapTo(profileEntity), HttpStatus.OK);
    // }

    // @PostMapping(path = "/profile")
    // public ResponseEntity<CreditCardDto> createProfile(@RequestBody ProfileDto profile) {
    //     ProfileEntity profileEntity = profileMapper.mapFrom(profile);
    //     ProfileEntity savedProfile =  profileService.createProfile(profileEntity);
    //     return new ResponseEntity<>(profileMapper.mapTo(savedProfile), HttpStatus.CREATED);
    // }

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
