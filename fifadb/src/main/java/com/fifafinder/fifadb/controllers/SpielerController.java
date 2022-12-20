package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.services.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.xpath.XPath;
import java.util.List;

@RestController
@RequestMapping("/players")
public class SpielerController {

        private final SpielerService spielerService;

        @Autowired
        public SpielerController(SpielerService spielerService)
        {
            this.spielerService = spielerService;
        }

        @GetMapping
        public long countSpieler() {

            return spielerService.countSpieler();
        }
/*
        @GetMapping
        public List<Spieler> getAllSpieler() {

            return spielerService.getAllSpieler();
        }
        */
}
