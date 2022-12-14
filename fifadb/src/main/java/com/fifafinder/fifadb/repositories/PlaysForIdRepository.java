package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.PlaysForId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaysForIdRepository extends JpaRepository<PlaysForId, Long> {
}
