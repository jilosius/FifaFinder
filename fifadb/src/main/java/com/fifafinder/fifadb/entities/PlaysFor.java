package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plays_for")
public class PlaysFor {
    @EmbeddedId
    private PlaysForId id;

    @MapsId("playerID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PlayerID", nullable = false)
    private Spieler playerID;

    @MapsId("fifaVersion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FifaVersion", nullable = false)
    private FifaVersion fifaVersion;

    @Column(name = "Height")
    private Integer height;

    @Column(name = "ClubPosition")
    private String clubPosition;

    @Column(name = "ClubNumber")
    private Integer clubNumber;

    @Column(name = "NationalPosition")
    private String nationalPosition;

    @Column(name = "NationalNumber")
    private Integer nationalNumber;

    @Column(name = "PreferredFoot")
    private String preferredFoot;

    @Column(name = "ContractUntil")
    private Integer contractUntil;

    @Column(name = "OnLoan", length = 15)
    private String onLoan;

    @Column(name = "NationalTeam")
    private String nationalTeam;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Weight")
    private Integer weight;

    @Column(name = "Overall")
    private Integer overall;

    @Column(name = "Potential")
    private Integer potential;

    @Column(name = "BestPosition")
    private String bestPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClubID")
    private Mannschaften clubID;

    @Column(name = "ValueEUR")
    private Long valueEUR;

    @Column(name = "Wage")
    private Long wage;

    @Column(name = "ReleaseClause")
    private Long releaseClause;

    @Column(name = "IntReputation")
    private Integer intReputation;

    @Column(name = "WeakFoot")
    private Integer weakFoot;

    @Column(name = "SkillMoves")
    private Integer skillMoves;

    @Column(name = "Cossing")
    private Integer cossing;

    @Column(name = "Finishing")
    private Integer finishing;

    @Column(name = "HeadingAccuracy")
    private Integer headingAccuracy;

    @Column(name = "ShortPassing")
    private Integer shortPassing;

    @Column(name = "Volleys")
    private Integer volleys;

    @Column(name = "Dribbling")
    private Integer dribbling;

    @Column(name = "Curve")
    private Integer curve;

    @Column(name = "FKAccuracy")
    private Integer fKAccuracy;

    @Column(name = "LongPassing")
    private Integer longPassing;

    @Column(name = "BallControl")
    private Integer ballControl;

    @Column(name = "Acceleration")
    private Integer acceleration;

    @Column(name = "SprintSpeed")
    private Integer sprintSpeed;

    @Column(name = "Agility")
    private Integer agility;

    @Column(name = "Reaction")
    private Integer reaction;

    @Column(name = "Balance")
    private Integer balance;

    @Column(name = "ShotPower")
    private Integer shotPower;

    @Column(name = "Jumping")
    private Integer jumping;

    @Column(name = "Stamina")
    private Integer stamina;

    @Column(name = "Strength")
    private Integer strength;

    @Column(name = "LongShots")
    private Integer longShots;

    @Column(name = "Aggression")
    private Integer aggression;

    @Column(name = "Interceptions")
    private Integer interceptions;

    @Column(name = "Positioning")
    private Integer positioning;

    @Column(name = "Vision")
    private Integer vision;

    @Column(name = "Penalties")
    private Integer penalties;

    @Column(name = "Composure")
    private Integer composure;

    @Column(name = "Marking")
    private Integer marking;

    @Column(name = "StandingTackle")
    private Integer standingTackle;

    @Column(name = "SlidingTackle")
    private Integer slidingTackle;

    @Column(name = "GKDiving")
    private Integer gKDiving;

    @Column(name = "GKHandling")
    private Integer gKHandling;

    @Column(name = "GKKicking")
    private Integer gKKicking;

    @Column(name = "GKPositioning")
    private Integer gKPositioning;

    @Column(name = "GKReflexes")
    private Integer gKReflexes;

    @Column(name = "PhotoUrl")
    private String photoUrl;

    public PlaysForId getId() {
        return id;
    }

    public void setId(PlaysForId id) {
        this.id = id;
    }

