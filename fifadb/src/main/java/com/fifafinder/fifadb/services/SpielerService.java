package com.fifafinder.fifadb.services;


import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.DTOs.SpielerDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fifafinder.fifadb.exceptionhandling.SpielerNotFoundException;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
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


    public Page<SpielerDTO> findByFullNameFiltered(String name,
                                                   int fifaVersion,
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
        return spielerRepository.findByFullNameFiltered(name,
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
                PageRequest.of(page, size, sort));
    }


//    public List<Spieler> spielerAnzeigen() {
//        return spielerRepository.findAll();
//    }

//    public Page<SpielerDTO> listAllSpieler(Pageable pageable){
//        return spielerRepository.listAllSpieler(pageable);
//    }

    /*
        public Spieler addSpieler (Spieler spieler){

            return spielerRepository.save(spieler);

        }

        public List<Spieler> findAllSpieler(){

            return spielerRepository.findAll();

        }

        public Spieler updateSpieler(Spieler spieler){

            return spielerRepository.save(spieler);

        }

        public Spieler getSpielerById(Integer id){

            return spielerRepository.findSpielerById(id).orElseThrow(()-> new SpielerNotFoundException("User by id"+id+" was not found"));

        }

        public Spieler getSpielerByfullname(String n){

            return spielerRepository.findSpielerByfullname(n).orElseThrow(()->new SpielerNotFoundException("User by name"+n+" not found"));

        }

        public void deleteSpieler(Integer ID){

            spielerRepository.deleteSpielerById(ID);
        }
    */



    public void addPlayer(Spieler spieler) {
        int i = 1;
        Optional<Spieler> spielerOptional = spielerRepository.findSpielerById(1);
        while(spielerOptional.isPresent())
        {
          i++;
          spielerOptional = spielerRepository.findSpielerById(i);
        }
        spieler.setId(i);
        spielerRepository.save(spieler);
    }

    public Optional<Spieler> findSpieler() {
        Optional<Spieler> spielerOptional = spielerRepository.findSpielerById(10000);
        if(spielerOptional.isPresent())
            return spielerOptional;
        System.out.println("Spieler nicht gefunden!");
        return null;
    }

    public void deleteSpieler() {
        spielerRepository.deleteSpielerById(100000);
    }
}