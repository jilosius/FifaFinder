package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.entities.PlaysFor;
import com.fifafinder.fifadb.entities.PlaysForId;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlaysForServiceTest {
    @Mock
    private final PlaysForService underTest;
    private final PlaysForRepository playsForRepository;

    public PlaysForServiceTest(PlaysForService playsForService, PlaysForRepository playsForRepository) {
        this.underTest = playsForService;
        this.playsForRepository = playsForRepository;
    }

    @Test
    public void shouldUpdateDetails() {
        //given
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(158023);
        playsForId.setFifaVersion(23);
        Integer height = 100;
        String clubPosition= "A";
        Integer clubNumber = 100;
        String nationalPosition = "B";
        Integer nationalNumber = 100;
        String preferredFoot = "C";
        Integer contractUntil = 100;
        String onLoan = "D";
        String nationalTeam = "E";
        Integer age = 100;
        Integer weight = 100;
        Integer overall = 100;
        Integer potential = 100;
        String bestPosition ="F";
        Long valueEUR = 100L;
        Long wage = 100L;
        Long releaseClause = 100L;
        Integer intReputation = 100;
        Integer weakFoot = 100;
        Integer skillMoves = 100;
        Integer crossing = 100;
        Integer finishing = 100;
        Integer headingAccuracy = 100;
        Integer shortPassing = 100;
        Integer volleys = 100;
        Integer dribbling = 100;
        Integer curve = 100;
        Integer fKAccuracy = 100;
        Integer longPassing = 100;
        Integer ballControl = 100;
        Integer acceleration = 100;
        Integer sprintSpeed = 100;
        Integer agility = 100;
        Integer reaction = 100;
        Integer balance = 100;
        Integer shotPower = 100;
        Integer jumping = 100;
        Integer stamina = 100;
        Integer strength = 100;
        Integer longShots = 100;
        Integer aggression = 100;
        Integer interceptions = 100;
        Integer positioning = 100;
        Integer vision = 100;
        Integer penalties = 100;
        Integer composure = 100;
        Integer marking = 100;
        Integer standingTackle = 100;
        Integer slidingTackle = 100;
        Integer gKDiving = 100;
        Integer gKHandling = 100;
        Integer gKKicking = 100;
        Integer gKPositioning = 100;
        Integer gKReflexes = 100;
        String photoUrl = "G";

        SpielerDetailDTO oldDetails = underTest.getDetails(158023, 23);

        //when
        underTest.editDetails(playsForId, height, clubPosition, clubNumber, nationalPosition, nationalNumber, preferredFoot, contractUntil, onLoan, nationalTeam, age, weight,
                overall, potential, bestPosition, valueEUR, wage, releaseClause, intReputation, weakFoot, skillMoves, crossing, finishing, headingAccuracy,
                shortPassing, volleys, dribbling, curve, fKAccuracy, longPassing, ballControl, acceleration, sprintSpeed, agility, reaction, balance, shotPower,
                jumping, stamina, strength, longShots, aggression, interceptions, positioning, vision, penalties, composure, marking, standingTackle, slidingTackle,
                gKDiving, gKHandling, gKKicking,gKPositioning, gKReflexes, photoUrl);

        //then
        PlaysFor newDetails = playsForRepository.findPlaysForById(playsForId);
        //compare old to new Details
    }
}
