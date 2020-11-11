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
    private final StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public List<Group> randomlyAllocate(){
        List<Group> groupList = groupRepository.getGroupList();
        groupList.forEach(
            group -> group.setStudentList(new ArrayList<>())
        );

        List<Student> studentList = studentRepository.getStudents();
        Collections.shuffle(studentList);
        for (int i=0;i<studentList.size();i++){
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
