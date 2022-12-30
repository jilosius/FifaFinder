package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
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
}