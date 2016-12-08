package com.hl.minigarage.service;

import com.hl.minigarage.entity.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {

    @Autowired private IdeaService ideaService;

    public void addChallenge(Challenge challenge) {
        //FIXME: implement me
    }

    public String getAllChallengesForCurrentUser() {
        //FIXME: implement me
        return "Retrieving all cahllenges for current user";
    }

    public String retrieveAllIdeasForChallenge(String challengeName) {
        return ideaService.retrieveAllIdeasForChallenge(challengeName);
    }

    public boolean isValidChallengeName(String challengeName) {
        //FIXME: implement me correctly
        return false;
    }
}
