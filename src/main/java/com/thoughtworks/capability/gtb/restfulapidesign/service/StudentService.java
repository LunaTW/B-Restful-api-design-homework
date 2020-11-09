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

    public List<Student> getStudentBySomething(String gender){
        if (gender == null ){
            return studentRepository.getStudents();
        } else{
            return studentRepository.getStudentsByGender(gender);
        }
    }

    public Student getStudentById(Integer Id){
        return studentRepository.getStudentById(Id);
    }

    public List<Student> getStudentsByGender(String gender){
        return studentRepository.getStudentsByGender(gender);
    }

    public void deleteStudentById(Integer Id){
        studentRepository.deleteStudentById(Id);
    }

    public void updateStudent(Integer id,Student student){
        studentRepository.updateStudent(id,student);
    }

}
