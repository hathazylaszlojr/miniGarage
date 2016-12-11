package com.hl.minigarage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "TITLE")
    private String challengeTitle;

    @Column(name = "SHORT_NAME")
    private String challengeShortName;

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

    @JsonIgnore
    public Instant getDateAdded() {
        return timestamp.toInstant();
    }

    @JsonIgnore
    public void setDateAdded(Instant dateAdded) {
        timestamp = Timestamp.from(dateAdded);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChallengeTitle() {
        return challengeTitle;
    }

    public void setChallengeTitle(String challengeTitle) {
        this.challengeTitle = challengeTitle;
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

    public String getChallengeShortName() {
        return challengeShortName;
    }

    public void setChallengeShortName(String challengeShortName) {
        this.challengeShortName = challengeShortName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        Challenge other = (Challenge) obj;

        if (this.getChallengeId() != 0 && other.getChallengeId() != 0 && !this.getChallengeId().equals(other.getChallengeId())) {
            return false;
        }

        if (this.getChallengeTitle() == null || other.getChallengeTitle() == null) {
            return false;
        }

        if (!this.getChallengeTitle().equals(other.getChallengeTitle())) {
            return false;
        }

        return true;
    }
}
