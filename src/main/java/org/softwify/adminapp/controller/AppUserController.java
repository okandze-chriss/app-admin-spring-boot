package org.softwify.adminapp.controller;

import jakarta.validation.Valid;
import org.softwify.adminapp.dto.AppUserDto;
import org.softwify.adminapp.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class AppUserController {
    private  final AppUserService appUserService;
    public AppUserController(AppUserService appUserService) {
        super();
        this.appUserService = appUserService;
    }

    @GetMapping("/test")
    public String getTest(){
        return "Bonjour";
    }

    @GetMapping("/list")
    public List<AppUserDto> getAppUsers(){
        return appUserService.getAppUsers();
    }

    @GetMapping("/list/{id}")
    public AppUserDto getAppUser(@PathVariable("id") int id){
        return appUserService.getAppUser(id);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppUserDto createAppUser(@Valid @RequestBody AppUserDto appUser){
        return appUserService.createAppUser(appUser);
    }

    @PutMapping("update/{id}")
    public AppUserDto updateAppUser(@PathVariable("id") int id, @Valid @RequestBody AppUserDto appUser){

        return appUserService.updateAppUser(id, appUser);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAppUser(@PathVariable("id") int id){

        appUserService.deleteAppUser(id);
    }

}
