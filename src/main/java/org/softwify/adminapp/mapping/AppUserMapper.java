package org.softwify.adminapp.mapping;

import org.mapstruct.Mapper;

import org.softwify.adminapp.dto.AppUserDto;
import org.softwify.adminapp.entities.AppUserEntity;

@Mapper
public interface AppUserMapper {
	AppUserDto toAppUser(AppUserEntity appUserEntity);
	AppUserEntity fromAppUser(AppUserDto appUserDto);
}
