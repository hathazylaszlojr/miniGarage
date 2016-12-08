package com.hl.minigarage.entity;

import javax.persistence.Entity;

@Entity
public class Idea {

    private String challengeName;

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }
}
