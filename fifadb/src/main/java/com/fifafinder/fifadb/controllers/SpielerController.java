package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.HttpResponse;
import com.fifafinder.fifadb.services.SpielerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

import static java.time.LocalTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

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



    @GetMapping("/start")
    public ResponseEntity<HttpResponse> getSpieler(@RequestParam Optional<String> name,
                                                   @RequestParam Optional<Integer> page,
                                                   @RequestParam Optional<Integer> size
    ) {
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("page", spielerService.getSpieler(name.orElse(""), page.orElse(0), size.orElse(15))))
                        .message("Spieler abgerufen")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
}
