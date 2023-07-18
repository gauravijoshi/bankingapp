package com.xoriant.banking.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.xoriant.banking.DTO.EditAccountDTO;
import com.xoriant.banking.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target="accountBalance", ignore=true)
	@Mapping(target="accountStatus", ignore=true)
	@Mapping(target="customer", ignore=true)
	@Mapping(target="dateOfClosure", ignore=true)
	@Mapping(target="transaction", ignore=true)
	void updateAccountFromDto(EditAccountDTO editAccountDTO, @MappingTarget Account entity);
}
