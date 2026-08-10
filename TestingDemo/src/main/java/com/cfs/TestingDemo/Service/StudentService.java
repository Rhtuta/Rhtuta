package com.cfs.TestingDemo.Service;

import com.cfs.TestingDemo.Entity.Student;
import com.cfs.TestingDemo.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student)
    {
        if (studentRepository.existsByEmail(student.getEmail()))
        {
            throw new IllegalArgumentException("email already exists.");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id)
    {
        studentRepository.deleteById(id);
    }
}
