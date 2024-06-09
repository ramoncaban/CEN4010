package CEN4010.project.profile_management.repositories;

import org.springframework.data.repository.CrudRepository;

import CEN4010.project.profile_management.domain.entities.ProfileEntity;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Integer> {

}
