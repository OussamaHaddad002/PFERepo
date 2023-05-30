package com.satoripop.com.service;

import com.satoripop.com.model.Authority;
import com.satoripop.com.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> getAuthoritys() {
        List<Authority> authoritys = new ArrayList<>();
        authorityRepository.findAll().forEach(
                authority -> {
                    authoritys.add(authority);
                }

        );
        return authoritys;
    }

    public void addAuthority(Authority authority){
        authorityRepository.save(authority);
    }
    public void update(Authority authority, long id){
        authorityRepository.save(authority);
    }

    public Authority getAuthorityById(long id){
        return authorityRepository.findById(id).orElse(null);
    }

    public void deleteAuthority(long id) {
        authorityRepository.deleteById(id);
    }

}
