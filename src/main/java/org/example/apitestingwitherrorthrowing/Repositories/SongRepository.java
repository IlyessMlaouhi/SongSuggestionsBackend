package org.example.apitestingwitherrorthrowing.Repositories;

import org.example.apitestingwitherrorthrowing.Entities.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {


    List<Song> findAllByMood(String mood);

    void deleteSongByName(String name);

    Page<Song> findAll(Pageable pageable);

    Page<Song> findByGenre(String genre, Pageable pageable);

    Page<Song> findByMood(String mood, Pageable pageable);

    Page<Song> findSongByGenreAndMood(String genre, String mood, Pageable pageable);
}

