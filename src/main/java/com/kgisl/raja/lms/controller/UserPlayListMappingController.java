package com.kgisl.raja.lms.controller;

import java.util.List;

import com.kgisl.raja.lms.model.UserPlayListMapping;
import com.kgisl.raja.lms.repository.UserPlayListMappingRepository;

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
@RestController
public class UserPlayListMappingController{
    @Autowired
    private UserPlayListMappingRepository userPlayListMappingRepository;

    @GetMapping("/api/userplaylistmapping/getall")
    public @ResponseBody ResponseEntity<List<UserPlayListMapping>> getAllUserPlayListMapping() {
        return new ResponseEntity<List<UserPlayListMapping>>(userPlayListMappingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/userplaylistmapping/get/{id}")
    public @ResponseBody ResponseEntity<UserPlayListMapping> getUserPlayListMappingById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<UserPlayListMapping>(userPlayListMappingRepository.findById(id).get(),HttpStatus.OK);
    }
    @PostMapping(value = "/api/userplaylistmapping/add", headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<UserPlayListMapping> addUserPlayListMapping(@RequestBody UserPlayListMapping userPlayListMapping) {
        return new ResponseEntity<UserPlayListMapping>(userPlayListMappingRepository.save(userPlayListMapping), HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/userplaylistmapping/put", headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<UserPlayListMapping> updateUserPlayListMapping(@RequestBody UserPlayListMapping userPlayListMapping){
        UserPlayListMapping x = userPlayListMappingRepository.findById(userPlayListMapping.getId()).get();
        return new ResponseEntity<UserPlayListMapping>(userPlayListMappingRepository.save(x),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/api/userplaylistmapping/delete/{id}")
    public void deleteUserPlayListMapping(@PathVariable(value = "id") Long id){
        userPlayListMappingRepository.deleteById(id);

    }
    @DeleteMapping(value = "/api/userplaylistmapping/deleteall")
    public void deleteAllUserPlayListMapping(){
        userPlayListMappingRepository.deleteAll();
    }
}