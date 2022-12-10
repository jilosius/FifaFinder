package com.fifafinder.fifadb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

}