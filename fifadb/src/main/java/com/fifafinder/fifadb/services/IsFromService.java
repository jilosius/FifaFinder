package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.entities.IsFrom;
import com.fifafinder.fifadb.entities.Land;
import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.repositories.IsFromRepository;
import com.fifafinder.fifadb.entities.IsFromId;
import org.springframework.stereotype.Service;

//Author: Enes
@Service
public class IsFromService {

    private final IsFromRepository isFromRepository;


    IsFromService(IsFromRepository isFromRepository) {
        this.isFromRepository = isFromRepository;
    }

    public void saveIsFrom(IsFromId isFromId, Land land, Spieler spieler){
        IsFrom isFrom = new IsFrom();
        isFrom.setId(isFromId);
        isFrom.setCountryID(land);
        isFrom.setPlayerID(spieler);

        isFromRepository.save(isFrom);

    }
}
