package com.fifafinder.fifadb.repositories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fifafinder.fifadb.entities.Spieler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SpielerRepository extends JpaRepository<Spieler, Integer> {
    Page<Spieler> findByFullNameContaining(String fullName, Pageable pageable);




    Optional<Spieler> findSpielerByfullname(String n);

    Spieler findById(int id);
    Spieler findSpielerByFullName(String fullName);
}
