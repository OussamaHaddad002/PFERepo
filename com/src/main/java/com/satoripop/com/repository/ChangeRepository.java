package com.satoripop.com.repository;

import com.satoripop.com.model.Change;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
@Configuration
public interface ChangeRepository extends CrudRepository<Change , Long> {
}
