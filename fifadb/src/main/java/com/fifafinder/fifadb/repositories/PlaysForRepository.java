package com.fifafinder.fifadb.repositories;

import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;
import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.entities.PlaysFor;
import com.fifafinder.fifadb.entities.PlaysForId;
import com.fifafinder.fifadb.entities.Spieler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaysForRepository extends JpaRepository<PlaysFor, PlaysForId> {
    List<PlaysFor> findByFifaVersion(FifaVersion fifaVersion);

    SpielerDetailDTO findById(PlaysFor id);
    PlaysFor findByPlayerIDAndFifaVersion(Spieler spieler, FifaVersion fifaVersion);
    PlaysFor findPlaysForById(PlaysForId playsForId);
}
