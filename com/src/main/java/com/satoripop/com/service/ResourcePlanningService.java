package com.satoripop.com.service;

import com.satoripop.com.model.ResourcePlanning;
import com.satoripop.com.repository.ResourcePlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ResourcePlanningService {
    @Autowired
    private ResourcePlanningRepository resourcePlanningRepository;

    public List<ResourcePlanning> getResourcePlannings() {
        List<ResourcePlanning> resourcePlannings = new ArrayList<>();
        resourcePlanningRepository.findAll().forEach(
                resourcePlanning -> {
                    resourcePlannings.add(resourcePlanning);
                }
        );



        return resourcePlannings;
    }

    public void addResourcePlanning(ResourcePlanning resourcePlanning){
        resourcePlanningRepository.save(resourcePlanning);
    }
    public void update(ResourcePlanning resourcePlanning, long id){
        resourcePlanningRepository.save(resourcePlanning);
    }

    public ResourcePlanning getResourcePlanningById(long id){ return resourcePlanningRepository.findById(id).orElse(null);
    }

    public void deleteResourcePlanning(long id) {
        resourcePlanningRepository.deleteById(id);
    }
}
