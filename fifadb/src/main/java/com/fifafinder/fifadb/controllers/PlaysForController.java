package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.dto.UpdateDTO;
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

}
