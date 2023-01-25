package com.fifafinder.fifadb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "land")
public class Land {
    @Id
    @Column(name = "CountryID", nullable = false)
    private Integer id;

    @Column(name = "CountryName")
    private String countryName;

    @Column(name = "Flag")
    private String flag;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "is_located_at",
            joinColumns = @JoinColumn(name = "CountryID"),
            inverseJoinColumns = @JoinColumn(name = "LeagueID"))
    private Set<Liga> ligas = new LinkedHashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "is_from",
            joinColumns = @JoinColumn(name = "CountryID"),
            inverseJoinColumns = @JoinColumn(name = "PlayerID"))
    private Set<Spieler> spielers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Set<Liga> getLigas() {
        return ligas;
    }

    public void setLigas(Set<Liga> ligas) {
        this.ligas = ligas;
    }

    public Set<Spieler> getSpielers() {
        return spielers;
    }

    public void setSpielers(Set<Spieler> spielers) {
        this.spielers = spielers;
    }

}