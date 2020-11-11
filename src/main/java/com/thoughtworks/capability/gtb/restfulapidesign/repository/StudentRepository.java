package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.Exception.StudentNotExist;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public List<Student> getStudents(){
        return studentMap.values().stream().collect(Collectors.toList());
    }

    public Student getStudentById(Integer Id) {
        return studentMap.get(Id);
    }

    public List<Student> getStudentsByGender(String gender){
        return studentMap.values().stream()
                .filter(student -> student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public void insert(Student student){
        studentMap.put(student.getId(),student);
    }

    public void deleteStudentById(Integer id){
        studentMap.remove(id);
    }

    public void updateStudent(Integer id, Student student){
        Student studentToUpdate = studentMap.get(id);
        studentToUpdate.setGender(student.getGender());
        studentToUpdate.setName(student.getName());
        studentToUpdate.setNote(student.getNote());
    }

}
