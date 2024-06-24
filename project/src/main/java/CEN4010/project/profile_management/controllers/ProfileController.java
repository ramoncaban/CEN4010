package CEN4010.project.profile_management.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CEN4010.project.profile_management.domain.dto.ProfileDto;
import CEN4010.project.profile_management.domain.entities.ProfileEntity;
import CEN4010.project.profile_management.mappers.Mapper;
import CEN4010.project.profile_management.services.ProfileService;



@RestController
public class ProfileController {

    private final ProfileService profileService;

    private final Mapper<ProfileEntity, ProfileDto> profileMapper;

    public ProfileController(ProfileService profileService, Mapper<ProfileEntity, ProfileDto> profilMapper) {
        this.profileService = profileService;
        this.profileMapper = profilMapper;
    }

    @GetMapping(path = "/profile/{username}")
    public ResponseEntity<ProfileDto> getProfile(@PathVariable String username) {
        ProfileEntity profileEntity = profileService.getProfileUsername(username);
        if (profileEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(profileMapper.mapTo(profileEntity), HttpStatus.OK);
    }

    @PostMapping(path = "/profile")
    public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profile) {
        ProfileEntity profileEntity = profileMapper.mapFrom(profile);
        ProfileEntity savedProfile =  profileService.createProfile(profileEntity);
        return new ResponseEntity<>(profileMapper.mapTo(savedProfile), HttpStatus.CREATED);
    }

    @PutMapping(path = "/profile/{username}")
    public ResponseEntity<ProfileDto> updateProfile(@PathVariable String username, @RequestBody ProfileDto profile) {
        ProfileEntity existingProfile = profileService.getProfileUsername(username);
        if (existingProfile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ProfileEntity profileEntity = profileMapper.mapFrom(profile);
        profileEntity.setEmailAddress(existingProfile.getEmailAddress());

        ProfileEntity updatedProfile = profileService.updateProfileUsername(username, profileEntity);
        if (updatedProfile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(profileMapper.mapTo(updatedProfile), HttpStatus.OK);
    }
}