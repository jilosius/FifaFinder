package com.fifafinder.fifadb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Entity
@SuperBuilder
@JsonInclude(NON_DEFAULT)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "spieler")
public class Spieler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerID", nullable = false)
    private Integer id;

    @Column(name = "FifaID")
    private Integer fifaID;

    @Column(name = "KnownName")
    private String knownName;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "playerID")
    private Set<PlaysFor> playsFors = new LinkedHashSet<>();

    @JsonIgnore
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

    public Integer getFifaID(){
        return fifaID;
    }

    public void setFifaID(Integer fifaID){
        this.fifaID = fifaID;
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