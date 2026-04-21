package com.cfs.SecurityRoleJpaMysql.repo;

import com.cfs.SecurityRoleJpaMysql.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface roleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(String name);
}
