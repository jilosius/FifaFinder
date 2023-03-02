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
    private final FifaController fifaController;
    private final MannschaftenController mannschaftenController;
    @Autowired
    public PlaysForController(PlaysForService playsForService, SpielerService spielerService,
                              FifaVersionRepository fifaVersionRepository, FifaController fifaController,
                              MannschaftenController mannschaftenController) {
        this.playsForService = playsForService;
        this.spielerService = spielerService;
        this.fifaVersionRepository = fifaVersionRepository;
        this.fifaController = fifaController;
        this.mannschaftenController = mannschaftenController;
    }

    @GetMapping("/count")
    public long count() {
        return playsForService.count();
    }

    @GetMapping("/countUniquePlayerRecords")
    public long countUniquePlayerRecords(@RequestParam int playerID){
        return playsForService.countUniquePlayerRecords(playerID);
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
    public void addPlayer(@RequestBody AddPlaysForDTO playsForDTO )
    {


        Spieler spieler = new Spieler();
        spieler.setKnownName(playsForDTO.getKnownName());
        spieler.setFullName(playsForDTO.getFullName());
        spieler.setBirthDate(playsForDTO.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        spielerService.addPlayer(spieler);

        FifaVersion fifaVersion;
        fifaVersion =  fifaController.getVersionByID(playsForDTO.getFifaVersion());


        PlaysForId playsForId = new PlaysForId();
        playsForId.setFifaVersion(playsForDTO.getFifaVersion());
        playsForId.setPlayerID(spieler.getId());

        playsForService.addPlayer(spieler, fifaVersion,playsForId, playsForDTO.getHeight(), playsForDTO.getClubPosition(), playsForDTO.getClubNumber(), playsForDTO.getNationalPosition(), playsForDTO.getNationalNumber(),
                playsForDTO.getPreferredFoot(), playsForDTO.getContractUntil(), playsForDTO.getOnLoan(), playsForDTO.getNationalTeam(), playsForDTO.getAge(), playsForDTO.getWeight(),
                playsForDTO.getOverall(),playsForDTO.getPotential(),playsForDTO.getBestPosition(), mannschaftenController.findMannschaftenByID(playsForDTO.getClubID()), playsForDTO.getValueEur(), playsForDTO.getWage(),
                playsForDTO.getReleaseClause(),playsForDTO.getReputation(),playsForDTO.getWeakFoot(),playsForDTO.getSkillMoves(),playsForDTO.getCrossing(),playsForDTO.getFinishing(),
                playsForDTO.getHeadingAccuracy(),playsForDTO.getShortPassing(),playsForDTO.getVolleys(),playsForDTO.getDribbling(),playsForDTO.getCurve(),playsForDTO.getFKAccuracy(),
                playsForDTO.getLongPassing(), playsForDTO.getBallControl(),playsForDTO.getAcceleration(),playsForDTO.getBallControl(),playsForDTO.getAgility(),playsForDTO.getReaction(),
                playsForDTO.getBalance(),playsForDTO.getShotPower(),playsForDTO.getJumping(), playsForDTO.getStamina(),playsForDTO.getStrength(),playsForDTO.getLongShots(),
                playsForDTO.getAggression(),playsForDTO.getAggression(),playsForDTO.getPositioning(),playsForDTO.getVision(),playsForDTO.getPenalties(),playsForDTO.getComposure(),
                playsForDTO.getMarking(),playsForDTO.getStandingTackle(),playsForDTO.getSlidingTackle(),playsForDTO.getGKDiving(),playsForDTO.getGKHandling(),playsForDTO.getGKKicking(),
                playsForDTO.getGKPositioning(),playsForDTO.getGKReflexes(),playsForDTO.getPhotoURL());

    }

    @DeleteMapping("/delete{playerID}")
    public void deleteAllbyId(@PathVariable("playerID") int playerID){
        playsForService.deleteAllByPlayerID(playerID);
    }

    @DeleteMapping("/deleteInFifaVersion")
    public void deleteAllByPlayerIDAndFifaVersion(@RequestParam int playerID, @RequestParam int fifaVersion){
        playsForService.deleteAllByPlayerIDAndFifaVersion(playerID, fifaVersion);
    }

    @GetMapping("/listVersions")
    public List<FifaVersion> listFifaVersions(){
        return playsForService.listFifaVersions();
    }

}
