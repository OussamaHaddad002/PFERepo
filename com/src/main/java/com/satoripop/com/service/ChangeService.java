package com.satoripop.com.service;

import com.satoripop.com.model.Change;
import com.satoripop.com.repository.ChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ChangeService {


    @Autowired
    private ChangeRepository changeRepository;

    public List<Change> getchanges() {
        List<Change> changes = new ArrayList<>();
        changeRepository.findAll().forEach(
                change -> {
                    changes.add(change);
                }

        );
        return changes;
    }

    public void addchange(Change change){
        changeRepository.save(change);
    }
    public void update(Change change, long id){
        changeRepository.save(change);
    }

    public Change getchangeById(long id){
        return changeRepository.findById(id).orElse(null);
    }

    public void deletechange(long id) {
        changeRepository.deleteById(id);
    }

}
