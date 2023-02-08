package com.fifafinder.fifadb.repositories;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fifafinder.fifadb.DTOs.SpielerDTO;
import com.fifafinder.fifadb.entities.Spieler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;


@Repository
public interface SpielerRepository extends JpaRepository<Spieler, Integer> {
//    Page<SpielerDTO> findByFullNameContaining(String fullName, Pageable pageable);

//     ----- first implementation: not dynamic
//    @Query("SELECT NEW com.fifafinder.fifadb.DTOs.SpielerDTO(pf.photoUrl, s.knownName, pf.age, nat.countryID.flag, pf.clubID.clubLogo, pf.overall, pf.potential, pf.bestPosition, pf.valueEUR, pf.height, pf.weight) " +
//            "FROM Spieler s INNER JOIN PlaysFor pf ON s.id = pf.id.playerID JOIN IsFrom nat ON s.id = nat.id.playerID " +
//            "WHERE pf.id.fifaVersion = 23")
////    AND s.knownName LIKE '%messi%'
//    Page<SpielerDTO> listAllSpieler(Pageable pageable);
//
//     ----- second implementation: with below query we can search for players by Name
//    @Query("SELECT NEW com.fifafinder.fifadb.DTOs.SpielerDTO(pf.photoUrl, s.knownName, pf.age, nat.countryID.flag, pf.clubID.clubLogo, pf.overall, pf.potential, pf.bestPosition, pf.valueEUR, pf.height, pf.weight) " +
//            "FROM Spieler s INNER JOIN PlaysFor pf ON s.id = pf.id.playerID JOIN IsFrom nat ON s.id = nat.id.playerID " +
//            "WHERE pf.id.fifaVersion = 23 AND s.fullName LIKE %:searchTerm%")
//    Page<SpielerDTO> findByFullName(@Param("searchTerm") String searchTerm, Pageable pageable);
//

    //     ----- final implementation: full search algorithm. Search by name, filter by below attributes.

    @Query("SELECT NEW com.fifafinder.fifadb.DTOs.SpielerDTO(pf.id.playerID, pf.photoUrl, s.knownName, pf.age, nat.countryID.flag, pf.clubID.clubLogo, pf.overall, pf.potential, pf.bestPosition, pf.valueEUR, pf.height, pf.weight,pf.preferredFoot,pf.headingAccuracy,pf.volleys,pf.dribbling, pf.curve,pf.fkAccuracy,pf.acceleration,pf.sprintSpeed,pf.agility,pf.reaction,pf.balance,pf.shotPower,pf.jumping,pf.stamina,pf.aggression,pf.longShots,pf.crossing,pf.finishing,pf.shortPassing,pf.wage) " +
            "FROM Spieler s INNER JOIN PlaysFor pf ON s.id = pf.id.playerID JOIN IsFrom nat ON s.id = nat.id.playerID " +
            "WHERE pf.id.fifaVersion = :fifaVersion " +
            "AND (s.fullName LIKE %:searchTerm% " +
            "AND pf.age >= :minAge AND pf.age <= :maxAge " +
            "AND pf.overall >= :minOverall AND pf.overall <= :maxOverall " +
            "AND pf.preferredFoot LIKE %:preferredFoot% " +
            "AND pf.potential >= :minPotential AND pf.potential <= :maxPotential " +
            "AND pf.height >= :minHeight AND pf.height <= :maxHeight " +
            "AND pf.valueEUR >= :minValue AND pf.valueEUR <= :maxValue " +
            "AND pf.wage >= :minWage AND pf.wage <= :maxWage " +
            "AND pf.headingAccuracy >= :minHeadingAccuracy AND pf.headingAccuracy <= :maxHeadingAccuracy " +
            "AND pf.volleys >= :minVolleys AND pf.volleys <= :maxVolleys " +
            "AND pf.dribbling >= :minDribbling AND pf.dribbling <= :maxDribbling " +
            "AND pf.curve >= :minCurve AND pf.curve <= :maxCurve " +
            "AND pf.fkAccuracy >= :minFkAccuracy AND pf.fkAccuracy <= :maxFkAccuracy " +
            "AND pf.acceleration >= :minAcceleration AND pf.acceleration <= :maxAcceleration " +
            "AND pf.sprintSpeed >= :minSprintSpeed AND pf.sprintSpeed <= :maxSprintSpeed " +
            "AND pf.agility >= :minAgility AND pf.agility <= :maxAgility " +
            "AND pf.reaction >= :minReaction AND pf.reaction <= :maxReaction " +
            "AND pf.balance >= :minBalance AND pf.balance <= :maxBalance " +
            "AND pf.shotPower >= :minShotPower AND pf.shotPower <= :maxShotPower " +
            "AND pf.jumping >= :minJumping AND pf.jumping <= :maxJumping " +
            "AND pf.stamina >= :minStamina AND pf.stamina <= :maxStamina " +
            "AND pf.aggression >= :minAggression AND pf.aggression <= :maxAggression " +
            "AND pf.longShots >= :minLongShots AND pf.longShots <= :maxLongShots " +
            "AND pf.crossing >= :minCrossing AND pf.crossing <= :maxCrossing " +
            "AND pf.finishing >= :minFinishing AND pf.finishing <= :maxFinishing " +
            "AND pf.shortPassing >= :minShortPassing AND pf.shortPassing <= :maxShortPassing)"
    )


