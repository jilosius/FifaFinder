package com.fifafinder.fifadb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MannschaftenDto {


    private Integer id;
    private String clubName;
    private String ClubLogo  ;
    private String league;
    private String logo;
    private String countryName;
    private String flag;
    private int overall;
    private int attack;
    private int midfield;
    private int defence;



    // Constructors, getters and setters
}