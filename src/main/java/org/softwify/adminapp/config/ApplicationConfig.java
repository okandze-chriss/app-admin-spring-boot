package org.softwify.adminapp.config;

import org.mapstruct.factory.Mappers;
import org.softwify.adminapp.mapping.AppRolesMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ApplicationConfig  {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
//
//    @Bean
//    public AppRolesMapper appRolesMapper() {
//        return Mappers.getMapper(AppRolesMapper.class);
//    }
}
