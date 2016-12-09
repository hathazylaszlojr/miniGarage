package com.hl.minigarage.service;

import com.hl.minigarage.entity.Challenge;
import com.hl.minigarage.entity.Idea;
import com.hl.minigarage.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    @Autowired private IdeaService ideaService;

    @Autowired private ChallengeRepository challengeRepository;

    public void addChallenge(Challenge challenge) {
        challengeRepository.save(challenge);
    }

    public List<Challenge> getAllChallengesForCurrentUser() {
        return challengeRepository.listAll();
        //FIXME: implement me
//        return "Retrieving all cahllenges for current user";
    }

    public List<Idea> retrieveAllIdeasForChallenge(String challengeName) {
        return ideaService.retrieveAllIdeasForChallenge(challengeName);
    }

    public boolean isValidChallengeName(String challengeName) {
        //FIXME: implement me correctly
        return false;
    }

    public void addIdeaToChallenge(String challengeName, Idea idea) {
        Challenge challenge = challengeRepository.retrieveChallengeWithName(challengeName);
        challenge.addIdea(idea);
        challengeRepository.save(challenge);
    }
}
