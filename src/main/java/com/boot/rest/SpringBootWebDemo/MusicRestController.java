package com.boot.rest.SpringBootWebDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/music")
public class MusicRestController {
    @Autowired
    private MusicService musicService;
    @GetMapping
    public List<Music> getAllMusic(){
        return musicService.getAllMusic();
    }
    @GetMapping("/{artist}")
    public List<Music> getMusicByArtist(@RequestParam String artist) {

        return (List<Music>) this.musicService.getMusicByArtist(artist);

    }
    @PostMapping
    public Music addArtist(Music artist){
        try{
            return this.musicService.addArtist(artist);
        }catch (RecordExistException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @PutMapping
    public void updateMusic(Music music) {
       try {
           this.musicService.updateMusic(music);
       } catch (Exception e) {
           //throw new RuntimeException(e);
           System.out.println(e.getMessage());
       }
    }
    @DeleteMapping
    public void deleteMusic(long id) {
        try {
            this.musicService.deleteMusic(id);

        } catch (Exception e) {
            // throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }

    }
    }
