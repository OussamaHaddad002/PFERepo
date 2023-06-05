package com.satoripop.com.controller;

import com.satoripop.com.model.Action;
import com.satoripop.com.model.enumeration.Status;
import com.satoripop.com.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

//    @PostMapping("/actions")
//    public ResponseEntity<String> createActionWithEpic(@RequestBody Action action) {
//        actionService.saveActionWithEpic(action);
//        return ResponseEntity.ok("Action created successfully");
//    }
@RequestMapping(method = RequestMethod.PUT, value = "/action/{id}")
public void updateAction(@RequestBody Action action, @PathVariable long id) {
    Action existingAction = actionService.getActionById(id);
    if (existingAction != null) {
        // Update only the non-null properties of the existing action with the values from the request
        if (action.getDescription() != null) {
            existingAction.setDescription(action.getDescription());
        }
        if (action.getDeadline() != null) {
            existingAction.setDeadline(action.getDeadline());
        }
        if (action.getEffort() != null) {
            existingAction.setEffort(action.getEffort());
        }
        if (action.getStatus() != null) {
            existingAction.setStatus(action.getStatus());
        }
        if (action.getCreatedBy() != null) {
            existingAction.setCreatedBy(action.getCreatedBy());
        }
        if (action.getLastModifiedBy() != null) {
            existingAction.setLastModifiedBy(action.getLastModifiedBy());
        }
        if (action.getCreatedDate() != 0) {
            existingAction.setCreatedDate(action.getCreatedDate());
        }
        if (action.getLastModifiedDate() != 0) {
            existingAction.setLastModifiedDate(action.getLastModifiedDate());
        }
        if (action.getAssignedTo() != null) {
            existingAction.setAssignedTo(action.getAssignedTo());
        }
        if (action.getEpic() != null) {
            existingAction.setEpic(action.getEpic());
        }

        // Call the update method from the service to save the changes
        actionService.update(existingAction,id);
    }
}


}
