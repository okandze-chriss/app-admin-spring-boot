package org.softwify.adminapp.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.softwify.adminapp.repository.IAppRolesRepository;
import org.softwify.adminapp.dto.AppRolesDto;
import org.softwify.adminapp.exception.EntityNotFoundException;
import org.softwify.adminapp.exception.RequestException;
import org.softwify.adminapp.mapping.AppRolesMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppRolesService {
	private final IAppRolesRepository appRolesRepository;
	private final AppRolesMapper appRolesMapper;
	MessageSource messageSource;

	public AppRolesService(IAppRolesRepository appRolesRepository, AppRolesMapper appRolesMapper, MessageSource messageSource) {
		super();
		this.appRolesRepository = appRolesRepository;
		this.appRolesMapper = appRolesMapper;
		this.messageSource = messageSource;
	}
	
	@Transactional(readOnly = true)
	public List<AppRolesDto> getAppRoles(){
		return StreamSupport.stream(appRolesRepository.findAll().spliterator(), false)
				.map(appRolesMapper::toAppRoles)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public AppRolesDto getAppRole(int id){
		return appRolesMapper.toAppRoles(
				appRolesRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[] {id}, Locale.getDefault()))));
	}

	@Transactional
	public AppRolesDto createAppRole(AppRolesDto appRoles){
		return appRolesMapper.toAppRoles(appRolesRepository.save(appRolesMapper.fromAppRoles(appRoles)));
	}
	
	
	@Transactional
	public AppRolesDto updateAppRole(int id, AppRolesDto appRoles){
		return appRolesRepository.findById(id)
				.map(entity -> {
					appRoles.setId(id);
					return appRolesMapper.toAppRoles(appRolesRepository.save(appRolesMapper.fromAppRoles(appRoles)));
				}).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id}, Locale.getDefault())));
	}
	
	
	
	@Transactional
	public void deleteAppRole(int id){
		try {
			appRolesRepository.deleteById(id);
		} catch (Exception e) {
			throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[] {id}, Locale.getDefault()), HttpStatus.CONFLICT);
		}
	}
	
	
	
}
