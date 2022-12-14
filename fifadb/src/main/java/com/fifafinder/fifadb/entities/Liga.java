package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "liga")
public class Liga {
    @Id
    @Column(name = "LeagueID", nullable = false)
    private Integer id;

    @Column(name = "League", nullable = false)
    private String league;

    @Column(name = "Logo")
    private String logo;

    @ManyToMany
    @JoinTable(name = "is_located_at",
            joinColumns = @JoinColumn(name = "LeagueID"),
            inverseJoinColumns = @JoinColumn(name = "CountryID"))
    private Set<Land> lands = new LinkedHashSet<>();

    @OneToMany(mappedBy = "leagueID")
    private Set<CompetesIn> competesIns = new LinkedHashSet<>();

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

    public Set<Land> getLands() {
        return lands;
    }

    public void setLands(Set<Land> lands) {
        this.lands = lands;
    }

    public Set<CompetesIn> getCompetesIns() {
        return competesIns;
    }

    public void setCompetesIns(Set<CompetesIn> competesIns) {
        this.competesIns = competesIns;
    }

}