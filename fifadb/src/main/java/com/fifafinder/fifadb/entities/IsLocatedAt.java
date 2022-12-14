package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "is_located_at")
public class IsLocatedAt {
    @EmbeddedId
    private IsLocatedAtId id;

    @MapsId("leagueID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LeagueID", nullable = false)
    private Liga leagueID;

    @MapsId("countryID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CountryID", nullable = false)
    private Land countryID;

    public IsLocatedAtId getId() {
        return id;
    }

    public void setId(IsLocatedAtId id) {
        this.id = id;
    }

    public Liga getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(Liga leagueID) {
        this.leagueID = leagueID;
    }

    public Land getCountryID() {
        return countryID;
    }

    public void setCountryID(Land countryID) {
        this.countryID = countryID;
    }

}