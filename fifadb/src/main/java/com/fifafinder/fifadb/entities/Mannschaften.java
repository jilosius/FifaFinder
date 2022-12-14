package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "mannschaften")
public class Mannschaften {
    @Id
    @Column(name = "ClubID", nullable = false)
    private Integer id;

    @Column(name = "ClubName")
    private String clubName;

    @Column(name = "ClubLogo")
    private String clubLogo;

    @OneToMany(mappedBy = "clubID")
    private Set<PlaysFor> playsFors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "clubID")
    private Set<CompetesIn> competesIns = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }

    public Set<PlaysFor> getPlaysFors() {
        return playsFors;
    }

    public void setPlaysFors(Set<PlaysFor> playsFors) {
        this.playsFors = playsFors;
    }

    public Set<CompetesIn> getCompetesIns() {
        return competesIns;
    }

    public void setCompetesIns(Set<CompetesIn> competesIns) {
        this.competesIns = competesIns;
    }

}