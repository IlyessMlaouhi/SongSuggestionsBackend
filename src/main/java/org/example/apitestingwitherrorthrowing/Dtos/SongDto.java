package org.example.apitestingwitherrorthrowing.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDto {

    private Long id;
    private String title;
    private String artist;
    private String album;
    private String coverUrl;
    private String previewUrl;

}
