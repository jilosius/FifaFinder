package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.IsLocatedAt;
import com.fifafinder.fifadb.entities.IsLocatedAtId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsLocatedAtRepository extends JpaRepository<IsLocatedAt, IsLocatedAtId> {
}
