package com.satoripop.com.controller;

import com.satoripop.com.model.Epic;
import com.satoripop.com.service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EpicController {


    @Autowired
    private EpicService epicService;

    @RequestMapping(method = RequestMethod.GET, value = "/epics")
    public List<Epic> getEpics(){
        return epicService.getEpics();
    }

    @RequestMapping("/epic")
    public Epic getEpic(){
        Epic epic = new Epic(1L,"Me",12,"Me","Me",12,13);
        return epic;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/epic/{id}")
    public Epic getEpicById(@PathVariable long id){
        return epicService.getEpicById(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/epic/{id}")
    public void deleteEpic(@PathVariable long id){
        epicService.deleteEpic(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/epics")
    public void addEpic(@RequestBody Epic epic){
        if (epic.getId() != null && epicService.existsById(epic.getId())) {
            // Generate a new ID if the current one already exists
            epic.setId(null);
        }
        epicService.addEpic(epic);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/epic/{id}")
    public void updateEpic(@RequestBody Epic epic,@PathVariable long id){
        Epic existingEpic = epicService.getEpicById(id);
        if (existingEpic != null) {
            // Update only the non-null properties of the existing epic with the values from the request
            if (epic.getName() != null) {
                existingEpic.setName(epic.getName());
            }
            if (epic.getName() != null) {
                existingEpic.setName(epic.getName());
            }
            if (epic.getDeadline() != 0) {
                existingEpic.setDeadline(epic.getDeadline());
            }

            // Call the update method from the service to save the changes
            epicService.update(existingEpic,id);
        }
    }
}
