package com.cfs.TestingDemo;

import com.cfs.TestingDemo.Entity.Student;
import com.cfs.TestingDemo.Repo.StudentRepository;
import com.cfs.TestingDemo.Service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.when;

public class ServiceMockTest {

    @Mock
    private StudentRepository repo;

    @InjectMocks
    private StudentService service;

    @Autowired
    private Student student;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        student = new Student("Laxman","laxman@gmail.com",35);
    }

    @Test
    void testAddStudent()
    {
        when(repo.existsByEmail(student.getEmail())).thenReturn(false);
        when(repo.save(student)).thenReturn(student);
        Student res = service.addStudent(student);
        assertEquals("Laxman",res.getName());
    }

    @Test
    void testGetAllStudent()
    {
        when(repo.findAll()).thenReturn(List.of(student));
        List<Student> students = service.getAllStudents();
        assertEquals(1,students.size());
    }
}
