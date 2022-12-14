package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "competes_in")
public class CompetesIn {
    @EmbeddedId
    private CompetesInId id;

    @MapsId("clubID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ClubID", nullable = false)
    private Mannschaften clubID;

    @MapsId("fifaVersion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FifaVersion", nullable = false)
    private FifaVersion fifaVersion;

    @MapsId("leagueID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LeagueID", nullable = false)
    private Liga leagueID;

    @Column(name = "Overall")
    private Integer overall;

    @Column(name = "Attack")
    private Integer attack;

    @Column(name = "Midfield")
    private Integer midfield;

    @Column(name = "Defence")
    private Integer defence;

    public CompetesInId getId() {
        return id;
    }

    public void setId(CompetesInId id) {
        this.id = id;
    }

    public Mannschaften getClubID() {
        return clubID;
    }

    public void setClubID(Mannschaften clubID) {
        this.clubID = clubID;
    }

    public FifaVersion getFifaVersion() {
        return fifaVersion;
    }

    public void setFifaVersion(FifaVersion fifaVersion) {
        this.fifaVersion = fifaVersion;
    }

    public Liga getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(Liga leagueID) {
        this.leagueID = leagueID;
    }

    public Integer getOverall() {
        return overall;
    }

    public void setOverall(Integer overall) {
        this.overall = overall;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getMidfield() {
        return midfield;
    }

    public void setMidfield(Integer midfield) {
        this.midfield = midfield;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

}