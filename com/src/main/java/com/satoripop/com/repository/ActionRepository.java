package com.satoripop.com.repository;

import com.satoripop.com.model.Action;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
@Configuration
public interface ActionRepository extends CrudRepository<Action , Long> {
}
