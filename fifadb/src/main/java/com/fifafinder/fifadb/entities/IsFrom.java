package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "is_from")
public class IsFrom {
    @EmbeddedId
    private IsFromId id;

    @MapsId("countryid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "countryid", nullable = false)
    private Land countryid;

    @MapsId("playerid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playerid", nullable = false)
    private Spieler playerid;

    public IsFromId getId() {
        return id;
    }

    public void setId(IsFromId id) {
        this.id = id;
    }

    public Land getCountryid() {
        return countryid;
    }

    public void setCountryid(Land countryid) {
        this.countryid = countryid;
    }

    public Spieler getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Spieler playerid) {
        this.playerid = playerid;
    }

}