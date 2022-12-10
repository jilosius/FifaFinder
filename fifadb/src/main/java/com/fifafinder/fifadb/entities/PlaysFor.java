package com.fifafinder.fifadb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plays_for")
public class PlaysFor {
    @EmbeddedId
    private PlaysForId id;

    @MapsId("playerid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playerid", nullable = false)
    private Spieler playerid;

    @Column(name = "acceleration")
    private Integer acceleration;

    @Column(name = "age")
    private Integer age;

    @Column(name = "aggression")
    private Integer aggression;

    @Column(name = "agility")
    private Integer agility;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "ball_control")
    private Integer ballControl;

    @Column(name = "best_position")
    private String bestPosition;

    @Column(name = "club_number")
    private Integer clubNumber;

    @Column(name = "club_position")
    private String clubPosition;

    @Column(name = "composure")
    private Integer composure;

    @Column(name = "contract_until")
    private Integer contractUntil;

    @Column(name = "cossing")
    private Integer cossing;

    @Column(name = "curve")
    private Integer curve;

    @Column(name = "dribbling")
    private Integer dribbling;

    @Column(name = "fkaccuracy")
    private Integer fkaccuracy;

    @Column(name = "finishing")
    private Integer finishing;

    @Column(name = "gkdiving")
    private Integer gkdiving;

    @Column(name = "gkhandling")
    private Integer gkhandling;

    @Column(name = "gkkicking")
    private Integer gkkicking;

    @Column(name = "gkpositioning")
    private Integer gkpositioning;

    @Column(name = "gkreflexes")
    private Integer gkreflexes;

    @Column(name = "heading_accuracy")
    private Integer headingAccuracy;

    @Column(name = "height")
    private Integer height;

    @Column(name = "int_reputation")
    private Integer intReputation;

    @Column(name = "interceptions")
    private Integer interceptions;

    @Column(name = "jumping")
    private Integer jumping;

    @Column(name = "long_passing")
    private Integer longPassing;

    @Column(name = "long_shots")
    private Integer longShots;

    @Column(name = "marking")
    private Integer marking;

    @Column(name = "national_number")
    private Integer nationalNumber;

    @Column(name = "national_position")
    private String nationalPosition;

    @Column(name = "national_team")
    private String nationalTeam;

    @Column(name = "on_loan", length = 15)
    private String onLoan;

    @Column(name = "overall")
    private Integer overall;

    @Column(name = "penalties")
    private Integer penalties;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "positioning")
    private Integer positioning;

    @Column(name = "potential")
    private Integer potential;

    @Column(name = "preferred_foot")
    private String preferredFoot;

    @Column(name = "reaction")
    private Integer reaction;

    @Column(name = "release_clause")
    private Long releaseClause;

    @Column(name = "short_passing")
    private Integer shortPassing;

    @Column(name = "shot_power")
    private Integer shotPower;

    @Column(name = "skill_moves")
    private Integer skillMoves;

    @Column(name = "sliding_tackle")
    private Integer slidingTackle;

    @Column(name = "sprint_speed")
    private Integer sprintSpeed;

    @Column(name = "stamina")
    private Integer stamina;

    @Column(name = "standing_tackle")
    private Integer standingTackle;

    @Column(name = "strength")
    private Integer strength;

    @Column(name = "valueeur")
    private Long valueeur;

    @Column(name = "vision")
    private Integer vision;

    @Column(name = "volleys")
    private Integer volleys;

    @Column(name = "wage")
    private Long wage;

    @Column(name = "weak_foot")
    private Integer weakFoot;

    @Column(name = "weight")
    private Integer weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clubid")
    private Mannschaften clubid;

    public PlaysForId getId() {
        return id;
    }

    public void setId(PlaysForId id) {
        this.id = id;
    }

    public Spieler getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Spieler playerid) {
        this.playerid = playerid;
    }

    public Integer getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Integer acceleration) {
        this.acceleration = acceleration;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAggression() {
        return aggression;
    }

    public void setAggression(Integer aggression) {
        this.aggression = aggression;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getBallControl() {
        return ballControl;
    }

    public void setBallControl(Integer ballControl) {
        this.ballControl = ballControl;
    }

    public String getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(String bestPosition) {
        this.bestPosition = bestPosition;
    }

    public Integer getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(Integer clubNumber) {
        this.clubNumber = clubNumber;
    }

    public String getClubPosition() {
        return clubPosition;
    }

    public void setClubPosition(String clubPosition) {
        this.clubPosition = clubPosition;
    }

    public Integer getComposure() {
        return composure;
    }

    public void setComposure(Integer composure) {
        this.composure = composure;
    }

    public Integer getContractUntil() {
        return contractUntil;
    }

    public void setContractUntil(Integer contractUntil) {
        this.contractUntil = contractUntil;
    }

    public Integer getCossing() {
        return cossing;
    }

    public void setCossing(Integer cossing) {
        this.cossing = cossing;
    }

    public Integer getCurve() {
        return curve;
    }

    public void setCurve(Integer curve) {
        this.curve = curve;
    }

    public Integer getDribbling() {
        return dribbling;
    }

    public void setDribbling(Integer dribbling) {
        this.dribbling = dribbling;
    }

    public Integer getFkaccuracy() {
        return fkaccuracy;
    }

    public void setFkaccuracy(Integer fkaccuracy) {
        this.fkaccuracy = fkaccuracy;
    }

    public Integer getFinishing() {
        return finishing;
    }

    public void setFinishing(Integer finishing) {
        this.finishing = finishing;
    }

    public Integer getGkdiving() {
        return gkdiving;
    }

    public void setGkdiving(Integer gkdiving) {
        this.gkdiving = gkdiving;
    }

    public Integer getGkhandling() {
        return gkhandling;
    }

    public void setGkhandling(Integer gkhandling) {
        this.gkhandling = gkhandling;
    }

    public Integer getGkkicking() {
        return gkkicking;
    }

    public void setGkkicking(Integer gkkicking) {
        this.gkkicking = gkkicking;
    }

    public Integer getGkpositioning() {
        return gkpositioning;
    }

    public void setGkpositioning(Integer gkpositioning) {
        this.gkpositioning = gkpositioning;
    }

    public Integer getGkreflexes() {
        return gkreflexes;
    }

    public void setGkreflexes(Integer gkreflexes) {
        this.gkreflexes = gkreflexes;
    }

    public Integer getHeadingAccuracy() {
        return headingAccuracy;
    }

    public void setHeadingAccuracy(Integer headingAccuracy) {
        this.headingAccuracy = headingAccuracy;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getIntReputation() {
        return intReputation;
    }

    public void setIntReputation(Integer intReputation) {
        this.intReputation = intReputation;
    }

    public Integer getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(Integer interceptions) {
        this.interceptions = interceptions;
    }

    public Integer getJumping() {
        return jumping;
    }

    public void setJumping(Integer jumping) {
        this.jumping = jumping;
    }

    public Integer getLongPassing() {
        return longPassing;
    }

    public void setLongPassing(Integer longPassing) {
        this.longPassing = longPassing;
    }

    public Integer getLongShots() {
        return longShots;
    }

    public void setLongShots(Integer longShots) {
        this.longShots = longShots;
    }

    public Integer getMarking() {
        return marking;
    }

    public void setMarking(Integer marking) {
        this.marking = marking;
    }

    public Integer getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(Integer nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getNationalPosition() {
        return nationalPosition;
    }

    public void setNationalPosition(String nationalPosition) {
        this.nationalPosition = nationalPosition;
    }

    public String getNationalTeam() {
        return nationalTeam;
    }

    public void setNationalTeam(String nationalTeam) {
        this.nationalTeam = nationalTeam;
    }

    public String getOnLoan() {
        return onLoan;
    }

    public void setOnLoan(String onLoan) {
        this.onLoan = onLoan;
    }

    public Integer getOverall() {
        return overall;
    }

    public void setOverall(Integer overall) {
        this.overall = overall;
    }

    public Integer getPenalties() {
        return penalties;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getPositioning() {
        return positioning;
    }

    public void setPositioning(Integer positioning) {
        this.positioning = positioning;
    }

    public Integer getPotential() {
        return potential;
    }

    public void setPotential(Integer potential) {
        this.potential = potential;
    }

    public String getPreferredFoot() {
        return preferredFoot;
    }

    public void setPreferredFoot(String preferredFoot) {
        this.preferredFoot = preferredFoot;
    }

    public Integer getReaction() {
        return reaction;
    }

    public void setReaction(Integer reaction) {
        this.reaction = reaction;
    }

    public Long getReleaseClause() {
        return releaseClause;
    }

    public void setReleaseClause(Long releaseClause) {
        this.releaseClause = releaseClause;
    }

    public Integer getShortPassing() {
        return shortPassing;
    }

    public void setShortPassing(Integer shortPassing) {
        this.shortPassing = shortPassing;
    }

    public Integer getShotPower() {
        return shotPower;
    }

    public void setShotPower(Integer shotPower) {
        this.shotPower = shotPower;
    }

    public Integer getSkillMoves() {
        return skillMoves;
    }

    public void setSkillMoves(Integer skillMoves) {
        this.skillMoves = skillMoves;
    }

    public Integer getSlidingTackle() {
        return slidingTackle;
    }

    public void setSlidingTackle(Integer slidingTackle) {
        this.slidingTackle = slidingTackle;
    }

    public Integer getSprintSpeed() {
        return sprintSpeed;
    }

    public void setSprintSpeed(Integer sprintSpeed) {
        this.sprintSpeed = sprintSpeed;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getStandingTackle() {
        return standingTackle;
    }

    public void setStandingTackle(Integer standingTackle) {
        this.standingTackle = standingTackle;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Long getValueeur() {
        return valueeur;
    }

    public void setValueeur(Long valueeur) {
        this.valueeur = valueeur;
    }

    public Integer getVision() {
        return vision;
    }

    public void setVision(Integer vision) {
        this.vision = vision;
    }

    public Integer getVolleys() {
        return volleys;
    }

    public void setVolleys(Integer volleys) {
        this.volleys = volleys;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    public Integer getWeakFoot() {
        return weakFoot;
    }

    public void setWeakFoot(Integer weakFoot) {
        this.weakFoot = weakFoot;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Mannschaften getClubid() {
        return clubid;
    }

    public void setClubid(Mannschaften clubid) {
        this.clubid = clubid;
    }

}