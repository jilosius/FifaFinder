package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.Spieler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface SpielerRepository extends JpaRepository<Spieler, Integer> {
    /*
    Optional<Spieler> findSpielerById(Integer id);

    Optional<Spieler> findSpielerByfullname(String n);

    void deleteSpielerById(Integer id);
     */

}
