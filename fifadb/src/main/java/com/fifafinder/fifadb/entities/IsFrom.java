package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "is_from")
public class IsFrom {
    @EmbeddedId
    private IsFromId id;

    @MapsId("playerID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PlayerID", nullable = false)
    private Spieler playerID;

    @MapsId("countryID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CountryID", nullable = false)
    private Land countryID;

    public IsFromId getId() {
        return id;
    }

    public void setId(IsFromId id) {
        this.id = id;
    }

    public Spieler getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Spieler playerID) {
        this.playerID = playerID;
    }

    public Land getCountryID() {
        return countryID;
    }

    public void setCountryID(Land countryID) {
        this.countryID = countryID;
    }

}