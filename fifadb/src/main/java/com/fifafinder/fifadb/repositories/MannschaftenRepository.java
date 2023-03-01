package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.Mannschaften;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MannschaftenRepository extends JpaRepository<Mannschaften, Integer> {
    List<Mannschaften> findByOrderByClubNameAsc();


}
