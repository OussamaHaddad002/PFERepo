package com.satoripop.com.controller;

import com.satoripop.com.model.ResourcePlanning;
import com.satoripop.com.model.enumeration.*;
import com.satoripop.com.service.ResourcePlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ResourcePlanningController {
    @Autowired
    private ResourcePlanningService resourcePlanningService;

    @RequestMapping(method = RequestMethod.GET, value = "/resourcePlannings")
    public List<ResourcePlanning> getResourcePlannings(){
        return resourcePlanningService.getResourcePlannings();
    }

    @RequestMapping("/resourcePlanning")
    public ResourcePlanning getResourcePlanning(){
        ResourcePlanning resourcePlanning = new ResourcePlanning(1L,"Me" ,Role.BSM, bus.CLOUD ,Regime.FullTime,11,12,2F, Res.Allocated,"Me","Me",15,14,14F);
        return resourcePlanning;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/resourcePlanning/{id}")
    public ResourcePlanning getResourcePlanningById(@PathVariable long id){
        return resourcePlanningService.getResourcePlanningById(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/resourcePlanning/{id}")
    public void deleteResourcePlanning(@PathVariable long id){
        resourcePlanningService.deleteResourcePlanning(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/resourcePlannings")
    public void addResourcePlanning(@RequestBody ResourcePlanning ResourcePlanning){
        resourcePlanningService.addResourcePlanning(ResourcePlanning);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/resourcePlanning/{id}")
    public void updateResourcePlanning(@RequestBody ResourcePlanning resourcePlanning,@PathVariable long id){
        resourcePlanningService.update(resourcePlanning,id);
    }

}
