package org.example.apitestingwitherrorthrowing.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long  id;

@Column(nullable = false)
private String username;

@Column(nullable = false)
private String email;

@Column(nullable = false)
private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Playlist> playlists = new ArrayList<>();


}
