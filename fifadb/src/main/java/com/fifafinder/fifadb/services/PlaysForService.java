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
    }

    public void editDetails(PlaysForId playsForId, Integer height, String clubPosition, Integer clubNumber, String nationalPosition, Integer nationalNumber, String preferredFoot,
                            Integer contractUntil, String onLoan, String nationalTeam, Integer age, Integer weight, Integer overall, Integer potential, String bestPosition,
                            Long valueEUR, Long wage, Long releaseClause, Integer intReputation, Integer weakFoot, Integer skillMoves, Integer crossing, Integer finishing,
                            Integer headingAccuracy, Integer shortPassing, Integer volleys, Integer dribbling, Integer curve, Integer fKAccuracy, Integer longPassing,
                            Integer ballControl, Integer acceleration, Integer sprintSpeed, Integer agility, Integer reaction, Integer balance, Integer shotPower, Integer jumping,
                            Integer stamina, Integer strength, Integer longShots, Integer aggression, Integer interceptions, Integer positioning, Integer vision, Integer penalties,
                            Integer composure, Integer marking, Integer standingTackle, Integer slidingTackle, Integer gKDiving, Integer gKHandling, Integer gKKicking, Integer gKPositioning,
                            Integer gKReflexes, String photoUrl) {
        PlaysFor details = playsForRepository.findPlaysForById(playsForId);
        details.setHeight(height);
        details.setClubPosition(clubPosition);
        details.setClubNumber(clubNumber);
        details.setNationalPosition(nationalPosition);
        details.setNationalNumber(nationalNumber);
        details.setPreferredFoot(preferredFoot);
        details.setContractUntil(contractUntil);
        details.setOnLoan(onLoan);
        details.setNationalTeam(nationalTeam);
        details.setAge(age);
        details.setWeight(weight);
        details.setOverall(overall);
        details.setPotential(potential);
        details.setBestPosition(bestPosition);
        details.setValueEUR(valueEUR);
        details.setWage(wage);
        details.setReleaseClause(releaseClause);
        details.setIntReputation(intReputation);
        details.setWeakFoot(weakFoot);
        details.setSkillMoves(skillMoves);
        details.setCrossing(crossing);
        details.setFinishing(finishing);
        details.setHeadingAccuracy(headingAccuracy);
        details.setShortPassing(shortPassing);
        details.setVolleys(volleys);
        details.setDribbling(dribbling);
        details.setCurve(curve);
        details.setFKAccuracy(fKAccuracy);
        details.setLongPassing(longPassing);
        details.setBallControl(ballControl);
        details.setAcceleration(acceleration);
        details.setSprintSpeed(sprintSpeed);
        details.setAgility(agility);
        details.setReaction(reaction);
        details.setBalance(balance);
        details.setShotPower(shotPower);
        details.setJumping(jumping);
        details.setStamina(stamina);
        details.setStrength(strength);
        details.setLongShots(longShots);
        details.setAggression(aggression);
        details.setInterceptions(interceptions);
        details.setPositioning(positioning);
        details.setVision(vision);
        details.setPenalties(penalties);
        details.setComposure(composure);
        details.setMarking(marking);
        details.setStandingTackle(standingTackle);
        details.setSlidingTackle(slidingTackle);
        details.setGKDiving(gKDiving);
        details.setGKHandling(gKHandling);
        details.setGKKicking(gKKicking);
        details.setGKPositioning(gKPositioning);
        details.setGKReflexes(gKReflexes);
        details.setPhotoUrl(photoUrl);
        playsForRepository.save(details);
    }
}
