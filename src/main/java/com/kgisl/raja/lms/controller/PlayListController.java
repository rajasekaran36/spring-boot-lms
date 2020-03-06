package com.kgisl.raja.lms.controller;

import java.util.List;

import com.kgisl.raja.lms.model.PlayList;
import com.kgisl.raja.lms.repository.PlayListRepository;

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
public class PlayListController {
    @Autowired
    private PlayListRepository playListRepository;

    @GetMapping("/api/playlist/getall")
    public @ResponseBody ResponseEntity<List<PlayList>> getAllPlayList() {
        return new ResponseEntity<List<PlayList>>(playListRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/playlist/get/{id}")
    public @ResponseBody ResponseEntity<PlayList> getPlayListById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<PlayList>(playListRepository.findById(id).get(),HttpStatus.OK);
    }
    @PostMapping(value = "/api/playlist/add", headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<PlayList> addPlayList(@RequestBody PlayList playList) {
        return new ResponseEntity<PlayList>(playListRepository.save(playList), HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/playlist/put", headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<PlayList> updatePlayList(@RequestBody PlayList playList){
        PlayList x = playListRepository.findById(playList.getId()).get();
        return new ResponseEntity<PlayList>(playListRepository.save(playList),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/api/playlist/delete/{id}")
    public void deletePlayList(@PathVariable(value = "id") Long id){
        playListRepository.deleteById(id);

    }
    @DeleteMapping(value = "/api/playlist/deleteall")
    public void deleteAllPlayList(){
        playListRepository.deleteAll();
    }
}