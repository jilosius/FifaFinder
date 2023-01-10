package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.services.PlaysForService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/playsFor")
public class PlaysForController {

    private final PlaysForService playsForService;
    @Autowired
    public PlaysForController(PlaysForService playsForService){
        this.playsForService = playsForService;
    }

    @PostMapping("/add")
    public void addPlayer(@RequestBody Spieler spieler,
                          @RequestBody FifaVersion fifaversion,
                          @RequestBody Integer height,
                          @RequestBody String clubPosition,
                          @RequestBody Integer clubNumber,
                          @RequestBody String nationalPosition,
                          @RequestBody Integer nationalNumber,
                          @RequestBody String preferredFoot,
                          @RequestBody Integer contractUntil,
                          @RequestBody String onLoan,
                          @RequestBody String nationalTeam,
                          @RequestBody Integer age,
                          @RequestBody Integer weight,
                          @RequestBody Integer overall,
                          @RequestBody Integer potential,
                          @RequestBody String bestPosition,
                          @RequestBody Mannschaften clubID,
                          @RequestBody Long valueEUR,
                          @RequestBody Long wage,
                          @RequestBody Long releaseClause,
                          @RequestBody Integer intReputation,
                          @RequestBody Integer weakFoot,
                          @RequestBody Integer skillMoves,
                          @RequestBody Integer cossing,
                          @RequestBody Integer finishing,
                          @RequestBody Integer headingAccuracy,
                          @RequestBody Integer shortPassing,
                          @RequestBody Integer volleys,
                          @RequestBody Integer dribbling,
                          @RequestBody Integer curve,
                          @RequestBody Integer fKAccuracy,
                          @RequestBody Integer longPassing,
                          @RequestBody Integer ballControl,
                          @RequestBody Integer acceleration,
                          @RequestBody Integer sprintSpeed,
                          @RequestBody Integer agility,
                          @RequestBody Integer reaction,
                          @RequestBody Integer balance,
                          @RequestBody Integer shotPower,
                          @RequestBody Integer jumping,
                          @RequestBody Integer stamina,
                          @RequestBody Integer strength,
                          @RequestBody Integer longShots,
                          @RequestBody Integer aggression,
                          @RequestBody Integer interceptions,
                          @RequestBody Integer positioning,
                          @RequestBody Integer vision,
                          @RequestBody Integer penalties,
                          @RequestBody Integer composure,
                          @RequestBody Integer marking,
                          @RequestBody Integer standingTackle,
                          @RequestBody Integer slidingTackle,
                          @RequestBody Integer gKDiving,
                          @RequestBody Integer gKHandling,
                          @RequestBody Integer gKKicking,
                          @RequestBody Integer gKPositioning,
                          @RequestBody Integer gKReflexes,
                          @RequestBody String photoUrl
                          ){
        playsForService.addPlayer(spieler, fifaversion, height,clubPosition, clubNumber,nationalPosition, nationalNumber,
                preferredFoot, contractUntil, onLoan, nationalTeam, age, weight, overall, potential, bestPosition, clubID, valueEUR, wage, releaseClause,
                intReputation, weakFoot, skillMoves, cossing, finishing, headingAccuracy, shortPassing, volleys, dribbling, curve, fKAccuracy, longPassing,
                ballControl, acceleration, sprintSpeed, agility, reaction, balance, shotPower, jumping, stamina, strength, longShots, aggression, interceptions,
                positioning, vision, penalties, composure, marking, standingTackle, slidingTackle, gKDiving, gKHandling, gKKicking, gKPositioning, gKReflexes, photoUrl);
    }

}
