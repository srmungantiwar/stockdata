package com.app.auth.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.auth.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
