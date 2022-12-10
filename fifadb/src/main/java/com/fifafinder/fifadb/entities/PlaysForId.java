package com.fifafinder.fifadb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlaysForId implements Serializable {
    private static final long serialVersionUID = -441280368442777541L;
    @Column(name = "fifa_version", nullable = false)
    private Integer fifaVersion;

    @Column(name = "playerid", nullable = false)
    private Integer playerid;

    public Integer getFifaVersion() {
        return fifaVersion;
    }

    public void setFifaVersion(Integer fifaVersion) {
        this.fifaVersion = fifaVersion;
    }

    public Integer getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Integer playerid) {
        this.playerid = playerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlaysForId entity = (PlaysForId) o;
        return Objects.equals(this.fifaVersion, entity.fifaVersion) &&
                Objects.equals(this.playerid, entity.playerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fifaVersion, playerid);
    }

}