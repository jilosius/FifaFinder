package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "fifa_version")
public class FifaVersion {
    @Id
    @Column(name = "FifaVersion", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "fifaVersion")
    private Set<PlaysFor> playsFors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fifaVersion")
    private Set<CompetesIn> competesIns = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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