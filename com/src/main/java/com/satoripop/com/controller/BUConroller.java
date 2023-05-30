package com.satoripop.com.controller;

import com.satoripop.com.model.Action;
import com.satoripop.com.model.BU;
import com.satoripop.com.model.enumeration.Status;
import com.satoripop.com.service.ActionService;
import com.satoripop.com.service.BUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BUConroller {

    @Autowired
    private BUService buService;

    @RequestMapping(method = RequestMethod.GET, value = "/bus")
    public List<BU> getBUs(){
        return buService.getbus();
    }

    @RequestMapping("/bu")
    public BU getBU(){
        BU bu = new BU(1L,"BSM","Me","Me",1,2);
        return bu;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/bu/{id}")
    public BU getBUById(@PathVariable long id){
        return buService.getbuById(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/bu/{id}")
    public void deleteBU(@PathVariable long id){
        buService.deletebu(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/bus")
    public void addBU(@RequestBody BU BU){
        buService.addbu(BU);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/bu/{id}")
    public void updateBU(@RequestBody BU BU,@PathVariable long id){
        buService.update(BU,id);
    }
}
