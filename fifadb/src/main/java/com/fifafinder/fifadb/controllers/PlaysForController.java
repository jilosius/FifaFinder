package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.DTOs.AddPlaysForDTO;
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

import java.time.ZoneId;
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
    /*
    @PostMapping("/add")
    public void addPlayer(@RequestParam String knownName,
                          @RequestParam String fullName,
                          @RequestParam LocalDate birthDate,
                          @RequestParam FifaVersion fifaversion,
                          @RequestParam Integer height,
                          @RequestParam String clubPosition,
                          @RequestParam Integer clubNumber,
                          @RequestParam String nationalPosition,
                          @RequestParam Integer nationalNumber,
                          @RequestParam String preferredFoot,
                          @RequestParam Integer contractUntil,
                          @RequestParam String onLoan,
                          @RequestParam String nationalTeam,
                          @RequestParam Integer age,
                          @RequestParam Integer weight,
                          @RequestParam Integer overall,
                          @RequestParam Integer potential,
                          @RequestParam String bestPosition,
                          @RequestParam Mannschaften clubID,
                          @RequestParam Long valueEUR,
                          @RequestParam Long wage,
                          @RequestParam Long releaseClause,
                          @RequestParam Integer intReputation,
                          @RequestParam Integer weakFoot,
                          @RequestParam Integer skillMoves,
                          @RequestParam Integer crossing,
                          @RequestParam Integer finishing,
                          @RequestParam Integer headingAccuracy,
                          @RequestParam Integer shortPassing,
                          @RequestParam Integer volleys,
                          @RequestParam Integer dribbling,
                          @RequestParam Integer curve,
                          @RequestParam Integer fKAccuracy,
                          @RequestParam Integer longPassing,
                          @RequestParam Integer ballControl,
                          @RequestParam Integer acceleration,
                          @RequestParam Integer sprintSpeed,
                          @RequestParam Integer agility,
                          @RequestParam Integer reaction,
                          @RequestParam Integer balance,
                          @RequestParam Integer shotPower,
                          @RequestParam Integer jumping,
                          @RequestParam Integer stamina,
                          @RequestParam Integer strength,
                          @RequestParam Integer longShots,
                          @RequestParam Integer aggression,
                          @RequestParam Integer interceptions,
                          @RequestParam Integer positioning,
                          @RequestParam Integer vision,
                          @RequestParam Integer penalties,
                          @RequestParam Integer composure,
                          @RequestParam Integer marking,
                          @RequestParam Integer standingTackle,
                          @RequestParam Integer slidingTackle,
                          @RequestParam Integer gKDiving,
                          @RequestParam Integer gKHandling,
                          @RequestParam Integer gKKicking,
                          @RequestParam Integer gKPositioning,
                          @RequestParam Integer gKReflexes,
                          @RequestParam String photoUrl
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
 */
    @PostMapping("/add")
    public void addPlayer(@RequestBody AddPlaysForDTO playsForDTO )
    {
       // playsForService.addPlaysFor(playsFor);
        System.out.println(playsForDTO);
        Spieler spieler = new Spieler();
        spieler.setKnownName(playsForDTO.getKnownName());
        spieler.setFullName(playsForDTO.getFullName());
        spieler.setBirthDate(playsForDTO.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        spielerService.addPlayer(spieler);
       // playsForService.addPlayer(spieler, )

    }
}
