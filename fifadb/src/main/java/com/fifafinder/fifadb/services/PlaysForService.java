package com.fifafinder.fifadb.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.exceptionhandling.SpielerNotFoundException;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaysForService {

    private final PlaysForRepository playsForRepository;
    private final SpielerRepository spielerRepository;
    private final FifaVersionRepository fifaVersionRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public PlaysForService(PlaysForRepository playsForRepository, SpielerRepository spielerRepository, FifaVersionRepository fifaVersionRepository, ModelMapper modelMapper) {
        this.playsForRepository = playsForRepository;
        this.spielerRepository = spielerRepository;
        this.fifaVersionRepository = fifaVersionRepository;
        this.modelMapper = modelMapper;
    }

    public long count() {
        return playsForRepository.count();
    }

    public long countUniquePlayerRecords(int id){
        return playsForRepository.countById_PlayerID(id);
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

    @Transactional
    public void deleteAllByPlayerID(int id) throws SpielerNotFoundException {
        playsForRepository.deleteAllById_PlayerID(id);
        spielerRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllByPlayerIDAndFifaVersion(int id, int fifaVersion){
        playsForRepository.deleteAllById_PlayerIDAndId_FifaVersion(id, fifaVersion);
        if(playsForRepository.countById_PlayerID(id)==0){ // Deletes Player record from Spieler Table when no entry left in PlaysFor Table
            spielerRepository.deleteById(id);
        }
    }
    public List<FifaVersion> listFifaVersions(){
        return fifaVersionRepository.findAll();
    }
}
