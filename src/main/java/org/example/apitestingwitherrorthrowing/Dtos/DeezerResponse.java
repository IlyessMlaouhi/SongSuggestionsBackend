package org.example.apitestingwitherrorthrowing.Dtos;

import lombok.Data;
import lombok.Getter;
import org.example.apitestingwitherrorthrowing.Entities.DeezerTrack;

import java.util.List;

@Data
@Getter
public class DeezerResponse {
    private List<DeezerTrack> data ;

}
