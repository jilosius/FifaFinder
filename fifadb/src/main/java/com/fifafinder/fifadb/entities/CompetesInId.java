package com.fifafinder.fifadb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompetesInId implements Serializable {
    private static final long serialVersionUID = -7942805595577843166L;
    @Column(name = "clubid", nullable = false)
    private Integer clubid;

    @Column(name = "fifa_version", nullable = false)
    private Integer fifaVersion;

    @Column(name = "leagueid", nullable = false)
    private Integer leagueid;

    public Integer getClubid() {
        return clubid;
    }

    public void setClubid(Integer clubid) {
        this.clubid = clubid;
    }

    public Integer getFifaVersion() {
        return fifaVersion;
    }

    public void setFifaVersion(Integer fifaVersion) {
        this.fifaVersion = fifaVersion;
    }

    public Integer getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(Integer leagueid) {
        this.leagueid = leagueid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompetesInId entity = (CompetesInId) o;
        return Objects.equals(this.leagueid, entity.leagueid) &&
                Objects.equals(this.fifaVersion, entity.fifaVersion) &&
                Objects.equals(this.clubid, entity.clubid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueid, fifaVersion, clubid);
    }

}