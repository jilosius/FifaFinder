package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import com.fifafinder.fifadb.services.PlaysForService;
import com.fifafinder.fifadb.services.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playsfor")
public class PlaysForController {

    public final PlaysForService playsForService;
    public final SpielerService spielerService;
    private final FifaVersionRepository fifaVersionRepository;

    @Autowired
    public PlaysForController(PlaysForService playsForService, SpielerService spielerService,
                              FifaVersionRepository fifaVersionRepository) {
        this.playsForService = playsForService;
        this.spielerService = spielerService;
        this.fifaVersionRepository = fifaVersionRepository;
    }

    @GetMapping("/count")
    public long count() {
        return playsForService.count();
    }
    @GetMapping("/all")
    public List<PlaysFor> getAll() {
        return playsForService.getAll();
    }

    @GetMapping("/detailsof{name}in{fifaVersion}")
    public ResponseEntity<SpielerDetailDTO> getDetails(@PathVariable("name") String name, @PathVariable("fifaVersion") int fifaVersion) {
        Spieler spieler = spielerService.getSpieler(name);
        int spielerId = spieler.getId();
        return ResponseEntity.ok().body(playsForService.getDetails(spielerId, fifaVersion));
    }

    @PostMapping("/editdetails")
    public void editDetails(int playerId, int fifaVersion, Integer height, String clubPosition, Integer clubNumber, String nationalPosition, Integer nationalNumber, String preferredFoot,
                            Integer contractUntil, String onLoan, String nationalTeam, Integer age, Integer weight, Integer overall, Integer potential, String bestPosition,
                            Long valueEUR, Long wage, Long releaseClause, Integer intReputation, Integer weakFoot, Integer skillMoves, Integer crossing, Integer finishing,
                            Integer headingAccuracy, Integer shortPassing, Integer volleys, Integer dribbling, Integer curve, Integer fKAccuracy, Integer longPassing,
                            Integer ballControl, Integer acceleration, Integer sprintSpeed, Integer agility, Integer reaction, Integer balance, Integer shotPower, Integer jumping,
                            Integer stamina, Integer strength, Integer longShots, Integer aggression, Integer interceptions, Integer positioning, Integer vision, Integer penalties,
                            Integer composure, Integer marking, Integer standingTackle, Integer slidingTackle, Integer gKDiving, Integer gKHandling, Integer gKKicking, Integer gKPositioning,
                            Integer gKReflexes, String photoUrl) {
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(playerId);
        playsForId.setFifaVersion(fifaVersion);
        playsForService.editDetails(playsForId, height, clubPosition, clubNumber, nationalPosition, nationalNumber, preferredFoot, contractUntil, onLoan, nationalTeam, age, weight,
                overall, potential, bestPosition, valueEUR, wage, releaseClause, intReputation, weakFoot, skillMoves, crossing, finishing, headingAccuracy,
                shortPassing, volleys, dribbling, curve, fKAccuracy, longPassing, ballControl, acceleration, sprintSpeed, agility, reaction, balance, shotPower,
                jumping, stamina, strength, longShots, aggression, interceptions, positioning, vision, penalties, composure, marking, standingTackle, slidingTackle,
                gKDiving, gKHandling, gKKicking,gKPositioning, gKReflexes, photoUrl);
    }

}
