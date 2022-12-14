package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.Spieler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpielerRepository extends JpaRepository<Spieler, Integer> {
}
