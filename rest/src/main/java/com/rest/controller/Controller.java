package com.rest.controller;
import com.ctc.wstx.shaded.msv_core.util.Uri;
import com.rest.dao.UserDaoService;
import com.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {

    private  UserDaoService userDaoService;
    @Autowired
    public Controller(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        return userDaoService.getUser(id);
    }


    @GetMapping("/all")
    public List<User> getUser(){
        return userDaoService.getAllUsers();
    }

    @GetMapping("/param")
    public User getUserRequestParameter(@RequestParam int id){
        return userDaoService.getUser(id);
    }

    @GetMapping(path = "/param" ,params = "version=1")
    public User getUserRequestParameterVersion(){
        return userDaoService.getUser(3);
    }

    @GetMapping(path = "/header" ,headers = "header-version=1")
    public User getUserHeaderParameterVersion1(){
        return userDaoService.getUser(1);
    }

    @GetMapping(path = "/header" ,headers = "header-version=2")
    public User getUserHeaderParameterVersion2(){
        return userDaoService.getUser(2);
    }
    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        userDaoService.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
