package org.softwify.adminapp.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.softwify.adminapp.repository.IAppUserRepository;
import org.softwify.adminapp.dto.AppUserDto;
import org.softwify.adminapp.exception.EntityNotFoundException;
import org.softwify.adminapp.exception.RequestException;
import org.softwify.adminapp.mapping.AppUserMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserService {
	private final IAppUserRepository appUserRepository;
	private final AppUserMapper appUserMapper;
	MessageSource messageSource;
	
	
	public AppUserService(IAppUserRepository appUserRepository, AppUserMapper appUserMapper,
			MessageSource messageSource) {
		super();
		this.appUserRepository = appUserRepository;
		this.appUserMapper = appUserMapper;
		this.messageSource = messageSource;
	}
	
	@Transactional(readOnly = true)
	public List<AppUserDto> getAppUsers(){
		return StreamSupport.stream(appUserRepository.findAll().spliterator(), false)
				.map(appUserMapper::toAppUser)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public AppUserDto getAppUser(int id){
		return appUserMapper.toAppUser(appUserRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[] {id}, Locale.getDefault()))));
	}
	
	@Transactional
	public AppUserDto createAppUser(AppUserDto appUser){
		return appUserMapper.toAppUser(appUserRepository.save(appUserMapper.fromAppUser(appUser)));
	}
	
	
	@Transactional
	public AppUserDto updateAppUser(int id, AppUserDto appUser){
		return appUserRepository.findById(id)
				.map(entity -> {
					appUser.setId(id);
					return appUserMapper.toAppUser(appUserRepository.save(appUserMapper.fromAppUser(appUser)));
				}).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id}, Locale.getDefault())));
	}
	
	@Transactional
	public void deleteAppUser(int id){
		try {
			appUserRepository.deleteById(id);
		} catch (Exception e) {
			throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[] {id}, Locale.getDefault()), HttpStatus.CONFLICT);
		}
	}

}
