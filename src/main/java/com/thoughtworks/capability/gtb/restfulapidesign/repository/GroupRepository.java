package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GroupRepository {

    private final Map<Integer, Group> groupList = new HashMap<>();

    public GroupRepository(){
        for ( int i = 1; i<7;i++){
            Group group = new Group( i,"Group "+String.valueOf(i),"", new ArrayList<>());  // Group: id,name,note,studentList;
            groupList.put(i,group);
        }
    }

    public List<Group> getGroupList(){
        return new ArrayList<>(groupList.values());
    }

    public Group getGroupById(Integer id){
        return groupList.get(id);
    }

    public void updateGroup(Group group){
        Group groupToUpdate = groupList.get(group.getId());
        groupToUpdate.setName(group.getName());
        groupToUpdate.setNote(group.getNote());
        groupToUpdate.setStudentList(group.getStudentList());
//        groupList.put(group.getId(), groupToUpdate);
    }

}
