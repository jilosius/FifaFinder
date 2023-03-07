package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.DTOs.AddPlaysForDTO;
import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.Spieler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fifafinder.fifadb.dto.UpdateDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.services.PlaysForService;
import com.fifafinder.fifadb.services.SpielerService;
import org.springframework.http.ResponseEntity;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

//Author: Saif,Levi,Enes,Jannik,Wafi
@RestController
@RequestMapping("/playsfor")
public class PlaysForController {

    private final PlaysForService playsForService;
    private final SpielerService spielerService;
    @Autowired
    public PlaysForController(PlaysForService playsForService, SpielerService spielerService) {
        this.playsForService = playsForService;
        this.spielerService = spielerService;
    }


    @GetMapping("/count")
    public long count() {
        return playsForService.count();
    }

    //Author: Levi
    @GetMapping("/countUniquePlayerRecords")
    public long countUniquePlayerRecords(@RequestParam int playerID){
        return playsForService.countUniquePlayerRecords(playerID);
    }
    @GetMapping("/all")
    public List<PlaysFor> getAll() {
        return playsForService.getAll();
    }

    //Author:Jannik
    @GetMapping("/detailsof{name}in{fifaVersion}")
    public ResponseEntity<SpielerDetailDTO> getDetails(@PathVariable("name") String name, @PathVariable("fifaVersion") int fifaVersion) {
        Spieler spieler = spielerService.getSpieler(name);
        int spielerId = spieler.getId();
        return ResponseEntity.ok().body(playsForService.getDetails(spielerId, fifaVersion));
    }


    //Author:Jannik
    @PutMapping("/editdetailsof{playerId}in{fifaVersion}")
    public void editDetails(@PathVariable("playerId") int playerId, @PathVariable("fifaVersion") int fifaVersion, @RequestBody UpdateDTO updateDTO) {
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(playerId);
        playsForId.setFifaVersion(fifaVersion);
        playsForService.editDetails(playsForId, updateDTO);
    }


    //Author: Jannik
    @GetMapping("/detailsforedit/playerid={playerId}/fifaversion={fifaVersion}")
    public UpdateDTO getDetailsForEdit(@PathVariable("playerId") int playerId, @PathVariable("fifaVersion") int fifaVersion) {
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(playerId);
        playsForId.setFifaVersion(fifaVersion);
        return playsForService.getDetailsForEdit(playsForId);
    }

    //Author: Enes
    @PostMapping("/add")
    public void addPlayer(@RequestBody AddPlaysForDTO playsForDTO )
    {

        System.out.println(playsForDTO);
        playsForService.addPlayer(playsForDTO);

    }

    //Author:Levi
    @DeleteMapping("/delete{playerID}")
    public void deleteAllbyId(@PathVariable("playerID") int playerID){
        playsForService.deleteAllByPlayerID(playerID);
    }


    //Author:Levi
    @DeleteMapping("/deleteInFifaVersion")
    public void deleteAllByPlayerIDAndFifaVersion(@RequestParam int playerID, @RequestParam int fifaVersion){
        playsForService.deleteAllByPlayerIDAndFifaVersion(playerID, fifaVersion);
    }


    //Author:Levi
    @GetMapping("/listVersions")
    public List<FifaVersion> listFifaVersions(){
        return playsForService.listFifaVersions();
    }

    @GetMapping("/player/{playerID}")
    public Optional<PlaysFor[]> getPlaysForByPlayerIDId(@PathVariable("playerID") Integer id ) {
        return playsForService.findPlaysForByPlayerIDId(id);
    }


}
