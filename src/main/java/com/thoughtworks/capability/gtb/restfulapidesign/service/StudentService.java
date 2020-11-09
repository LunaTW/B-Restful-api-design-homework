package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.insert(student);
    }

    public List<Student> getStudents(){
        return studentRepository.getStudents();
    }

    public Student getStudentById(Integer Id){
        return studentRepository.getStudentById(Id);
    }

    public void deleteStudentById(Integer Id){
        studentRepository.deleteStudentById(Id);
    }

    public void updateStudent(Integer id,Student student){
        studentRepository.updateStudent(id,student);
    }

}
