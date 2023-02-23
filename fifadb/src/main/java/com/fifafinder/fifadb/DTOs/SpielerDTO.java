package com.fifafinder.fifadb.DTOs;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SpielerDTO {
    private Integer playerId;
    private String photoURL;
    private String knownName;
    private Integer age;
    private String flag;
    private String clubLogo;
    private Integer overall;
    private Integer potential;
    private String bestPos;
    private Long valueEUR;
    private Integer height;
    private Integer weight;

    //    -------------------------------
    private String preferredFoot;
    private Integer headingAccuracy;
    private Integer volleys;
    private Integer dribbling;
    private Integer curve;
    private Integer fkAccuracy;
    private Integer acceleration;
    private Integer sprintSpeed;
    private Integer agility;
    private Integer reaction;
    private Integer balance;
    private Integer shotPower;
    private Integer jumping;
    private Integer stamina;
    private Integer aggression;
    private Integer longShots;
    private Integer crossing;
    private Integer finishing;
    private Integer shortPassing;
    private Long wage;


}
