package org.example.apitestingwitherrorthrowing.Services;

import org.example.apitestingwitherrorthrowing.Entities.Playlist;
import org.example.apitestingwitherrorthrowing.Exceptions.BusinessException;
import org.example.apitestingwitherrorthrowing.Repositories.PlayListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListService {

    PlayListRepository playListrepository;

    public PlayListService(PlayListRepository playListRepository) {
        this.playListrepository = playListRepository;
    }

    public List<Playlist> getAllPlayLists() {
        List<Playlist> allplaylists = playListrepository.findAll();
        if(allplaylists.isEmpty()) {
           throw new BusinessException("there aren't any playlists");
        }
        return allplaylists;
    }

    public List<Playlist> getPlayListsbyUser(String User) {
        List<Playlist> playlists = playListrepository.findByUser(User);
        if(playlists.isEmpty()) {
            throw new BusinessException("there aren't any playlists for the user"+User);
        }
        return playlists;
    }
    public void addplaylist(Playlist playlist) {
        playListrepository.save(playlist);
    }
    public void deleteplaylist(Playlist playlist) {
        playListrepository.delete(playlist);
    }
}
