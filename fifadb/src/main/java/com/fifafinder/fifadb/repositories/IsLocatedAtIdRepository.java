package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.IsLocatedAtId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsLocatedAtIdRepository extends JpaRepository<IsLocatedAtId, Long> {
}
