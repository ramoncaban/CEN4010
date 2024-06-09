package CEN4010.project.profile_management.controllers;

import org.springframework.web.bind.annotation.PostMapping;
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

    // @GetMapping(path = "/profile")
    // public ProfileEntity getProfile() {
    //     return ProfileEntity.builder()
    //         .id(1)
    //         .username(".")
    //         .password(".")
    //         .name(".")
    //         .emailAddress(".")
    //         .homeAddress(".")
    //         .build();
    // }

    @PostMapping(path = "/profile")
    public ProfileDto createProfile(@RequestBody ProfileDto profile) {
        ProfileEntity profileEntity = profileMapper.mapFrom(profile);
        ProfileEntity savedProfile =  profileService.creatProfile(profileEntity);
        return profileMapper.mapTo(savedProfile);
    }
    
    
}
