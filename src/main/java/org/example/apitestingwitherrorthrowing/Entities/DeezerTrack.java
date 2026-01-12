package org.example.apitestingwitherrorthrowing.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeezerTrack {
    private Long id;
    private String title;
    private String preview;
    private DeezerArtist artist;
    private DeezerAlbum album;

}
