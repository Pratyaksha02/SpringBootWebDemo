package com.boot.rest.SpringBootWebDemo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface IMusicRepository extends MongoRepository<Music,String> {

    List<Music> findByArtist(String artist);
}

//https://gitHub.com/essjcee/music-items.git