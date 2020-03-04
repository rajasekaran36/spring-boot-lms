package com.kgisl.raja.lms.controller;

import java.util.List;

import com.kgisl.raja.lms.model.User;
import com.kgisl.raja.lms.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController("/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/alluser")
    public @ResponseBody ResponseEntity<List<User>> all() {
        return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<User>(userRepository.findById(id).get(),HttpStatus.OK);
    }
    @PostMapping(value = "/adduser", headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<User> addUser(@RequestBody User aUser) {
        return new ResponseEntity<User>(userRepository.save(aUser), HttpStatus.CREATED);
    }

    @PutMapping(value = "/put", headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<User> updateUser(@RequestBody User aUser){
        User x = userRepository.findById(aUser.getId()).get();
        x.setName("xxxxx");
        return new ResponseEntity<User>(userRepository.save(aUser),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id){
        userRepository.deleteById(id);

    }
    @DeleteMapping(value = "/deleteall")
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}