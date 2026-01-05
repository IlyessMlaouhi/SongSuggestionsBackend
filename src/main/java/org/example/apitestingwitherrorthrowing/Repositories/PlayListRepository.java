package org.example.apitestingwitherrorthrowing.Repositories;

import org.example.apitestingwitherrorthrowing.Entities.Playlist;
import org.example.apitestingwitherrorthrowing.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayListRepository extends JpaRepository<Playlist, Long> {
    public List<Playlist> findByUserName(String username);

}
