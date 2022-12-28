package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.services.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class SpielerController {

        private final SpielerService spielerService;

        @Autowired
        public SpielerController(SpielerService spielerService)
        {
            this.spielerService = spielerService;
        }

    @GetMapping("/count")
    public long countSpieler()
    {
        return spielerService.countSpieler();

    }

    @PostMapping("/add")
    public void addSpieler(@RequestBody Spieler spieler)
    {
        spielerService.addPlayer(spieler);
    }

    @GetMapping("/findTest")
    public Optional<Spieler> findSpieler()
    {
        return spielerService.findSpieler();
    }

    @DeleteMapping("/delete")
    public void deletePlayer()
    {
        spielerService.deleteSpieler();
    }
}
