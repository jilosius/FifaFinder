package com.fifafinder.fifadb.DTOs;

import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@ToString
@Setter
@Getter
public class AddPlaysForDTO {

    private String knownName;
    private String fullName;
    private Integer age;
    private Integer weight;
    private Integer height;
    private String photoUrl;
    private Date dateOfBirth;
    private Integer fifaVersion;
    private String clubPosition;
    private Integer clubNumber;
    private String clubName;
    private String nationalPosition;
    private Integer nationalNumber;
    private String nationalTeam;
    private Integer contractUntil;
    private String onLoan;
    private Long valueEUR;
    private Long wage;
    private Long releaseClause;
    private Integer overall;
    private Integer potential;
    private String bestPosition;
    private Integer intReputation;
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
    private Integer fKAccuracy;
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
    private Integer gKDiving;
    private Integer gKHandling;
    private Integer gKKicking;
    private Integer gKPositioning;
    private Integer gKReflexes;

}
