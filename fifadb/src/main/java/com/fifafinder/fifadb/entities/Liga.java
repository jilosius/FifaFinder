package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "liga")
public class Liga {
    @Id
    @Column(name = "leagueid", nullable = false)
    private Integer id;

    @Column(name = "league", nullable = false)
    private String league;

    @Column(name = "logo")
    private String logo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryid")
    private Land countryid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Land getCountryid() {
        return countryid;
    }

    public void setCountryid(Land countryid) {
        this.countryid = countryid;
    }

}