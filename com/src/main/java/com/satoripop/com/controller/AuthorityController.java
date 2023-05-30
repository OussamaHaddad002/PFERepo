package com.satoripop.com.controller;

import com.satoripop.com.model.Authority;
import com.satoripop.com.model.enumeration.Status;

import com.satoripop.com.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @RequestMapping(method = RequestMethod.GET, value = "/authoritys")
    public List<Authority> getAuthoritys(){
        return authorityService.getAuthoritys();
    }

    @RequestMapping("/authority")
    public Authority getAuthority(){
        Authority authority = new Authority("Admin");
        return authority;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/authority/{id}")
    public Authority getAuthorityById(@PathVariable long id){
        return authorityService.getAuthorityById(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/authority/{id}")
    public void deleteAuthority(@PathVariable long id){
        authorityService.deleteAuthority(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/authoritys")
    public void addAuthority(@RequestBody Authority authority){
        authorityService.addAuthority(authority);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/authority/{id}")
    public void updateAuthority(@RequestBody Authority authority,@PathVariable long id){
        authorityService.update(authority,id);
    }

}
