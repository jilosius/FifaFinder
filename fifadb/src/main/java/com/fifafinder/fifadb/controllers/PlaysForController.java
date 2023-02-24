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

    @GetMapping("/countUniquePlayerRecords")
    public long countUniquePlayerRecords(@RequestParam int id){
        return playsForService.countUniquePlayerRecords(id);
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
