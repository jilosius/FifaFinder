package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.exceptionhandling.SpielerNotFoundException;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


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

    public Page<Spieler> getSpieler(String name, int page, int size) {
        log.info("Fetching spieler for page {} of size {}", page, size);
        return spielerRepository.findByFullNameContaining(name, PageRequest.of(page, size));
    }

    /*
        public Spieler addSpieler (Spieler spieler){

            return spielerRepository.save(spieler);

        }

        public List<Spieler> findAllSpieler(){

            return spielerRepository.findAll();

        }

        public Spieler updateSpieler(Spieler spieler){

            return spielerRepository.save(spieler);

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