package com.satoripop.com.service;

import com.satoripop.com.model.Epic;
import com.satoripop.com.repository.EpicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class EpicService {

    @Autowired
    private EpicRepository epicRepository;

    public List<Epic> getEpics() {
        List<Epic> epics = new ArrayList<>();
        epicRepository.findAll().forEach(
                epic -> {
                    epics.add(epic);
                }

        );
        return epics;
    }

    public void addEpic(Epic epic){ epicRepository.save(epic);
    }
    public void update(Epic epic, long id){
        epicRepository.save(epic);
    }

    public Epic getEpicById(long id){
        return epicRepository.findById(id).orElse(null);
    }

    public void deleteEpic(long id) {
        epicRepository.deleteById(id);
    }
    public boolean existsById(Long id) {
        return epicRepository.existsById(id);
    }
}
