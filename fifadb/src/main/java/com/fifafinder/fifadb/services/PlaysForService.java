package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.DTOs.AddPlaysForDTO;
import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.dto.UpdateDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import com.fifafinder.fifadb.repositories.MannschaftenRepository;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;
import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.PlaysFor;
import com.fifafinder.fifadb.entities.Spieler;

@Service
public class PlaysForService {

    private final PlaysForRepository playsForRepository;
    private final SpielerRepository spielerRepository;
    private final FifaVersionRepository fifaVersionRepository;
    private final ModelMapper modelMapper;
    private final MannschaftenRepository mannschaftenRepository;
    private final FifaService fifaService;
    private final IsFromService isFromService;
    private final LandService landService;


    @Autowired
    public PlaysForService(PlaysForRepository playsForRepository, SpielerRepository spielerRepository, FifaVersionRepository fifaVersionRepository,
                           ModelMapper modelMapper, MannschaftenRepository mannschaftenRepository, FifaService fifaService, IsFromService isFromService, LandService landService) {
        this.playsForRepository = playsForRepository;
        this.spielerRepository = spielerRepository;
        this.fifaVersionRepository = fifaVersionRepository;
        this.modelMapper = modelMapper;
        this.mannschaftenRepository = mannschaftenRepository;
        this.fifaService = fifaService;
        this.isFromService = isFromService;
        this.landService = landService;
    }

    public long count() {
        return playsForRepository.count();
    }

    //Author: Enes
    public long countUniquePlayerRecords(int id){
        return playsForRepository.countById_PlayerID(id);
    }
    public List<PlaysFor> getAll() {
        return playsForRepository.findAll();
    }

    //Author: Jannik
    public SpielerDetailDTO getDetails(int playerId, int fifaVersion) {
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(playerId);
        playsForId.setFifaVersion(fifaVersion);
        PlaysFor playsFor = playsForRepository.findPlaysForById(playsForId);
        SpielerDetailDTO details = modelMapper.map(playsFor, SpielerDetailDTO.class);
        return details;
    }

    //Author: Jannik
    public PlaysFor editDetails(PlaysForId playsForId, UpdateDTO updateDTO) {
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
        return details;
    }

    //Author: Jannik
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


