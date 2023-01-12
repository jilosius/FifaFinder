package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.services.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class SpielerController {

    private final SpielerService spielerService;

    @Autowired
    public SpielerController(SpielerService spielerService) {
        this.spielerService = spielerService;
    }

    @GetMapping("/count")
    public long countSpieler() {
        return spielerService.countSpieler();
    }

    @GetMapping("/all")
    public List<Spieler> getAll() {
        return spielerService.getAllSpieler();
    }
}
