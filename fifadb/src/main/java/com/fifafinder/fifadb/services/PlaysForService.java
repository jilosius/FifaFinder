package com.fifafinder.fifadb.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.dto.UpdateDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import com.fifafinder.fifadb.repositories.MannschaftenRepository;
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
    private final MannschaftenRepository mannschaftenRepository;


    @Autowired
    public PlaysForService(PlaysForRepository playsForRepository, SpielerRepository spielerRepository, FifaVersionRepository fifaVersionRepository, ModelMapper modelMapper, MannschaftenRepository mannschaftenRepository) {
        this.playsForRepository = playsForRepository;
        this.spielerRepository = spielerRepository;
        this.fifaVersionRepository = fifaVersionRepository;
        this.modelMapper = modelMapper;
        this.mannschaftenRepository = mannschaftenRepository;
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

    public void editDetails(PlaysForId playsForId, UpdateDTO updateDTO) {
        PlaysFor details = playsForRepository.findPlaysForById(playsForId);
        details.setHeight(updateDTO.getHeight());
        details.setClubPosition(updateDTO.getClubPosition());
        details.setClubNumber(updateDTO.getClubNumber());
        details.setNationalPosition(updateDTO.getNationalPosition());
        details.setNationalNumber(updateDTO.getNationalNumber());
        details.setPreferredFoot(updateDTO.getPreferredFoot());
        details.setContractUntil(updateDTO.getContractUntil());
        details.setOnLoan(updateDTO.getOnLoan());
        details.setNationalTeam(updateDTO.getNationalTeam());
        details.setWeight(updateDTO.getWeight());
        details.setOverall(updateDTO.getOverall());
        details.setPotential(updateDTO.getPotential());
        details.setBestPosition(updateDTO.getBestPosition());
        details.setClubID(mannschaftenRepository.findMannschaftenByClubName(updateDTO.getClubName()));
        details.setValueEUR(updateDTO.getValueEUR());
        details.setWage(updateDTO.getWage());
        details.setReleaseClause(updateDTO.getReleaseClause());
        details.setIntReputation(updateDTO.getIntReputation());
        details.setWeakFoot(updateDTO.getWeakFoot());
        details.setSkillMoves(updateDTO.getSkillMoves());
        details.setCrossing(updateDTO.getCrossing());
        details.setFinishing(updateDTO.getFinishing());
        details.setHeadingAccuracy(updateDTO.getHeadingAccuracy());
        details.setShortPassing(updateDTO.getShortPassing());
        details.setVolleys(updateDTO.getVolleys());
        details.setDribbling(updateDTO.getDribbling());
        details.setCurve(updateDTO.getCurve());
        details.setFkAccuracy(updateDTO.getFKAccuracy());
        details.setLongPassing(updateDTO.getLongPassing());
        details.setBallControl(updateDTO.getBallControl());
        details.setAcceleration(updateDTO.getAcceleration());
        details.setSprintSpeed(updateDTO.getSprintSpeed());
        details.setAgility(updateDTO.getAgility());
        details.setReaction(updateDTO.getReaction());
        details.setBalance(updateDTO.getBalance());
        details.setShotPower(updateDTO.getShotPower());
        details.setJumping(updateDTO.getJumping());
        details.setStamina(updateDTO.getStamina());
        details.setStrength(updateDTO.getStrength());
        details.setLongShots(updateDTO.getLongShots());
        details.setAggression(updateDTO.getAggression());
        details.setInterceptions(updateDTO.getInterceptions());
        details.setPositioning(updateDTO.getPositioning());
        details.setVision(updateDTO.getVision());
        details.setPenalties(updateDTO.getPenalties());
        details.setComposure(updateDTO.getComposure());
        details.setMarking(updateDTO.getMarking());
        details.setStandingTackle(updateDTO.getStandingTackle());
        details.setSlidingTackle(updateDTO.getSlidingTackle());
        details.setGKDiving(updateDTO.getGKDiving());
        details.setGKHandling(updateDTO.getGKHandling());
        details.setGKKicking(updateDTO.getGKKicking());
        details.setGKPositioning(updateDTO.getGKPositioning());
        details.setGKReflexes(updateDTO.getGKReflexes());
        details.setPhotoUrl(updateDTO.getPhotoUrl());
        playsForRepository.save(details);
    }

    public UpdateDTO getDetailsForEdit(PlaysForId playsForId) {
        PlaysFor playsFor = playsForRepository.findPlaysForById(playsForId);
        UpdateDTO details = new UpdateDTO(playsFor.getHeight(), playsFor.getClubPosition(), playsFor.getClubNumber(), playsFor.getNationalPosition(), playsFor.getNationalNumber(),
                playsFor.getPreferredFoot(), playsFor.getContractUntil(), playsFor.getOnLoan(), playsFor.getNationalTeam(), playsFor.getWeight(), playsFor.getOverall(),
                playsFor.getPotential(), playsFor.getBestPosition(), playsFor.getClubID().getClubName(), playsFor.getValueEUR(), playsFor.getWage(), playsFor.getReleaseClause(),
                playsFor.getIntReputation(), playsFor.getWeakFoot(), playsFor.getSkillMoves(), playsFor.getCrossing(), playsFor.getFinishing(), playsFor.getHeadingAccuracy(),
                playsFor.getShortPassing(), playsFor.getVolleys(), playsFor.getDribbling(), playsFor.getCurve(), playsFor.getFkAccuracy(), playsFor.getLongPassing(), playsFor.getBallControl(),
                playsFor.getAcceleration(), playsFor.getSprintSpeed(), playsFor.getAgility(), playsFor.getReaction(), playsFor.getBalance(), playsFor.getShotPower(), playsFor.getJumping(),
                playsFor.getStamina(), playsFor.getStrength(), playsFor.getLongShots(), playsFor.getAggression(), playsFor.getInterceptions(), playsFor.getPositioning(), playsFor.getVision(),
                playsFor.getPenalties(), playsFor.getComposure(), playsFor.getMarking(), playsFor.getStandingTackle(), playsFor.getSlidingTackle(), playsFor.getGKDiving(), playsFor.getGKHandling(),
                playsFor.getGKKicking(), playsFor.getGKPositioning(), playsFor.getGKReflexes(), playsFor.getPhotoUrl());
        return details;
    }



    public void addPlayer(Spieler spieler, FifaVersion fifaversion,PlaysForId playsForId, Integer height, String clubPosition, Integer clubNumber, String nationalPosition,
                Integer nationalNumber, String preferredFoot, Integer contractUntil, String onLoan, String nationalTeam, Integer age,
                Integer weight, Integer overall, Integer potential, String bestPosition, String clubName, Long valueEUR, Long wage,
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
        playsFor.setId(playsForId);


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
        playsFor.setClubID(mannschaftenRepository.findMannschaftenByClubName(clubName));
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
        playsFor.setFkAccuracy(fKAccuracy);
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
        playsFor.setGKHandling(gKHandling);
        playsFor.setGKKicking(gKKicking);
        playsFor.setGKPositioning(gKPositioning);
        playsFor.setGKReflexes(gKReflexes);
        playsFor.setPhotoUrl(photoUrl);

        System.out.println(playsFor.getFifaVersion());
        playsForRepository.save(playsFor);
    }


}
