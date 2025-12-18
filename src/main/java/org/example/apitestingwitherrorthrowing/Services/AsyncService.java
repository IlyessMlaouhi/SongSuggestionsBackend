package org.example.apitestingwitherrorthrowing.Services;

import lombok.extern.slf4j.Slf4j;
import org.example.apitestingwitherrorthrowing.Entities.Song;
import org.example.apitestingwitherrorthrowing.Repositories.SongRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Slf4j
@Service
public class AsyncService {

    SongRepository songRepository;

    @Async
    public CompletableFuture<Song> save(Song song) {
        songRepository.save(song);
        log.info("Saved " + song);
        return CompletableFuture.completedFuture(song);
    }
}
