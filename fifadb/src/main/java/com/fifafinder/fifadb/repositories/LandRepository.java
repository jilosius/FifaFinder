package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandRepository extends JpaRepository<Land, Integer> {
}
