package com.satoripop.com.service;

import com.satoripop.com.model.Projet;
import com.satoripop.com.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProjectService {

    @Autowired
    private ProjetRepository projetRepository;

    public List<Projet> getProjets() {
        List<Projet> projets = new ArrayList<>();
        projetRepository.findAll().forEach(
                projet -> {
                    projets.add(projet);
                }
        );



        return projets;
    }

    public void addProjet(Projet projet){
        projetRepository.save(projet);
    }
    public void update(Projet projet, long id){
        projetRepository.save(projet);
    }

    public Projet getProjetById(long id){ return projetRepository.findById(id).orElse(null);
    }

    public void deleteProjet(long id) {
        projetRepository.deleteById(id);
    }
}
