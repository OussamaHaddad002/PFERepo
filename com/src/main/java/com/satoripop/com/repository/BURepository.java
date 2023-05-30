package com.satoripop.com.repository;

import com.satoripop.com.model.BU;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
@Configuration
public interface BURepository extends CrudRepository<BU , Long> {
}
