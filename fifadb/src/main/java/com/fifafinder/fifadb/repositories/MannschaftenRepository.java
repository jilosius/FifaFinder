package com.fifafinder.fifadb.repositories;
import com.fifafinder.fifadb.dto.MannschaftenDto;
import com.fifafinder.fifadb.entities.Mannschaften;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MannschaftenRepository extends JpaRepository<Mannschaften, Integer> {

    Mannschaften findById(int id);
    Mannschaften findMannschaftenByClubName(String clubName);
    List<Mannschaften> findByOrderByClubNameAsc();

    @Query("SELECT NEW com.fifafinder.fifadb.dto.MannschaftenDto(m.id, m.clubName, m.clubLogo, l.league, l.logo, c.countryName, c.flag,ci.overall,ci.attack, ci.midfield, ci.defence) " +
            "FROM Mannschaften m " +
            "JOIN m.competesIns ci " +
            "JOIN ci.leagueID l " +
            "JOIN l.lands c " +
            "WHERE m.id = :id AND ci.fifaVersion = 21")

    MannschaftenDto findMannschaftenWithDetails(@Param("id") Integer id);

}
