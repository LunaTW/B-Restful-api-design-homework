package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> randomlyAllocate(){
        return groupService.randomlyAllocate();
    }

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Integer id){
        return groupService.getGroupById(id);
    }

    @PutMapping("/{id}")
    public void updateGroup(@RequestBody Group group){
        groupService.updateGroup(group);
    }

}
