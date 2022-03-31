package com.telstra.codechallenge.searchrepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author NARENDRA
 */

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.searchrepo.dto.Users;
import com.telstra.codechallenge.searchrepo.service.Services;

@RestController
public class Controller {
	
	@Autowired
	Services userService;
    
    @RequestMapping(path = "/highestStarred/{noOfRepositories }", method = RequestMethod.GET)
    public List<Users> oldUserAccounts(@PathVariable("noOfRepositories ") long noOfRepositories ) {
        return userService.getUsersList(noOfRepositories);
    }
}
