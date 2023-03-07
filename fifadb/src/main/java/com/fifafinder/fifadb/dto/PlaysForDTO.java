package com.fifafinder.fifadb.dto;


import com.fifafinder.fifadb.entities.Spieler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PlaysForDTO {

        private Integer PlayerID;

        private Integer fifaVersion;

        private Integer height;

        private String clubPosition;

        private Integer clubNumber;

        private String nationalPosition;

        private Integer nationalNumber;

        private String preferredFoot;

        private Integer contractUntil;

        private String onLoan;

        private String nationalTeam;

        private Integer age;

        private Integer weight;

        private Integer overall;

        private Integer potential;

        private String bestPosition;


        private Integer clubID;

        private Long valueEUR;

        private Long wage;

        private Long releaseClause;

        private Integer intReputation;

        private Integer weakFoot;

        private Integer skillMoves;

        private Integer crossing;

        private Integer finishing;

        private Integer headingAccuracy;

        private Integer shortPassing;

        private Integer volleys;

        private Integer dribbling;

        private Integer curve;

        private Integer fkAccuracy;

        private Integer longPassing;

        private Integer ballControl;

        private Integer acceleration;

        private Integer sprintSpeed;

        private Integer agility;

        private Integer reaction;

        private Integer balance;

        private Integer shotPower;

        private Integer jumping;

        private Integer stamina;

        private Integer strength;

        private Integer longShots;

        private Integer aggression;

        private Integer interceptions;

        private Integer positioning;

        private Integer vision;

        private Integer penalties;

        private Integer composure;

        private Integer marking;

        private Integer standingTackle;

        private Integer slidingTackle;

        private Integer gKDiving;
        private Integer gKHandling;

        private Integer gKKicking;

        private Integer gKReflexes;

        private Integer gKPositioning;

        private String photoUrl;
}
