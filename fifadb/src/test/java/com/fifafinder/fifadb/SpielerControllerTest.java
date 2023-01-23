package com.fifafinder.fifadb;

import com.fifafinder.fifadb.DTOs.SpielerDTO;
import com.fifafinder.fifadb.controllers.SpielerController;
import com.fifafinder.fifadb.services.SpielerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpielerControllerTest {
    @Mock
    private SpielerService spielerService;

    @InjectMocks
    private SpielerController spielerController;

    @Test
    public void testGetSpieler() {
        String fullName = "";
        int fifaVersion = 23;
        String preferredFoot = "";
        int minAge = 0;
        int maxAge = 100;
        int minOverall = 0;
        int maxOverall = 100;
        int minPotential = 0;
        int maxPotential = 100;
        int minHeight = 0;
        int maxHeight = 300;
        long minValue = 0;
        long maxValue = 1000000000L;
        long minWage = 0;
        long maxWage = 1000000000L;
        int minHeadingAccuracy = 0;
        int maxHeadingAccuracy = 100;
        int minVolleys = 0;
        int maxVolleys = 100;
        int minDribbling = 0;
        int maxDribbling = 100;
        int minCurve = 0;
        int maxCurve = 100;
        int minFkAccuracy = 0;
        int maxFkAccuracy = 100;
        int minAcceleration = 0;
        int maxAcceleration = 100;
        int minSprintSpeed = 0;
        int maxSprintSpeed = 100;
        int minAgility = 0;
        int maxAgility = 100;
        int minReaction = 0;
        int maxReaction = 100;
        int minBalance = 0;
        int maxBalance = 100;
        int minShotPower = 0;
        int maxShotPower = 100;
        int minJumping = 0;
        int maxJumping = 100;
        int minStamina = 0;
        int maxStamina = 100;
        int minAggression = 0;
        int maxAggression = 100;
        int minLongShots = 0;
        int maxLongShots = 100;
        int minCrossing = 0;
        int maxCrossing = 100;
        int minFinishing = 0;
        int maxFinishing = 100;
        int minShortPassing = 0;
        int maxShortPassing = 100;
        int page = 0;
        int size = 20;
        String sortAttribute = "pf.overall";
        String sortDirection = "desc";
        Sort sort = Sort.by(sortAttribute).descending();
        ArrayList<SpielerDTO> spielerDTOS = new ArrayList<>();
        spielerDTOS.add(new SpielerDTO());
        Page<SpielerDTO> spielerDTOPage = new PageImpl<>(spielerDTOS);

        when(spielerService.findByFullNameFiltered(
                fullName,
                fifaVersion,
                preferredFoot,
                minAge,
                maxAge,
                minOverall,
                maxOverall,
                minPotential,
                maxPotential,
                minHeight,
                maxHeight,
                minValue,
                maxValue,
                minWage,
                maxWage,
                minHeadingAccuracy,
                maxHeadingAccuracy,
                minVolleys,
                maxVolleys,
                minDribbling,
                maxDribbling,
                minCurve,
                maxCurve,
                minFkAccuracy,
                maxFkAccuracy,
                minAcceleration,
                maxAcceleration,
                minSprintSpeed,
                maxSprintSpeed,
                minAgility,
                maxAgility,
                minReaction,
                maxReaction,
                minBalance,
                maxBalance,
                minShotPower,
                maxShotPower,
                minJumping,
                maxJumping,
                minStamina,
                maxStamina,
                minAggression,
                maxAggression,
                minLongShots,
                maxLongShots,
                minCrossing,
                maxCrossing,
                minFinishing,
                maxFinishing,
                minShortPassing,
                maxShortPassing,
                page,
                size,
                sort
        )).thenReturn(spielerDTOPage);

        ResponseEntity<HttpResponse> responseEntity = spielerController.getSpieler(Optional.of(fullName),
                Optional.of(fifaVersion), Optional.of(preferredFoot),
                Optional.of(minAge), Optional.of(maxAge),
                Optional.of(minOverall), Optional.of(maxOverall),
                Optional.of(minPotential),
                Optional.of(maxPotential),
                Optional.of(minHeight),
                Optional.of(maxHeight),
                Optional.of(minValue),
                Optional.of(maxValue),
                Optional.of(minWage),
                Optional.of(maxWage),
                Optional.of(minHeadingAccuracy),
                Optional.of(maxHeadingAccuracy),
                Optional.of(minVolleys),
                Optional.of(maxVolleys),
                Optional.of(minDribbling),
                Optional.of(maxDribbling),
                Optional.of(minCurve),
                Optional.of(maxCurve),
                Optional.of(minFkAccuracy),
                Optional.of(maxFkAccuracy),
                Optional.of(minAcceleration),
                Optional.of(maxAcceleration),
                Optional.of(minSprintSpeed),
                Optional.of(maxSprintSpeed),
                Optional.of(minAgility),
                Optional.of(maxAgility),
                Optional.of(minReaction),
                Optional.of(maxReaction),
                Optional.of(minBalance),
                Optional.of(maxBalance),
                Optional.of(minShotPower),
                Optional.of(maxShotPower),
                Optional.of(minJumping),
                Optional.of(maxJumping),
                Optional.of(minStamina),
                Optional.of(maxStamina),
                Optional.of(minAggression),
                Optional.of(maxAggression),
                Optional.of(minLongShots),
                Optional.of(maxLongShots),
                Optional.of(minCrossing),
                Optional.of(maxCrossing),
                Optional.of(minFinishing),
                Optional.of(maxFinishing),
                Optional.of(minShortPassing),
                Optional.of(maxShortPassing),
                Optional.of(page),
                Optional.of(size), sortAttribute, sortDirection);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(spielerDTOPage, responseEntity.getBody().getData().get("page"));
    }
}
