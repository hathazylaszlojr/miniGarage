package com.hl.minigarage.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CHALLENGE")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer challengeId;

    @Column(name = "DATE_ADDED")
    private Timestamp timestamp;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NAME")
    private String challengeName;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "CHALLENGE_ID_FK")
    private Set<Idea> ideas;

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
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
        timestamp = Timestamp.from(dateAdded);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public Set<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(Set<Idea> ideas) {
        this.ideas = ideas;
    }

    public void addIdea(Idea idea) {
        if (ideas == null) {
            ideas = new HashSet<>();
        }
        ideas.add(idea);
    }
}
