package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "spieler")
public class Spieler {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerID", nullable = false)
    private Integer id;

    @Column(name = "KnownName")
    private String knownName;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "playerID")
    private Set<PlaysFor> playsFors = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "is_from",
            joinColumns = @JoinColumn(name = "PlayerID"),
            inverseJoinColumns = @JoinColumn(name = "CountryID"))
    private Set<Land> lands = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKnownName() {
        return knownName;
    }

    public void setKnownName(String knownName) {
        this.knownName = knownName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<PlaysFor> getPlaysFors() {
        return playsFors;
    }

    public void setPlaysFors(Set<PlaysFor> playsFors) {
        this.playsFors = playsFors;
    }

    public Set<Land> getLands() {
        return lands;
    }

    public void setLands(Set<Land> lands) {
        this.lands = lands;
    }

}