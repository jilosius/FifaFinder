package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.DTOs.SpielerDTO;
import com.fifafinder.fifadb.HttpResponse;
import com.fifafinder.fifadb.services.SpielerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fifafinder.fifadb.entities.Spieler;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

//    @GetMapping
//    public long countSpieler()
//    {
//        return spielerService.countSpieler();
//
//    }


    // First implementation: how to list all players. Not dynamic
//    @GetMapping
//    public Page<SpielerDTO> listAllSpieler(@RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
//                                           @RequestParam(name = "sort", required = false, defaultValue = "pf.overall") String sortAttribute,
//                                           @RequestParam(name = "order", required = false, defaultValue = "desc") String sortDirection) {
//        int pageSize = 20;
//        Sort sort = Sort.by(sortAttribute).descending();
//        if (sortDirection.equalsIgnoreCase("asc")) {
//            sort = sort.ascending();
//        }
//        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
//        return spielerService.listAllSpieler(pageable);
//    }

    //---------------------------------------------------------------------
    //Second implementation: trying to search for players by name.
//    @GetMapping("/start")
//    public ResponseEntity<HttpResponse> getSpieler(@RequestParam Optional<String> fullName,
//                                                   @RequestParam Optional<Integer> page,
//                                                   @RequestParam Optional<Integer> size,
//                                                   @RequestParam(name = "sort", required = false, defaultValue = "pf.overall") String sortAttribute,
//                                                   @RequestParam(name = "order", required = false, defaultValue = "desc") String sortDirection) {
//        Sort sort = Sort.by(sortAttribute).descending();
//        if (sortDirection.equalsIgnoreCase("asc")) {
//            sort = sort.ascending();
//        }
//
//        return ResponseEntity.ok().body(
//                HttpResponse.builder()
//                        .timeStamp(now().toString())
//                        .data(of("page", spielerService.findByFullName(
//                                fullName.orElse(""),
//                                page.orElse(0),
//                                size.orElse(20), sort)))
//                        .message("Spieler abgerufen")
//                        .status(OK)
//                        .statusCode(OK.value())
//                        .build());
//    }

    //*-----------------------------------
        //Final implementation: We get all the attributes that we want to show on the starting page, also the attributes that may be used for filtering.
    @GetMapping("/start/filtered")
    public ResponseEntity<HttpResponse> getSpieler(@RequestParam Optional<String> fullName,
                                                   @RequestParam Optional<Integer> fifaVersion,
                                                   @RequestParam Optional<String> preferredFoot,
                                                   @RequestParam Optional<Integer> minAge,
                                                   @RequestParam Optional<Integer> maxAge,
                                                   @RequestParam Optional<Integer> minOverall,
                                                   @RequestParam Optional<Integer> maxOverall,
                                                   @RequestParam Optional<Integer> minPotential,
                                                   @RequestParam Optional<Integer> maxPotential,
                                                   @RequestParam Optional<Integer> minHeight,
                                                   @RequestParam Optional<Integer> maxHeight,
                                                   @RequestParam Optional<Long> minValue,
                                                   @RequestParam Optional<Long> maxValue,
                                                   @RequestParam Optional<Long> minWage,
                                                   @RequestParam Optional<Long> maxWage,
                                                   @RequestParam Optional<Integer> minHeadingAccuracy,
                                                   @RequestParam Optional<Integer> maxHeadingAccuracy,
                                                   @RequestParam Optional<Integer> minVolleys,
                                                   @RequestParam Optional<Integer> maxVolleys,
                                                   @RequestParam Optional<Integer> minDribbling,
                                                   @RequestParam Optional<Integer> maxDribbling,
                                                   @RequestParam Optional<Integer> minCurve,
                                                   @RequestParam Optional<Integer> maxCurve,
                                                   @RequestParam Optional<Integer> minFkAccuracy,
                                                   @RequestParam Optional<Integer> maxFkAccuracy,
                                                   @RequestParam Optional<Integer> minAcceleration,
                                                   @RequestParam Optional<Integer> maxAcceleration,
                                                   @RequestParam Optional<Integer> minSprintSpeed,
                                                   @RequestParam Optional<Integer> maxSprintSpeed,
                                                   @RequestParam Optional<Integer> minAgility,
                                                   @RequestParam Optional<Integer> maxAgility,
                                                   @RequestParam Optional<Integer> minReaction,
                                                   @RequestParam Optional<Integer> maxReaction,
                                                   @RequestParam Optional<Integer> minBalance,
                                                   @RequestParam Optional<Integer> maxBalance,
                                                   @RequestParam Optional<Integer> minShotPower,
                                                   @RequestParam Optional<Integer> maxShotPower,
                                                   @RequestParam Optional<Integer> minJumping,
                                                   @RequestParam Optional<Integer> maxJumping,
                                                   @RequestParam Optional<Integer> minStamina,
                                                   @RequestParam Optional<Integer> maxStamina,
                                                   @RequestParam Optional<Integer> minAggression,
                                                   @RequestParam Optional<Integer> maxAggression,
                                                   @RequestParam Optional<Integer> minLongShots,
                                                   @RequestParam Optional<Integer> maxLongShots,
                                                   @RequestParam Optional<Integer> minCrossing,
                                                   @RequestParam Optional<Integer> maxCrossing,
                                                   @RequestParam Optional<Integer> minFinishing,
                                                   @RequestParam Optional<Integer> maxFinishing,
                                                   @RequestParam Optional<Integer> minShortPassing,
                                                   @RequestParam Optional<Integer> maxShortPassing,
                                                   @RequestParam Optional<Integer> page,
                                                   @RequestParam Optional<Integer> size,
                                                   @RequestParam(name = "sort", required = false, defaultValue = "pf.overall") String sortAttribute,
                                                   @RequestParam(name = "order", required = false, defaultValue = "desc") String sortDirection) {
        Sort sort = Sort.by(sortAttribute).descending();
        if (sortDirection.equalsIgnoreCase("asc")) {
            sort = sort.ascending();
        }

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("page", spielerService.findByFullNameFiltered(
                                fullName.orElse(""),
                                fifaVersion.orElse(23),
                                preferredFoot.orElse(""),
                                minAge.orElse(0),
                                maxAge.orElse(100),
                                minOverall.orElse(0),
                                maxOverall.orElse(100),
                                minPotential.orElse(0),
                                maxPotential.orElse(100),
                                minHeight.orElse(0),
                                maxHeight.orElse(300),
                                minValue.orElse(0L),
                                maxValue.orElse(1000000000L),
                                minWage.orElse(0L),
                                maxWage.orElse(1000000000L),
                                minHeadingAccuracy.orElse(0),
                                maxHeadingAccuracy.orElse(100),
                                minVolleys.orElse(0),
                                maxVolleys.orElse(100),
                                minDribbling.orElse(0),
                                maxDribbling.orElse(100),
                                minCurve.orElse(0),
                                maxCurve.orElse(100),
                                minFkAccuracy.orElse(0),
                                maxFkAccuracy.orElse(100),
                                minAcceleration.orElse(0),
                                maxAcceleration.orElse(100),
                                minSprintSpeed.orElse(0),
                                maxSprintSpeed.orElse(100),
                                minAgility.orElse(0),
                                maxAgility.orElse(100),
                                minReaction.orElse(0),
                                maxReaction.orElse(100),
                                minBalance.orElse(0),
                                maxBalance.orElse(100),
                                minShotPower.orElse(0),
                                maxShotPower.orElse(100),
                                minJumping.orElse(0),
                                maxJumping.orElse(100),
                                minStamina.orElse(0),
                                maxStamina.orElse(100),
                                minAggression.orElse(0),
                                maxAggression.orElse(100),
                                minLongShots.orElse(0),
                                maxLongShots.orElse(100),
                                minCrossing.orElse(0),
                                maxCrossing.orElse(100),
                                minFinishing.orElse(0),
                                maxFinishing.orElse(100),
                                minShortPassing.orElse(0),
                                maxShortPassing.orElse(100),
                                page.orElse(0),
                                size.orElse(20),
                                sort)))
                        .message("Spieler abgerufen")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @GetMapping("/start/vergleich")
    public List<SpielerDTO> getSpielerToCompare(@RequestParam Optional<Integer> player1Id,
                                                @RequestParam Optional<Integer> player2Id,
                                                @RequestParam Optional<Integer> player3Id,
                                                @RequestParam Optional<Integer> player4Id,
                                                @RequestParam Optional<Integer> player5Id) {
        return spielerService.getSpielerToCompare(
                player1Id.orElse(0),
                player2Id.orElse(0),
                player3Id.orElse(0),
                player4Id.orElse(0),
                player5Id.orElse(0));
    }
}
