package org.softwify.adminapp.controller;

import java.util.List;
import org.softwify.adminapp.dto.AppRolesDto;
import org.softwify.adminapp.service.AppRolesService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/roles")
public class AppRolesController {
	private final AppRolesService appRolesService;

	public AppRolesController(AppRolesService appRolesService) {
		super();
		this.appRolesService = appRolesService;
	}

	@GetMapping("/test")
	public String getTest(){
		return "Bonjour";
	}

	@GetMapping("/list")
	public List<AppRolesDto> getAppRoles(){
		return appRolesService.getAppRoles();
	}

	@GetMapping("/list/{id}")
	public AppRolesDto getAppRole(@PathVariable("id") int id){
		return appRolesService.getAppRole(id);
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AppRolesDto createAppRole(@Valid @RequestBody AppRolesDto appRole){
		return appRolesService.createAppRole(appRole);
	}

	@PutMapping("update/{id}")
	public AppRolesDto updateAppRole(@PathVariable("id") int id, @Valid @RequestBody AppRolesDto appRole){
		
		return appRolesService.updateAppRole(id, appRole);
	}

	@DeleteMapping("delete/{id}")
	public void deleteAppRole(@PathVariable("id") int id){
		
		appRolesService.deleteAppRole(id);
	}
}
