package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.FifaVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FifaVersionRepository extends JpaRepository<FifaVersion, Integer> {
}
