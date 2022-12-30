package com.fifafinder.fifadb.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.exceptionhandling.SpielerNotFoundException;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@Transactional

public class SpielerService {

    private final SpielerRepository spielerRepository;

    @Autowired
    public SpielerService(SpielerRepository spielerRepository) {

        this.spielerRepository = spielerRepository;
    }

    public long countSpieler() {
        return spielerRepository.count();
    }


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