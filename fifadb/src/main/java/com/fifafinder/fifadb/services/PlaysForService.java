package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.PlaysFor;
import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaysForService {

    private final PlaysForRepository playsForRepository;

    @Autowired
    public PlaysForService(PlaysForRepository playsForRepository) {

        this.playsForRepository = playsForRepository;
    }

    public void addPlayer(Spieler spieler, FifaVersion fifaversion) {
        PlaysFor playsFor = new PlaysFor();
        playsFor.setPlayerID(spieler);
        playsFor.setFifaVersion(fifaversion);
        playsForRepository.save(playsFor);
    }
}
