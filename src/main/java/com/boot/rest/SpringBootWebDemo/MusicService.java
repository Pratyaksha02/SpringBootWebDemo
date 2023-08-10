package com.boot.rest.SpringBootWebDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    @Autowired
    private IMusicRepository musicRepository;

    public Music addArtist(Music music ) throws RecordExistException {
        if(musicRepository.existsById(music.getId()))
            throw new RecordExistException("Artist with "+ music.getId()+" already exists");
        Music savedEntity = this.musicRepository.save(music);
        return savedEntity;
    }
    public long getCount(){
        return this.musicRepository.count();
    }
    public List<Music>getAllMusic(){

        return this.musicRepository.findAll();
    }
    public void updateMusic(Music dataToUpdate) {
        if (musicRepository.existsById(dataToUpdate.getId()))
        {
            musicRepository.save((dataToUpdate));
        }
        else
            System.out.println("not found");
    }
    public void deleteMusic(long id){
        Music music =musicRepository.findById(String.valueOf(id)).orElse(null);
        if(music!=null){
            musicRepository.save(music);
        }
        else
            System.out.println("not found");
    }

    public List<Music> getMusicByArtist(String artist) {
        return this.musicRepository.findByArtist(artist);
    }
}
