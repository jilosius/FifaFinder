package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.entities.Land;
import com.fifafinder.fifadb.repositories.LandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandService {


    private final LandRepository landRepository;

    @Autowired
    public LandService(LandRepository landRepository){
        this.landRepository = landRepository;
    }

    public Land findByCountryName(String name){
        return landRepository.findByCountryName(name);
    }
}
