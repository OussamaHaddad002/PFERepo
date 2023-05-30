package com.satoripop.com.repository;

import com.satoripop.com.model.ResourcePlanning;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
@Configuration
public interface ResourcePlanningRepository extends CrudRepository<ResourcePlanning , Long> {
}
