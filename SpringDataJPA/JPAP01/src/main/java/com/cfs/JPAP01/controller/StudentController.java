package com.cfs.JPAP01.controller;

import com.cfs.JPAP01.entity.Student;
import com.cfs.JPAP01.repo.StudentRepo;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {
    private final StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @PutMapping
    public Student updateStudent(@RequestParam Long id, @RequestBody Student student){
       Student s = studentRepo.findById(id).orElseThrow(()->
               new RuntimeException("Student not found"));

       s.setId(student.getId());
       s.setName(student.getName());
       s.setEmail(student.getEmail());
       return studentRepo.save(s);

    }

    @PatchMapping
    public Student patchStudent(@RequestParam Long id, @RequestParam String name){
        Student s = studentRepo.findById(id).orElseThrow(()->
                new RuntimeException("Student not found"));

        s.setName(name);
        return s;


    }
}
