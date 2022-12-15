package com.fifafinder.fifadb.service;

import com.fifafinder.fifadb.entities.Spieler;

import com.fifafinder.fifadb.exceptionhandling.SpielerNotFoundException;
import com.fifafinder.fifadb.repositories.SpielerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;





@Service

public class SpielerService {

    private final SpielerRepository spilerRepo;

    @Autowired

    public SpielerService(SpielerRepository spilerRepo) {

        this.spilerRepo = spilerRepo;

    }

    public Spieler addSpieler (Spieler spieler){

        return spilerRepo.save(spieler);

    }

    public List<Spieler> findAllSpieler(){

        return spilerRepo.findAll();

    }

    public Spieler updateSpieler(Spieler spieler){

        return spilerRepo.save(spieler);

    }

    public Spieler getSpielerById(Integer id){

        return spilerRepo.findSpielerById(id).orElseThrow(()-> new SpielerNotFoundException("User by id"+id+" was not found"));

    }

    public Spieler getSpielerByfullname(String n){

        return spilerRepo.findSpielerByfullname(n).orElseThrow(()->new SpielerNotFoundException("User by name"+n+" not found"));

    }

    public void deleteSpieler(Integer ID){

        spilerRepo.deleteSpielerById(ID);

    }

    public void countSpieler(Spieler spieler) {

    }


}