package com.fifafinder.fifadb.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.entities.PlaysFor;
import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PlaysForService {

    private final PlaysForRepository playsForRepository;
    private final SpielerRepository spielerRepository;
    private final FifaVersionRepository fifaVersionRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public PlaysForService(PlaysForRepository playsForRepository, SpielerRepository spielerRepository, FifaVersionRepository fifaVersionRepository, ModelMapper modelMapper) {
        this.playsForRepository = playsForRepository;
        this.spielerRepository = spielerRepository;
        this.fifaVersionRepository = fifaVersionRepository;
        this.modelMapper = modelMapper;
    }

    public long count() {
        return playsForRepository.count();
    }

    public List<PlaysFor> getAll() {
        return playsForRepository.findAll();
    }

    public SpielerDetailDTO getDetails(int playerId, int fifaVersion) {
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(playerId);
        playsForId.setFifaVersion(fifaVersion);
        PlaysFor playsFor = playsForRepository.findPlaysForById(playsForId);
        SpielerDetailDTO details = modelMapper.map(playsFor, SpielerDetailDTO.class);
        return details;


    public void addPlayer(Spieler spieler, FifaVersion fifaversion) {
        PlaysFor playsFor = new PlaysFor();
        playsFor.setPlayerID(spieler);
        playsFor.setFifaVersion(fifaversion);
        playsForRepository.save(playsFor);
    }

    public void addPlayer(Spieler spieler, FifaVersion fifaversion, Integer height, String clubPosition, Integer clubNumber, String nationalPosition,
                          Integer nationalNumber, String preferredFoot, Integer contractUntil, String onLoan, String nationalTeam, Integer age,
                          Integer weight, Integer overall, Integer potential, String bestPosition, Mannschaften clubID, Long valueEUR, Long wage,
                          Long releaseClause, Integer intReputation, Integer weakFoot, Integer skillMoves, Integer crossing, Integer finishing,
                          Integer headingAccuracy, Integer shortPassing, Integer volleys, Integer dribbling, Integer curve, Integer fKAccuracy,
                          Integer longPassing, Integer ballControl, Integer acceleration, Integer sprintSpeed, Integer agility, Integer reaction,
                          Integer balance, Integer shotPower, Integer jumping, Integer stamina, Integer strength, Integer longShots, Integer aggression,
                          Integer interceptions, Integer positioning, Integer vision, Integer penalties, Integer composure, Integer marking,
                          Integer standingTackle, Integer slidingTackle, Integer gKDiving, Integer gKHandling,
                          Integer gKKicking, Integer gKPositioning, Integer gKReflexes, String photoUrl) {



        PlaysFor playsFor = new PlaysFor();
        playsFor.setPlayerID(spieler);
        playsFor.setFifaVersion(fifaversion);

        playsFor.setHeight(height);
        playsFor.setClubPosition(clubPosition);
        playsFor.setClubNumber(clubNumber);
        playsFor.setNationalPosition(nationalPosition);
        playsFor.setNationalNumber(nationalNumber);
        playsFor.setPreferredFoot(preferredFoot);
        playsFor.setContractUntil(contractUntil);
        playsFor.setOnLoan(onLoan);
        playsFor.setNationalTeam(nationalTeam);
        playsFor.setAge(age);
        playsFor.setWeight(weight);
        playsFor.setOverall(overall);
        playsFor.setPotential(potential);
        playsFor.setBestPosition(bestPosition);
        playsFor.setClubID(clubID);
        playsFor.setValueEUR(valueEUR);
        playsFor.setWage(wage);
        playsFor.setReleaseClause(releaseClause);
        playsFor.setIntReputation(intReputation);
        playsFor.setWeakFoot(weakFoot);
        playsFor.setSkillMoves(skillMoves);
        playsFor.setCrossing(crossing);
        playsFor.setFinishing(finishing);
        playsFor.setHeadingAccuracy(headingAccuracy);
        playsFor.setShortPassing(shortPassing);
        playsFor.setVolleys(volleys);
        playsFor.setDribbling(dribbling);
        playsFor.setCurve(curve);
        playsFor.setFKAccuracy(fKAccuracy);
        playsFor.setLongPassing(longPassing);
        playsFor.setBallControl(ballControl);
        playsFor.setAcceleration(acceleration);
        playsFor.setSprintSpeed(sprintSpeed);
        playsFor.setAgility(agility);
        playsFor.setReaction(reaction);
        playsFor.setBalance(balance);
        playsFor.setShotPower(shotPower);
        playsFor.setJumping(jumping);
        playsFor.setStamina(stamina);
        playsFor.setStrength(strength);
        playsFor.setLongShots(longShots);
        playsFor.setAggression(aggression);
        playsFor.setInterceptions(interceptions);
        playsFor.setPositioning(positioning);
        playsFor.setVision(vision);
        playsFor.setPenalties(penalties);
        playsFor.setComposure(composure);
        playsFor.setMarking(marking);
        playsFor.setStandingTackle(standingTackle);
        playsFor.setSlidingTackle(slidingTackle);
        playsFor.setGKDiving(gKDiving);
        playsFor.setGKDiving(gKDiving);
        playsFor.setGKHandling(gKHandling);
        playsFor.setGKKicking(gKKicking);
        playsFor.setGKPositioning(gKPositioning);
        playsFor.setGKReflexes(gKReflexes);
        playsFor.setPhotoUrl(photoUrl);


        playsForRepository.save(playsFor);
    }
}
