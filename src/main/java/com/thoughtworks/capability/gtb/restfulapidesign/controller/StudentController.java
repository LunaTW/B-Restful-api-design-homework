package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getStudentsBySomething(@RequestParam(required = false) String gender){
        return studentService.getStudentBySomething(gender);
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        studentService.deleteStudentById(id);
    }

    @PatchMapping(value = "/{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody Student student){
        studentService.updateStudent(id,student);
    }
}
