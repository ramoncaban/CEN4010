package CEN4010.project.profile_management.services;

import CEN4010.project.profile_management.domain.entities.ProfileEntity;

public interface ProfileService {

    

    ProfileEntity createProfile(ProfileEntity profile);

    ProfileEntity getProfileUsername(String username);
}
