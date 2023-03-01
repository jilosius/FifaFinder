package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.dto.UpdateDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import com.fifafinder.fifadb.repositories.MannschaftenRepository;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