    //applying filter
    Page<SpielerDTO> findByFullNameFiltered(@Param("searchTerm") String searchTerm,
                                            @Param("fifaVersion") int fifaVersion,
                                            @Param("preferredFoot") String preferredFoot,
                                            @Param("minAge") int minAge,
                                            @Param("maxAge") int maxAge,
                                            @Param("minOverall") int minOverall,
                                            @Param("maxOverall") int maxOverall,
                                            @Param("minPotential") int minPotential,
                                            @Param("maxPotential") int maxPotential,
                                            @Param("minHeight") int minHeight,
                                            @Param("maxHeight") int maxHeight,
                                            @Param("minValue") long minValue,
                                            @Param("maxValue") long maxValue,
                                            @Param("minWage") long minWage,
                                            @Param("maxWage") long maxWage,
                                            @Param("minHeadingAccuracy") int minHeadingAccuracy,
                                            @Param("maxHeadingAccuracy") int maxHeadingAccuracy,
                                            @Param("minVolleys") int minVolleys,
                                            @Param("maxVolleys") int maxVolleys,
                                            @Param("minDribbling") int minDribbling,
                                            @Param("maxDribbling") int maxDribbling,
                                            @Param("minCurve") int minCurve,
                                            @Param("maxCurve") int maxCurve,
                                            @Param("minFkAccuracy") int minFkAccuracy,
                                            @Param("maxFkAccuracy") int maxFkAccuracy,
                                            @Param("minAcceleration") int minAcceleration,
                                            @Param("maxAcceleration") int maxAcceleration,
                                            @Param("minSprintSpeed") int minSprintSpeed,
                                            @Param("maxSprintSpeed") int maxSprintSpeed,
                                            @Param("minAgility") int minAgility,
                                            @Param("maxAgility") int maxAgility,
                                            @Param("minReaction") int minReaction,
                                            @Param("maxReaction") int maxReaction,
                                            @Param("minBalance") int minBalance,
                                            @Param("maxBalance") int maxBalance,
                                            @Param("minShotPower") int minShotPower,
                                            @Param("maxShotPower") int maxShotPower,
                                            @Param("minJumping") int minJumping,
                                            @Param("maxJumping") int maxJumping,
                                            @Param("minStamina") int minStamina,
                                            @Param("maxStamina") int maxStamina,
                                            @Param("minAggression") int minAggression,
                                            @Param("maxAggression") int maxAggression,
                                            @Param("minLongShots") int minLongShots,
                                            @Param("maxLongShots") int maxLongShots,
                                            @Param("minCrossing") int minCrossing,
                                            @Param("maxCrossing") int maxCrossing,
                                            @Param("minFinishing") int minFinishing,
                                            @Param("maxFinishing") int maxFinishing,
                                            @Param("minShortPassing") int minShortPassing,
                                            @Param("maxShortPassing") int maxShortPassing,
                                            Pageable pageable);

    @Query("SELECT NEW com.fifafinder.fifadb.DTOs.SpielerDTO(pf.id.playerID,pf.photoUrl, s.knownName, pf.age, nat.countryID.flag, pf.clubID.clubLogo, pf.overall, pf.potential, pf.bestPosition, pf.valueEUR, pf.height, pf.weight,pf.preferredFoot,pf.headingAccuracy,pf.volleys,pf.dribbling, pf.curve,pf.fkAccuracy,pf.acceleration,pf.sprintSpeed,pf.agility,pf.reaction,pf.balance,pf.shotPower,pf.jumping,pf.stamina,pf.aggression,pf.longShots,pf.crossing,pf.finishing,pf.shortPassing,pf.wage) " +
            "FROM Spieler s INNER JOIN PlaysFor pf ON s.id = pf.id.playerID JOIN IsFrom nat ON s.id = nat.id.playerID " +
            "WHERE pf.id.fifaVersion = :fifaVersion " +
            "AND (pf.id.playerID = :player1Id OR pf.id.playerID = :player2Id  OR pf.id.playerID = :player3Id OR pf.id.playerID = :player4Id OR pf.id.playerID = :player5Id)")
    List<SpielerDTO> getSpielerToCompare(@Param("player1Id") int player1Id,
                                         @Param("player2Id") int player2Id,
                                         @Param("player3Id") int player3Id,
                                         @Param("player4Id") int player4Id,
                                         @Param("player5Id") int player5Id,
                                         @Param("fifaVersion") int fifaVersion);





    Spieler findById(int id);
    Spieler findSpielerByFullName(String fullName);

}
