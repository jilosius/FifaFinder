package com.fifafinder.fifadb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PlaysForId implements Serializable {
    private static final long serialVersionUID = -3970872167199362146L;
    @Column(name = "PlayerID", nullable = false)
    private Integer playerID;

    @Column(name = "FifaVersion", nullable = false)
    private Integer fifaVersion;

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public Integer getFifaVersion() {
        return fifaVersion;
    }

    public void setFifaVersion(Integer fifaVersion) {
        this.fifaVersion = fifaVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlaysForId entity = (PlaysForId) o;
        return Objects.equals(this.fifaVersion, entity.fifaVersion) &&
                Objects.equals(this.playerID, entity.playerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fifaVersion, playerID);
    }

}