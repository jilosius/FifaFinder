package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.PlaysFor;
import com.fifafinder.fifadb.entities.PlaysForId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaysForRepository extends JpaRepository<PlaysFor, PlaysForId> {

    PlaysFor findPlaysForById(PlaysForId playsForId);
    void deleteAllById_PlayerID(int id);
    void deleteAllById_PlayerIDAndId_FifaVersion(int id, int fifaVersion);
    int countById_PlayerID(int id);
}
