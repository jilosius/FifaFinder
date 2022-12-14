package com.fifafinder.fifadb.repositories;

import com.fifafinder.fifadb.entities.IsFrom;
import com.fifafinder.fifadb.entities.IsFromId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsFromRepository extends JpaRepository<IsFrom, IsFromId> {
}
