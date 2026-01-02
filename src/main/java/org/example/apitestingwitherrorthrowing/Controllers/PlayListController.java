package org.example.apitestingwitherrorthrowing.Controllers;


import org.example.apitestingwitherrorthrowing.Entities.Playlist;
import org.example.apitestingwitherrorthrowing.Services.PlayListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("playlist")
public class PlayListController {

    PlayListService playListService;

    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        List<Playlist> AllPlaylists = playListService.getAllPlayLists();
        return ResponseEntity.status(200).body(AllPlaylists);
    }

    @GetMapping("byid")
    public ResponseEntity<List<Playlist>> getPlaylistById(@RequestParam String username) {
        List<Playlist> AllPlaylists = playListService.getPlayListsbyUser(username);
         return ResponseEntity.status(200).body(AllPlaylists);
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        playListService.addplaylist(playlist);
        return ResponseEntity.status(201).body(playlist);
    }

    @DeleteMapping
    public ResponseEntity<Playlist> deletePlaylist(@RequestBody Playlist playlist) {
        playListService.deleteplaylist(playlist);
        return ResponseEntity.status(204).body(playlist);
    }
}
