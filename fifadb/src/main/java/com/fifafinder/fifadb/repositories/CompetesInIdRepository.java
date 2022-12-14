package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.CompetesInId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetesInIdRepository extends JpaRepository<CompetesInId, Long> {
}
