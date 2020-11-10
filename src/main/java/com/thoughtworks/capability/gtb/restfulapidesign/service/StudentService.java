package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.service.Exception.StudentNotExist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    public void createStudent(Student student) {
        studentRepository.insert(student);
    }

    public List<Student> getStudentBySomething(String gender){
        if (gender == null ){
            return studentRepository.getStudents();
        } else{
            return studentRepository.getStudentsByGender(gender);
        }
    }

    public Student getStudentById(Integer Id) throws StudentNotExist {
//        return studentRepository.getStudentById(Id).orElseThrow(() -> new StudentNotExist("This user is not exist"));
        if (studentRepository.getStudentById(Id)==null){
            throw new StudentNotExist("This user is not exist");
        }else{
            return studentRepository.getStudentById(Id);
        }
    }

    public void deleteStudentById(Integer Id){
        studentRepository.deleteStudentById(Id);
    }

    public void updateStudent(Integer id,Student student){
        studentRepository.updateStudent(id,student);
    }

}
