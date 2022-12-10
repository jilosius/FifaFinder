package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "competes_in")
public class CompetesIn {
    @EmbeddedId
    private CompetesInId id;

    @MapsId("clubid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clubid", nullable = false)
    private Mannschaften clubid;

    @MapsId("leagueid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "leagueid", nullable = false)
    private Liga leagueid;

    @Column(name = "attack")
    private Integer attack;

    @Column(name = "defence")
    private Integer defence;

    @Column(name = "midfield")
    private Integer midfield;

    @Column(name = "overall")
    private Integer overall;

    public CompetesInId getId() {
        return id;
    }

    public void setId(CompetesInId id) {
        this.id = id;
    }

    public Mannschaften getClubid() {
        return clubid;
    }

    public void setClubid(Mannschaften clubid) {
        this.clubid = clubid;
    }

    public Liga getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(Liga leagueid) {
        this.leagueid = leagueid;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getMidfield() {
        return midfield;
    }

    public void setMidfield(Integer midfield) {
        this.midfield = midfield;
    }

    public Integer getOverall() {
        return overall;
    }

    public void setOverall(Integer overall) {
        this.overall = overall;
    }

}