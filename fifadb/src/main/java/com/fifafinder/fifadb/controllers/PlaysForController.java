package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.services.PlaysForService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playsFor")
public class PlaysForController {

    private final PlaysForService playsForService;
    @Autowired
    public PlaysForController(PlaysForService playsForService){
        this.playsForService = playsForService;
    }

    @PostMapping("/add")
    public void addPlayer(@RequestBody Spieler spieler, @RequestBody FifaVersion fifaversion){
        playsForService.addPlayer(spieler, fifaversion);
    }

}
