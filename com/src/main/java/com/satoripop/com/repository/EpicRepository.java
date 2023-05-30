package com.satoripop.com.repository;

import com.satoripop.com.model.Epic;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
public interface EpicRepository extends CrudRepository<Epic , Long> {
}
