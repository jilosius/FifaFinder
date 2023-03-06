package com.fifafinder.fifadb.dto;

import com.fifafinder.fifadb.entities.Liga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompetesInDTO {
    private Integer fifaVersion;
    private Integer clubID;
    private String clubName;
    private String clubLogo;
    private String countryName;
    private String flag;
    private String logo;
    private Liga leagueID;
    private Integer overall;
    private Integer attack;
    private Integer midfield;
    private Integer defence;
}
