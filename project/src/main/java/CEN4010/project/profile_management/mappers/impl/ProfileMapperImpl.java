package CEN4010.project.profile_management.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import CEN4010.project.profile_management.domain.dto.ProfileDto;
import CEN4010.project.profile_management.domain.entities.ProfileEntity;
import CEN4010.project.profile_management.mappers.Mapper;

@Component
public class ProfileMapperImpl implements Mapper<ProfileEntity, ProfileDto> {
    private final ModelMapper modelMapper;

    public ProfileMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProfileDto mapTo(ProfileEntity profile) {
        return modelMapper.map(profile, ProfileDto.class);
    }

    @Override
    public ProfileEntity mapFrom(ProfileDto profileDto) {
        return modelMapper.map(profileDto, ProfileEntity.class);
    }
}
