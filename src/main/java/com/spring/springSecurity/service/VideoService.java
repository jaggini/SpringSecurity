package com.spring.springSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springSecurity.model.Video;
import com.spring.springSecurity.repository.VideoRepository;

@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;

    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }

    public List<Video> getAllVideos(Long id) {

        return videoRepository.findAll();

    }

    public Video craetVideo(Video v) {
        return videoRepository.save(v);
    }

    public void deleteVideoById(Long id) {
        videoRepository.deleteById(id);
    }
}
