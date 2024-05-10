package org.softwify.adminapp.repository;

import org.softwify.adminapp.entities.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer>{
	AppUserEntity findByEmail(String email);
}