    //Author: Enes
    public void addPlayer(AddPlaysForDTO playsForDTO) {

        Spieler spieler = new Spieler();
        spieler.setKnownName(playsForDTO.getKnownName());
        spieler.setFullName(playsForDTO.getFullName());
        spieler.setBirthDate(playsForDTO.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        spielerRepository.save(spieler);

        FifaVersion fifaversion = fifaService.getVersionByID(playsForDTO.getFifaVersion());

        Land land = landService.findByCountryName(playsForDTO.getNationalTeam());

        IsFromId isFromId = new IsFromId();
        isFromId.setPlayerID(spieler.getId());
        isFromId.setCountryID(land.getId());

        isFromService.saveIsFrom(isFromId,land,spieler);

        PlaysForId playsForId = new PlaysForId();
        playsForId.setFifaVersion(playsForDTO.getFifaVersion());
        playsForId.setPlayerID(spieler.getId());

        PlaysFor playsFor = new PlaysFor();
        playsFor.setPlayerID(spieler);
        playsFor.setFifaVersion(fifaversion);
        playsFor.setId(playsForId);


        playsFor.setHeight(playsForDTO.getHeight());
        playsFor.setClubPosition(playsForDTO.getClubPosition());
        playsFor.setClubNumber(playsForDTO.getClubNumber());
        playsFor.setNationalPosition(playsForDTO.getNationalPosition());
        playsFor.setNationalNumber(playsForDTO.getNationalNumber());
        playsFor.setPreferredFoot(playsForDTO.getPreferredFoot());
        playsFor.setContractUntil(playsForDTO.getContractUntil());
        playsFor.setOnLoan(playsForDTO.getOnLoan());
        playsFor.setNationalTeam(playsForDTO.getNationalTeam());
        playsFor.setAge(playsForDTO.getAge());
        playsFor.setWeight(playsForDTO.getWeight());
        playsFor.setOverall(playsForDTO.getOverall());
        playsFor.setPotential(playsForDTO.getPotential());
        playsFor.setBestPosition(playsForDTO.getBestPosition());
        playsFor.setClubID(mannschaftenRepository.findMannschaftenByClubName(playsForDTO.getClubName()));
        playsFor.setValueEUR(playsForDTO.getValueEUR());
        playsFor.setWage(playsForDTO.getWage());
        playsFor.setReleaseClause(playsForDTO.getReleaseClause());
        playsFor.setIntReputation(playsForDTO.getIntReputation());
        playsFor.setWeakFoot(playsForDTO.getWeakFoot());
        playsFor.setSkillMoves(playsForDTO.getSkillMoves());
        playsFor.setCrossing(playsForDTO.getCrossing());
        playsFor.setFinishing(playsForDTO.getFinishing());
        playsFor.setHeadingAccuracy(playsForDTO.getHeadingAccuracy());
        playsFor.setShortPassing(playsForDTO.getShortPassing());
        playsFor.setVolleys(playsForDTO.getVolleys());
        playsFor.setDribbling(playsForDTO.getDribbling());
        playsFor.setCurve(playsForDTO.getCurve());
        playsFor.setFkAccuracy(playsForDTO.getFKAccuracy());
        playsFor.setLongPassing(playsForDTO.getLongPassing());
        playsFor.setBallControl(playsForDTO.getBallControl());
        playsFor.setAcceleration(playsForDTO.getAcceleration());
        playsFor.setSprintSpeed(playsForDTO.getAge());
        playsFor.setAgility(playsForDTO.getAgility());
        playsFor.setReaction(playsForDTO.getReaction());
        playsFor.setBalance(playsForDTO.getBalance());
        playsFor.setShotPower(playsForDTO.getShotPower());
        playsFor.setJumping(playsForDTO.getJumping());
        playsFor.setStamina(playsForDTO.getStamina());
        playsFor.setStrength(playsForDTO.getStrength());
        playsFor.setLongShots(playsForDTO.getLongShots());
        playsFor.setAggression(playsForDTO.getAggression());
        playsFor.setInterceptions(playsForDTO.getInterception());
        playsFor.setPositioning(playsForDTO.getPositioning());
        playsFor.setVision(playsForDTO.getVision());
        playsFor.setPenalties(playsForDTO.getPenalties());
        playsFor.setComposure(playsForDTO.getComposure());
        playsFor.setMarking(playsForDTO.getMarking());
        playsFor.setStandingTackle(playsForDTO.getStandingTackle());
        playsFor.setSlidingTackle(playsForDTO.getSlidingTackle());
        playsFor.setGKDiving(playsForDTO.getGKDiving());
        playsFor.setGKHandling(playsForDTO.getGKHandling());
        playsFor.setGKKicking(playsForDTO.getGKKicking());
        playsFor.setGKPositioning(playsForDTO.getGKPositioning());
        playsFor.setGKReflexes(playsForDTO.getGKReflexes());
        playsFor.setPhotoUrl(playsForDTO.getPhotoUrl());

        playsForRepository.save(playsFor);
    }

    //Author: Levi
    @Transactional
    public void deleteAllByPlayerID(int id) {
        playsForRepository.deleteAllById_PlayerID(id);
        spielerRepository.deleteById(id);
    }

    //Author: Levi
    @Transactional
    public void deleteAllByPlayerIDAndFifaVersion(int id, int fifaVersion){
        playsForRepository.deleteAllById_PlayerIDAndId_FifaVersion(id, fifaVersion);
        if(countUniquePlayerRecords(id)==0){ // Deletes Player record from Spieler Table when no entry left in PlaysFor Table
            spielerRepository.deleteById(id);
        }
    }

    //Author: Levi
    public List<FifaVersion> listFifaVersions(){
        return fifaVersionRepository.findAll();
    }
}
