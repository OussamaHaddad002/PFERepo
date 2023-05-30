package com.satoripop.com.repository;

import com.satoripop.com.model.Authority;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
@Configuration
public interface AuthorityRepository extends CrudRepository< Authority ,Long> {
}
