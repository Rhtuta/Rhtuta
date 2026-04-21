package com.cfs.SecurityRoleJpaMysql.repo;

import com.cfs.SecurityRoleJpaMysql.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<AppUser,String> {

    Optional<AppUser> findByUsername(String name);
}
