package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "is_located_at")
public class IsLocatedAt {
    @EmbeddedId
    private IsLocatedAtId id;

    @MapsId("countryid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "countryid", nullable = false)
    private Land countryid;

    @MapsId("leagueid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "leagueid", nullable = false)
    private Liga leagueid;

    public IsLocatedAtId getId() {
        return id;
    }

    public void setId(IsLocatedAtId id) {
        this.id = id;
    }

    public Land getCountryid() {
        return countryid;
    }

    public void setCountryid(Land countryid) {
        this.countryid = countryid;
    }

    public Liga getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(Liga leagueid) {
        this.leagueid = leagueid;
    }

}