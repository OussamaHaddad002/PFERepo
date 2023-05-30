package com.satoripop.com.repository;

import com.satoripop.com.model.UserInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
@Configuration
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
}
