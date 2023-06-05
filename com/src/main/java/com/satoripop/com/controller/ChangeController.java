package com.satoripop.com.controller;

import com.satoripop.com.model.Change;
import com.satoripop.com.model.enumeration.Status;
import com.satoripop.com.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ChangeController {

    @Autowired
    private ChangeService changeService;

    @RequestMapping(method = RequestMethod.GET, value = "/changes")
    public List<Change> getChanges(){
        return changeService.getchanges();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/changes/{id}")
    public Change getChangeById(@PathVariable long id){
        return changeService.getchangeById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/changes/{id}")
    public void deleteChange(@PathVariable long id){
        changeService.deletechange(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changes")
    public void addChange(@RequestBody Change change){
        changeService.addchange(change);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/changes/{id}")
    public void updateChange(@RequestBody Change change, @PathVariable long id){
        changeService.update(change, id);
    }
}
