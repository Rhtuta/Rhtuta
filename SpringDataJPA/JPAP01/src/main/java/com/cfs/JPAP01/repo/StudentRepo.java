package com.cfs.JPAP01.repo;

import com.cfs.JPAP01.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  StudentRepo extends JpaRepository<Student,Long> {
}
