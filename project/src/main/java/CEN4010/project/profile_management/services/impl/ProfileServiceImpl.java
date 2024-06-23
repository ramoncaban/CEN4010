package CEN4010.project.profile_management.services.impl;

import org.springframework.stereotype.Service;

import CEN4010.project.profile_management.domain.entities.ProfileEntity;
import CEN4010.project.profile_management.repositories.ProfileRepository;
import CEN4010.project.profile_management.services.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ProfileEntity createProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }

    @Override
    public ProfileEntity getProfileUsername(String username) {
        return profileRepository.findByUsername(username);
    }

    

}
