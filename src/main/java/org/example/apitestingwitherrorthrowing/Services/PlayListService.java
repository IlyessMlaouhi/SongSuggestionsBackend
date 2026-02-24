package org.example.apitestingwitherrorthrowing.Services;

import lombok.extern.slf4j.Slf4j;
import org.example.apitestingwitherrorthrowing.Dtos.PlayListCreateRequest;
import org.example.apitestingwitherrorthrowing.Dtos.PlayListDto;
import org.example.apitestingwitherrorthrowing.Dtos.SongDto;
import org.example.apitestingwitherrorthrowing.Entities.Playlist;
import org.example.apitestingwitherrorthrowing.Entities.Song;
import org.example.apitestingwitherrorthrowing.Entities.User;
import org.example.apitestingwitherrorthrowing.Exceptions.BusinessException;
import org.example.apitestingwitherrorthrowing.Repositories.PlayListRepository;
import org.example.apitestingwitherrorthrowing.Repositories.SongRepository;
import org.example.apitestingwitherrorthrowing.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PlayListService {

    PlayListRepository playListrepository;
    UserRepository userRepository;
    SongRepository songRepository;

    public PlayListService(PlayListRepository playListRepository, UserRepository userRepository, SongRepository songRepository)
    {
        this.playListrepository = playListRepository;
        this.userRepository = userRepository;
        this.songRepository = songRepository;
    }

    public List<PlayListDto> getAllPlayLists() {
        List<Playlist> allplaylists = playListrepository.findAll();
        if(allplaylists.isEmpty()) {
           throw new BusinessException("there aren't any playlists");
        }
        return this.PlayListMapper(allplaylists);
    }
    public List<PlayListDto> PlayListMapper(List<Playlist> playlists) {
        List<PlayListDto> playListDtos = new ArrayList<>();
        for(Playlist playlist : playlists) {
            PlayListDto playListDto = new PlayListDto();
            List<SongDto> listsSongDto = this.MapSongToSongDto(playlist.getSongs());
            playListDto.setId(playlist.getId());
            playListDto.setName(playlist.getName());
            playListDto.setUserId(playlist.getUser().getId());
            playListDto.setUserName(playlist.getUser().getName());

            for(SongDto s : listsSongDto) {
                playListDto.getSongs().add(s);
            }
            playListDtos.add(playListDto);
        }
        return playListDtos;
    }

    public List<SongDto> MapSongToSongDto(List<Song> song) {
        List<SongDto> songDtos = new ArrayList<>();
        for(Song s : song) {
        SongDto songDto = new SongDto();
        songDto.setId(s.getId());
        songDto.setTitle(s.getName());
        songDto.setArtist(s.getArtist());
        songDto.setAlbum(null);
        songDtos.add(songDto);
        }

        return songDtos;
    }

    public List<Playlist> getPlayListsbyUser(String Username) {
        List<Playlist> playlists = playListrepository.findByUserName(Username);
        if(playlists.isEmpty()) {
            throw new BusinessException("there aren't any playlists for the user"+Username);
        }
        return playlists;
    }
    public void addplaylist(PlayListCreateRequest playListCreateRequest) {
        Optional<User> user = userRepository.findById(playListCreateRequest.getUserId());
        if(user.isEmpty()){
            throw new BusinessException("there aren't any playlists related to the user");
        }
        List<Song> listSong = new ArrayList<>();
        List<Long> songIds = playListCreateRequest.getSongIds();
        for(Long id : songIds) {

                Optional<Song> song =songRepository.findById(id);
                if(song.isPresent()) {
                    listSong.add(song.get());
                }
                else{
                log.error("this song with the id "+id+" does not exist");
                }
        }
        Playlist playlist = new Playlist();
        playlist.setUser(user.get());
        playlist.setSongs(listSong);
        playlist.setName(playListCreateRequest.getName());

             playListrepository.save(playlist);
    }


    public void deleteplaylist(Playlist playlist) {
        playListrepository.delete(playlist);
    }
}
