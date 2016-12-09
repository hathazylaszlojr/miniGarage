package com.hl.minigarage.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "IDEA")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer ideaId;

    @Column(name = "CHALLENGE_ID_FK")
    private Integer challengeId;

    @Column(name = "NAME")
    private String ideaName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE_ADDED")
    private Timestamp timestamp;


    public Integer getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Integer ideaId) {
        this.ideaId = ideaId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Instant getDateAdded() {
        return timestamp.toInstant();
    }

    public void setDateAdded(Instant dateAdded) {
        this.timestamp = Timestamp.from(dateAdded);
    }

    public String getIdeaName() {
        return ideaName;
    }

    public void setIdeaName(String ideaName) {
        this.ideaName = ideaName;
    }

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
