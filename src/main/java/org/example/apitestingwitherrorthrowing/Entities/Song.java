package org.example.apitestingwitherrorthrowing.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(unique=true)
public String Name ;
    @Column(unique=false,nullable=false)
public String Artist ;
    @Column(unique=false,nullable=false)
public Date ReleaseDate ;
    @Column(unique=false,nullable=false)
public String Genre ;
    @Column(unique=false,nullable=false)
    public String Mood ;

}
