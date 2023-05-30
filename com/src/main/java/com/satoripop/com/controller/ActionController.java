package com.satoripop.com.controller;

import com.satoripop.com.model.Action;
import com.satoripop.com.model.enumeration.Status;
import com.satoripop.com.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ActionController {

    @Autowired
    private ActionService actionService;

    @RequestMapping(method = RequestMethod.GET, value = "/actions")
    public List<Action> getActions(){
        return actionService.getActions();
    }

    @RequestMapping("/action")
    public Action getAction(){
        Action action = new Action(1L,"Text","2023" ,2F, Status.Pending,"Me","Me",2023,2023);
        return action;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/action/{id}")
    public Action getActionById(@PathVariable long id){
        return actionService.getActionById(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/action/{id}")
    public void deleteAction(@PathVariable long id){
        actionService.deleteAction(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/actions")
    public void addAction(@RequestBody Action Action){
        actionService.addAction(Action);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/action/{id}")
    public void updateAction(@RequestBody Action Action,@PathVariable long id){
        actionService.update(Action,id);
    }

}
