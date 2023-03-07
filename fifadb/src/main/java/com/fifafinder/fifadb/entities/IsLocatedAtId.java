package com.fifafinder.fifadb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IsLocatedAtId implements Serializable {
    private static final long serialVersionUID = 2182429646813622196L;
    @Column(name = "LeagueID", nullable = false)
    private Integer leagueID;

    @Column(name = "CountryID", nullable = false)
    private Integer countryID;

    public Integer getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(Integer leagueID) {
        this.leagueID = leagueID;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IsLocatedAtId entity = (IsLocatedAtId) o;
        return Objects.equals(this.leagueID, entity.leagueID) &&
                Objects.equals(this.countryID, entity.countryID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueID, countryID);
    }

}