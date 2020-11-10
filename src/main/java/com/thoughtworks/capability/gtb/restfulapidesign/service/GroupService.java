package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository = new StudentRepository();
    private final StudentService studentService = new StudentService();

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> randomlyAllocate(){
        List<Group> groupList = groupRepository.getGroupList();
        groupList.forEach(
            group -> group.setStudentList(new ArrayList<>())
        );
//        List<Student> studentList = studentRepository.getStudents();
        List<Student> studentList = studentService.getStudentBySomething(null);
        System.out.println("+++++++++++++++++++");
        System.out.println(studentList);
        System.out.println("+++++++++++++++++++");
        Collections.shuffle(studentList);
        for (int i=1;i<=studentList.size();i++){
            groupList.get(i%groupList.size()).getStudentList().add(studentList.get(i));
        }
        for (Group group:groupList){
            groupRepository.updateGroup(group);
        }
        return groupRepository.getGroupList();
    }

    public Group getGroupById(Integer id){
        return groupRepository.getGroupById(id);
    }

    public void updateGroup(Group group){
        groupRepository.updateGroup(group);
    }
}
