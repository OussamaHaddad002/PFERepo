package com.satoripop.com.service;

import com.satoripop.com.model.Action;
import com.satoripop.com.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        actionRepository.findAll().forEach(
                action -> {
                    actions.add(action);
                }

        );
        return actions;
    }

    public void addAction(Action action){
        actionRepository.save(action);
    }
    public void update(Action action, long id){
        actionRepository.save(action);
    }

    public Action getActionById(long id){
        return actionRepository.findById(id).orElse(null);
    }

    public void deleteAction(long id) {
        actionRepository.deleteById(id);
    }


}

