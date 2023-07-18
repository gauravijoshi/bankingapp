package com.xoriant.banking.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.xoriant.banking.DTO.EditCustomerDTO;
import com.xoriant.banking.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateCustomerFromDto(EditCustomerDTO editCustomerDTO, @MappingTarget Customer entity);


}
