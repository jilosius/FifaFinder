package com.fifafinder.fifadb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompetesInId implements Serializable {
    private static final long serialVersionUID = 733796807269109658L;
    @Column(name = "ClubID", nullable = false)
    private Integer clubID;

    @Column(name = "FifaVersion", nullable = false)
    private Integer fifaVersion;

    @Column(name = "LeagueID", nullable = false)
    private Integer leagueID;

    public Integer getClubID() {
        return clubID;
    }

    public void setClubID(Integer clubID) {
        this.clubID = clubID;
    }

    public Integer getFifaVersion() {
        return fifaVersion;
    }

    public void setFifaVersion(Integer fifaVersion) {
        this.fifaVersion = fifaVersion;
    }

    public Integer getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(Integer leagueID) {
        this.leagueID = leagueID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompetesInId entity = (CompetesInId) o;
        return Objects.equals(this.leagueID, entity.leagueID) &&
                Objects.equals(this.fifaVersion, entity.fifaVersion) &&
                Objects.equals(this.clubID, entity.clubID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueID, fifaVersion, clubID);
    }

}