package CEN4010.project.profile_management.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import CEN4010.project.profile_management.domain.dto.CreditCardDto;
import CEN4010.project.profile_management.domain.entities.CreditCardEntity;
import CEN4010.project.profile_management.mappers.Mapper;

@Component
public class CreditCardMapperImpl implements Mapper<CreditCardEntity, CreditCardDto> {
    private final ModelMapper modelMapper;

    public CreditCardMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CreditCardDto mapTo(CreditCardEntity creditCard) {
        return modelMapper.map(creditCard, CreditCardDto.class);
    }

    @Override
    public CreditCardEntity mapFrom(CreditCardDto creditCardDto) {
        return modelMapper.map(creditCardDto, CreditCardEntity.class);
    }
}
