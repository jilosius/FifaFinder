package com.fifafinder.fifadb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "FifaFinder/v1/player")
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
    public int getAmount_of_spieler()
    {
        return 0;
    }
}
