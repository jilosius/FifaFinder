package com.fifafinder.fifadb.DTOs;

import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.entities.PlaysForId;
import com.fifafinder.fifadb.entities.Spieler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@ToString
public class AddPlaysForDTO {

    private String knownName;
    private String fullName;
    private Integer age;
    private Integer weight;
    private Integer height;
    private String PhotoURL;
    private Date DateOfBirth;
    private Integer fifaVersion;
    private String clubPosition;
    private Integer clubNumber;
    private Integer clubID;
    private String nationalPosition;
    private Integer nationalNumber;
    private String nationalTeam;
    private Integer contractUntil;
    private String onLoan;
    private Long valueEur;
    private Long wage;
    private Long releaseClause;
    private Integer Overall;
    private Integer Potential;
    private String bestPosition;
    private Integer Reputation;
    private String preferredFoot;
    private Integer weakFoot;
    private Integer skillMoves;
    private Integer Crossing;
    private Integer Finishing;
    private Integer HeadingAccuracy;
    private Integer ShortPassing;
    private Integer Volleys;
    private Integer Dribbling;
    private Integer Curve;
    private Integer FKAccuracy;
    private Integer LongPassing;
    private Integer BallControl;
    private Integer Acceleration;
    private Integer Sprintspeed;
    private Integer Agility;
    private Integer Reaction;
    private Integer Balance;
    private Integer ShotPower;
    private Integer Jumping;
    private Integer Stamina;
    private Integer Strength;
    private Integer LongShots;
    private Integer Aggression;
    private Integer Interception;
    private Integer Positioning;
    private Integer Vision;
    private Integer Penalties;
    private Integer Composure;
    private Integer Marking;
    private Integer StandingTackle;
    private Integer SlidingTackle;
    private Integer GKDiving;
    private Integer GKHandling;
    private Integer GKKicking;
    private Integer GKPositioning;
    private Integer GKReflexes;

}
