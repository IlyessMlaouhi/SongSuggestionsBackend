package org.example.apitestingwitherrorthrowing.Dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayListDto {
        private Long id;
        private String name;
        private Long userId;
        private String userName;
        private List<SongDto> songs = new ArrayList<>();
    }


