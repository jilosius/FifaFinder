package com.fifafinder.fifadb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IsFromId implements Serializable {
    private static final long serialVersionUID = 146572966704438802L;
    @Column(name = "PlayerID", nullable = false)
    private Integer playerID;

    @Column(name = "CountryID", nullable = false)
    private Integer countryID;

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
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
        IsFromId entity = (IsFromId) o;
        return Objects.equals(this.countryID, entity.countryID) &&
                Objects.equals(this.playerID, entity.playerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryID, playerID);
    }

}