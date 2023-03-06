package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.DTOs.AddPlaysForDTO;
import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.repositories.MannschaftenRepository;
import com.fifafinder.fifadb.services.PlaysForService;
import com.fifafinder.fifadb.services.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fifafinder.fifadb.dto.UpdateDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playsfor")
public class PlaysForController {

    private final PlaysForService playsForService;
    private final SpielerService spielerService;
    private final FifaVersionRepository fifaVersionRepository;
    private final FifaController fifaController;
    private final MannschaftenController mannschaftenController;
    private final MannschaftenRepository mannschaftenRepository;
    @Autowired
    public PlaysForController(PlaysForService playsForService, SpielerService spielerService,
                              FifaVersionRepository fifaVersionRepository, FifaController fifaController,
                              MannschaftenRepository mannschaftenRepository,
                              MannschaftenController mannschaftenController) {
        this.playsForService = playsForService;
        this.spielerService = spielerService;
        this.fifaVersionRepository = fifaVersionRepository;
        this.fifaController = fifaController;
        this.mannschaftenController = mannschaftenController;
        this.mannschaftenRepository = mannschaftenRepository;
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



    @PutMapping("/editdetailsof{playerId}in{fifaVersion}")
    public void editDetails(@PathVariable("playerId") int playerId, @PathVariable("fifaVersion") int fifaVersion, @RequestBody UpdateDTO updateDTO) {
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(playerId);
        playsForId.setFifaVersion(fifaVersion);
        playsForService.editDetails(playsForId, updateDTO);
    }

    @GetMapping("/detailsforedit/playerid={playerId}/fifaversion={fifaVersion}")
    public UpdateDTO getDetailsForEdit(@PathVariable("playerId") int playerId, @PathVariable("fifaVersion") int fifaVersion) {
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(playerId);
        playsForId.setFifaVersion(fifaVersion);
        return playsForService.getDetailsForEdit(playsForId);
    }


    @PostMapping("/add")
    public void addPlayer(@RequestBody AddPlaysForDTO playsForDTO )
    {

        System.out.println(playsForDTO);
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
                playsForDTO.getOverall(),playsForDTO.getPotential(),playsForDTO.getBestPosition(), playsForDTO.getClubName(), playsForDTO.getValueEUR(), playsForDTO.getWage(),
                playsForDTO.getReleaseClause(),playsForDTO.getIntReputation(),playsForDTO.getWeakFoot(),playsForDTO.getSkillMoves(),playsForDTO.getCrossing(),playsForDTO.getFinishing(),
                playsForDTO.getHeadingAccuracy(),playsForDTO.getShortPassing(),playsForDTO.getVolleys(),playsForDTO.getDribbling(),playsForDTO.getCurve(),playsForDTO.getFKAccuracy(),
                playsForDTO.getLongPassing(), playsForDTO.getBallControl(),playsForDTO.getAcceleration(),playsForDTO.getBallControl(),playsForDTO.getAgility(),playsForDTO.getReaction(),
                playsForDTO.getBalance(),playsForDTO.getShotPower(),playsForDTO.getJumping(), playsForDTO.getStamina(),playsForDTO.getStrength(),playsForDTO.getLongShots(),
                playsForDTO.getAggression(),playsForDTO.getAggression(),playsForDTO.getPositioning(),playsForDTO.getVision(),playsForDTO.getPenalties(),playsForDTO.getComposure(),
                playsForDTO.getMarking(),playsForDTO.getStandingTackle(),playsForDTO.getSlidingTackle(),playsForDTO.getGKDiving(),playsForDTO.getGKHandling(),playsForDTO.getGKKicking(),
                playsForDTO.getGKPositioning(),playsForDTO.getGKReflexes(),playsForDTO.getPhotoUrl());

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

    @GetMapping("/player/{playerID}")
    public Optional<PlaysFor[]> getPlaysForByPlayerIDId(@PathVariable("playerID") Integer id ) {
        return playsForService.findPlaysForByPlayerIDId(id);
    }


}
