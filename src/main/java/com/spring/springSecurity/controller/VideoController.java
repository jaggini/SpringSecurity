package com.spring.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.springSecurity.model.User;
import com.spring.springSecurity.model.Video;
import com.spring.springSecurity.service.UserService;
import com.spring.springSecurity.service.VideoService;

@Controller
public class VideoController {
    @Autowired
    VideoService videoService;
    @Autowired
    UserService userService;

    @PostMapping("/createForTheVideo")
    public ResponseEntity<String> createVideo(@PathVariable Long id, User u) {
        Video v = videoService.getVideoById(id).orElseThrow(() -> new RuntimeException("error"));
        videoService.craetVideo(v);
        u.getRVideos().add(v);
        userService.saveuser(u);
        return ResponseEntity.ok("video created successfuly");

    }

    @GetMapping("/returnTheVideo")
    public ResponseEntity<String> getVideos(@PathVariable Long id, User u) {
        Video v = videoService.getVideoById(id).orElseThrow(() -> new RuntimeException("error"));
        videoService.craetVideo(v);
        u.getRVideos().remove(v);
       userService.saveuser(u);
        return ResponseEntity.ok("get all videos successfuly");

    }

}
