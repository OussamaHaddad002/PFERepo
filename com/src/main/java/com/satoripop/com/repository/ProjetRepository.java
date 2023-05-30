package com.satoripop.com.repository;

import com.satoripop.com.model.Projet;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
public interface ProjetRepository extends CrudRepository<Projet, Long> {
}
