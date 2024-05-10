package org.softwify.adminapp.mapping;

import org.mapstruct.Mapper;

import org.softwify.adminapp.dto.AppRolesDto;
import org.softwify.adminapp.entities.AppRolesEntity;
import org.springframework.stereotype.Component;

@Mapper
public interface AppRolesMapper {
	AppRolesDto toAppRoles(AppRolesEntity appRolesEntity);
	AppRolesEntity  fromAppRoles(AppRolesDto appRolesDto);

}
