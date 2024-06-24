
package CEN4010.project.profile_management.services;

import CEN4010.project.profile_management.domain.entities.ProfileEntity;

public interface CreditCardService {
    ProfileEntity createProfile(ProfileEntity profile);

    ProfileEntity getProfileUsername(String username);
}
 