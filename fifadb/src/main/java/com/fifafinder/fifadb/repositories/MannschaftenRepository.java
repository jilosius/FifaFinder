package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.Mannschaften;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MannschaftenRepository extends JpaRepository<Mannschaften, Integer> {

    Mannschaften findById(int id);
    Mannschaften findMannschaftenByClubName(String clubName);
}
