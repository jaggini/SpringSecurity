package com.spring.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.springSecurity.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

}