package com.fifafinder.fifadb.controllers;

//import com.fifafinder.fifadb.services.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class SpielerController {
/*
    private final SpielerService spielerService;

    @Autowired
    public SpielerController(SpielerService spielerService)
    {
        this.spielerService = SpielerService;
    }
*/
    @GetMapping
    public long getAmount_of_spieler()
    {
        //return spielerService.countSpieler();
        return 0;
    }
}
