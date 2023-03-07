package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.DTOs.SpielerDTO;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;




@Service
@Transactional
@Slf4j
public class SpielerService {

    private final SpielerRepository spielerRepository;

    @Autowired
    public SpielerService(SpielerRepository spielerRepository) {
        this.spielerRepository = spielerRepository;
    }

    public long countSpieler() {
        return spielerRepository.count();
    }

    public List<Spieler> getAllSpieler() {
        return spielerRepository.findAll();
    }
    public Spieler getSpieler(int id) {
        return spielerRepository.findById(id);
    }
    public Spieler getSpieler(String fullName) {
        return spielerRepository.findSpielerByFullName(fullName);
    }

    public void deleteSpielerByID(int id){
        spielerRepository.deleteById(id);
    }

    //Author:Saif
    public Page<SpielerDTO> findByFullNameFiltered(String name,
                                                   int fifaVersion,
                                                   String clubName,
                                                   String preferredFoot,
                                                   int minAge,
                                                   int maxAge,
                                                   int minOverall,
                                                   int maxOverall,
                                                   int minPotential,
                                                   int maxPotential,
                                                   int minHeight,
                                                   int maxHeight,
                                                   long minValue,
                                                   long maxValue,
                                                   long minWage,
                                                   long maxWage,
                                                   int minHeadingAccuracy,
                                                   int maxHeadingAccuracy,
                                                   int minVolleys,
                                                   int maxVolleys,
                                                   int minDribbling,
                                                   int maxDribbling,
                                                   int minCurve,
                                                   int maxCurve,
                                                   int minFkAccuracy,
                                                   int maxFkAccuracy,
                                                   int minAcceleration,
                                                   int maxAcceleration,
                                                   int minSprintSpeed,
                                                   int maxSprintSpeed,
                                                   int minAgility,
                                                   int maxAgility,
                                                   int minReaction,
                                                   int maxReaction,
                                                   int minBalance,
                                                   int maxBalance,
                                                   int minShotPower,
                                                   int maxShotPower,
                                                   int minJumping,
                                                   int maxJumping,
                                                   int minStamina,
                                                   int maxStamina,
                                                   int minAggression,
                                                   int maxAggression,
                                                   int minLongShots,
                                                   int maxLongShots,
                                                   int minCrossing,
                                                   int maxCrossing,
                                                   int minFinishing,
                                                   int maxFinishing,
                                                   int minShortPassing,
                                                   int maxShortPassing,
                                                   int page, int size, Sort sort) {
        return spielerRepository.findByFullNameFiltered(
                name,
                fifaVersion,
                clubName,
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
                PageRequest.of(page, size, sort));
    }


    //Author:Saif
    public List<SpielerDTO> getSpielerToCompare(int player1Id, int player2Id, int player3Id, int player4Id, int player5Id, int fifaVersion){
        return spielerRepository.getSpielerToCompare(player1Id, player2Id,player3Id,player4Id,player5Id, fifaVersion);
    }

        public Spieler addSpieler (Spieler spieler){

            return spielerRepository.save(spieler);

        }

    //Author:Enes
    public void addPlayer(Spieler spieler) {

        spieler.setFifaID(null);
        spielerRepository.save(spieler);
    }
}