package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.services.PlaysForService;
import com.fifafinder.fifadb.services.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import com.fifafinder.fifadb.services.PlaysForService;
import com.fifafinder.fifadb.services.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/playsFor")
public class PlaysForController {

    private final PlaysForService playsForService;
    private final SpielerService spielerService;
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

    @PostMapping("/add")
    public void addPlayer(@RequestBody String knownName,
                          @RequestBody String fullName,
                          @RequestBody LocalDate birthDate,
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
                          @RequestBody Integer crossing,
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

        Spieler spieler = new Spieler();
        spieler.setKnownName(knownName);
        spieler.setFullName(fullName);
        spieler.setBirthDate(birthDate);
        spielerService.addPlayer(spieler);

        playsForService.addPlayer(spieler, fifaversion, height,clubPosition, clubNumber,nationalPosition, nationalNumber,
                preferredFoot, contractUntil, onLoan, nationalTeam, age, weight, overall, potential, bestPosition, clubID, valueEUR, wage, releaseClause,
                intReputation, weakFoot, skillMoves, crossing, finishing, headingAccuracy, shortPassing, volleys, dribbling, curve, fKAccuracy, longPassing,
                ballControl, acceleration, sprintSpeed, agility, reaction, balance, shotPower, jumping, stamina, strength, longShots, aggression, interceptions,
                positioning, vision, penalties, composure, marking, standingTackle, slidingTackle, gKDiving, gKHandling, gKKicking, gKPositioning, gKReflexes, photoUrl);
    }

}
