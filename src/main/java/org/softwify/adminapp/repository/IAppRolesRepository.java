package org.softwify.adminapp.repository;

import org.softwify.adminapp.entities.AppRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IAppRolesRepository extends JpaRepository<AppRolesEntity, Integer> {

}
