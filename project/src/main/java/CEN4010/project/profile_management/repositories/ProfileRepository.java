package CEN4010.project.profile_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import CEN4010.project.profile_management.domain.entities.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {

    public ProfileEntity findByUsername(String username);

}
