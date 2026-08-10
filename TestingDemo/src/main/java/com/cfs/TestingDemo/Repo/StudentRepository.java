package com.cfs.TestingDemo.Repo;

import com.cfs.TestingDemo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    boolean existsByEmail(String email);
}
