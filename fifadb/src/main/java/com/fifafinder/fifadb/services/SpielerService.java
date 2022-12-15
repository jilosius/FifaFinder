package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.exceptionhandling.SpielerNotFoundException;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;





@Service

public class SpielerService {

    private final SpielerRepository spielerRepository;

    @Autowired

    public SpielerService(SpielerRepository spielerRepository) {

        this.spielerRepository = spielerRepository;

    }

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

    public long countSpieler() {
       return spielerRepository.count();
    }


}