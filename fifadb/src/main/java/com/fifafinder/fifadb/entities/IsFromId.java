package com.fifafinder.fifadb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IsFromId implements Serializable {
    private static final long serialVersionUID = 7059235540538173751L;
    @Column(name = "countryid", nullable = false)
    private Integer countryid;

    @Column(name = "playerid", nullable = false)
    private Integer playerid;

    public Integer getCountryid() {
        return countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
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
        IsFromId entity = (IsFromId) o;
        return Objects.equals(this.countryid, entity.countryid) &&
                Objects.equals(this.playerid, entity.playerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryid, playerid);
    }

}