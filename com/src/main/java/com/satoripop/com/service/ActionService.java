package com.satoripop.com.service;

import com.satoripop.com.model.Action;
import com.satoripop.com.model.Epic;
import com.satoripop.com.repository.ActionRepository;
import com.satoripop.com.repository.EpicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private EpicRepository epicRepository;

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


    public void saveActionWithEpic(Action action) {
        Epic epic = action.getEpic();

        // Save the Epic instance if it's new or not yet persisted
        if (epic.getId() == null) {
            epicRepository.save(epic);
        }

        // Set the saved Epic in the Action instance
        action.setEpic(epic);

        // Save the Action instance
        actionRepository.save(action);
    }
}