    public Spieler getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Spieler playerID) {
        this.playerID = playerID;
    }

    public FifaVersion getFifaVersion() {
        return fifaVersion;
    }

    public void setFifaVersion(FifaVersion fifaVersion) {
        this.fifaVersion = fifaVersion;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getClubPosition() {
        return clubPosition;
    }

    public void setClubPosition(String clubPosition) {
        this.clubPosition = clubPosition;
    }

    public Integer getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(Integer clubNumber) {
        this.clubNumber = clubNumber;
    }

    public String getNationalPosition() {
        return nationalPosition;
    }

    public void setNationalPosition(String nationalPosition) {
        this.nationalPosition = nationalPosition;
    }

    public Integer getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(Integer nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getPreferredFoot() {
        return preferredFoot;
    }

    public void setPreferredFoot(String preferredFoot) {
        this.preferredFoot = preferredFoot;
    }

    public Integer getContractUntil() {
        return contractUntil;
    }

    public void setContractUntil(Integer contractUntil) {
        this.contractUntil = contractUntil;
    }

    public String getOnLoan() {
        return onLoan;
    }

    public void setOnLoan(String onLoan) {
        this.onLoan = onLoan;
    }

    public String getNationalTeam() {
        return nationalTeam;
    }

    public void setNationalTeam(String nationalTeam) {
        this.nationalTeam = nationalTeam;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getOverall() {
        return overall;
    }

    public void setOverall(Integer overall) {
        this.overall = overall;
    }

    public Integer getPotential() {
        return potential;
    }

    public void setPotential(Integer potential) {
        this.potential = potential;
    }

    public String getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(String bestPosition) {
        this.bestPosition = bestPosition;
    }

    public Mannschaften getClubID() {
        return clubID;
    }

    public void setClubID(Mannschaften clubID) {
        this.clubID = clubID;
    }

    public Long getValueEUR() {
        return valueEUR;
    }

    public void setValueEUR(Long valueEUR) {
        this.valueEUR = valueEUR;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    public Long getReleaseClause() {
        return releaseClause;
    }

    public void setReleaseClause(Long releaseClause) {
        this.releaseClause = releaseClause;
    }

    public Integer getIntReputation() {
        return intReputation;
    }

    public void setIntReputation(Integer intReputation) {
        this.intReputation = intReputation;
    }

    public Integer getWeakFoot() {
        return weakFoot;
    }

    public void setWeakFoot(Integer weakFoot) {
        this.weakFoot = weakFoot;
    }

    public Integer getSkillMoves() {
        return skillMoves;
    }

    public void setSkillMoves(Integer skillMoves) {
        this.skillMoves = skillMoves;
    }

    public Integer getCossing() {
        return cossing;
    }

    public void setCossing(Integer cossing) {
        this.cossing = cossing;
    }

    public Integer getFinishing() {
        return finishing;
    }

    public void setFinishing(Integer finishing) {
        this.finishing = finishing;
    }

    public Integer getHeadingAccuracy() {
        return headingAccuracy;
    }

    public void setHeadingAccuracy(Integer headingAccuracy) {
        this.headingAccuracy = headingAccuracy;
    }

    public Integer getShortPassing() {
        return shortPassing;
    }

    public void setShortPassing(Integer shortPassing) {
        this.shortPassing = shortPassing;
    }

    public Integer getVolleys() {
        return volleys;
    }

    public void setVolleys(Integer volleys) {
        this.volleys = volleys;
    }

    public Integer getDribbling() {
        return dribbling;
    }

    public void setDribbling(Integer dribbling) {
        this.dribbling = dribbling;
    }

    public Integer getCurve() {
        return curve;
    }

    public void setCurve(Integer curve) {
        this.curve = curve;
    }

    public Integer getFKAccuracy() {
        return fKAccuracy;
    }

    public void setFKAccuracy(Integer fKAccuracy) {
        this.fKAccuracy = fKAccuracy;
    }

    public Integer getLongPassing() {
        return longPassing;
    }

    public void setLongPassing(Integer longPassing) {
        this.longPassing = longPassing;
    }

    public Integer getBallControl() {
        return ballControl;
    }

    public void setBallControl(Integer ballControl) {
        this.ballControl = ballControl;
    }

    public Integer getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Integer acceleration) {
        this.acceleration = acceleration;
    }

    public Integer getSprintSpeed() {
        return sprintSpeed;
    }

    public void setSprintSpeed(Integer sprintSpeed) {
        this.sprintSpeed = sprintSpeed;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getReaction() {
        return reaction;
    }

    public void setReaction(Integer reaction) {
        this.reaction = reaction;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getShotPower() {
        return shotPower;
    }

    public void setShotPower(Integer shotPower) {
        this.shotPower = shotPower;
    }

    public Integer getJumping() {
        return jumping;
    }

    public void setJumping(Integer jumping) {
        this.jumping = jumping;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getLongShots() {
        return longShots;
    }

    public void setLongShots(Integer longShots) {
        this.longShots = longShots;
    }

    public Integer getAggression() {
        return aggression;
    }

    public void setAggression(Integer aggression) {
        this.aggression = aggression;
    }

    public Integer getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(Integer interceptions) {
        this.interceptions = interceptions;
    }

    public Integer getPositioning() {
        return positioning;
    }

    public void setPositioning(Integer positioning) {
        this.positioning = positioning;
    }

    public Integer getVision() {
        return vision;
    }

    public void setVision(Integer vision) {
        this.vision = vision;
    }

    public Integer getPenalties() {
        return penalties;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }

    public Integer getComposure() {
        return composure;
    }

    public void setComposure(Integer composure) {
        this.composure = composure;
    }

    public Integer getMarking() {
        return marking;
    }

    public void setMarking(Integer marking) {
        this.marking = marking;
    }

    public Integer getStandingTackle() {
        return standingTackle;
    }

    public void setStandingTackle(Integer standingTackle) {
        this.standingTackle = standingTackle;
    }

    public Integer getSlidingTackle() {
        return slidingTackle;
    }

    public void setSlidingTackle(Integer slidingTackle) {
        this.slidingTackle = slidingTackle;
    }

    public Integer getGKDiving() {
        return gKDiving;
    }

    public void setGKDiving(Integer gKDiving) {
        this.gKDiving = gKDiving;
    }

    public Integer getGKHandling() {
        return gKHandling;
    }

    public void setGKHandling(Integer gKHandling) {
        this.gKHandling = gKHandling;
    }

    public Integer getGKKicking() {
        return gKKicking;
    }

    public void setGKKicking(Integer gKKicking) {
        this.gKKicking = gKKicking;
    }

    public Integer getGKPositioning() {
        return gKPositioning;
    }

    public void setGKPositioning(Integer gKPositioning) {
        this.gKPositioning = gKPositioning;
    }

    public Integer getGKReflexes() {
        return gKReflexes;
    }

    public void setGKReflexes(Integer gKReflexes) {
        this.gKReflexes = gKReflexes;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}