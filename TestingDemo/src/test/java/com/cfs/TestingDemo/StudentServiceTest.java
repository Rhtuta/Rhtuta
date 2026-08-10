package com.cfs.TestingDemo;

import com.cfs.TestingDemo.Entity.Student;
import com.cfs.TestingDemo.Repo.StudentRepository;
import com.cfs.TestingDemo.Service.StudentService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentServiceTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @BeforeEach
    void deleteAll()
    {
        studentRepository.deleteAll();
    }

    @Test
    @Order(1)
    void shouldAddStudentSuccessfully()
    {
        Student s=new Student("Rohan","Rohan@gmail.com",18);
        Student savedStudent=studentService.addStudent(s);
        assertNotNull(savedStudent);
        assertEquals("Rohan",savedStudent.getName());
    }

    @Test
    @Order(2)
    void shouldFetchStudents()
    {
        Student s1=new Student("vinay","vinay@gmail.com",28);
        Student s2=new Student("Mayank","mayank@gmail.com",25);
        studentService.addStudent(s1);
        studentService.addStudent(s2);
        List<Student> students=studentService.getAllStudents();
        assertEquals(2,students.size());
    }

    @Test
    @Order(3)
    void shouldThrowExceptionForDuplicateEmail()
    {
        Student X=new Student("X","X@gmail.com",23);
        studentService.addStudent(X);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                ()-> studentService.addStudent(new Student("Y","X@gmail.com",27))
        );
        assertEquals("email already exists.",ex.getMessage());
    }
}
