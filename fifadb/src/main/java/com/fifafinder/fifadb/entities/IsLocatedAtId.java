package com.fifafinder.fifadb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IsLocatedAtId implements Serializable {
    private static final long serialVersionUID = 5315026721526866867L;
    @Column(name = "countryid", nullable = false)
    private Integer countryid;

    @Column(name = "leagueid", nullable = false)
    private Integer leagueid;

    public Integer getCountryid() {
        return countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
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
        IsLocatedAtId entity = (IsLocatedAtId) o;
        return Objects.equals(this.leagueid, entity.leagueid) &&
                Objects.equals(this.countryid, entity.countryid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueid, countryid);
    }

}