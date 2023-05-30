package com.satoripop.com.controller;

import com.satoripop.com.model.Projet;
import com.satoripop.com.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProjetController {

    @Autowired
    private ProjectService projetService;

    @RequestMapping(method = RequestMethod.GET, value = "/projets")
    public List<Projet> getProjets(){
        return projetService.getProjets();
    }

    @RequestMapping("/projet")
    public Projet getProjet(){
        Projet projet = new Projet(1L,"Me","type1",12,15,"Me","Me",10,11);
        return projet;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/projet/{id}")
    public Projet getProjetById(@PathVariable long id){
        return projetService.getProjetById(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/projet/{id}")
    public void deleteProjet(@PathVariable long id){
        projetService.deleteProjet(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/projets")
    public void addProjet(@RequestBody Projet Projet){
        projetService.addProjet(Projet);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/projet/{id}")
    public void updateProjet(@RequestBody Projet Projet,@PathVariable long id){
        projetService.update(Projet,id);
    }
}
