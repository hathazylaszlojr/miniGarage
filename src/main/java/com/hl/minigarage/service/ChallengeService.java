package com.hl.minigarage.service;

import com.hl.minigarage.Utils;
import com.hl.minigarage.entity.Challenge;
import com.hl.minigarage.entity.Idea;
import com.hl.minigarage.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ChallengeService {

    @Autowired private IdeaService ideaService;

    @Autowired private ChallengeRepository challengeRepository;

    public Challenge addChallenge(Challenge challenge) {
        challenge.setDateAdded(Instant.now());
        if (challenge.getChallengeShortName() == null) {
            challenge.setChallengeShortName(Utils.generateShortName(challenge.getChallengeTitle()));
        }
        return challengeRepository.save(challenge);
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
        return challengeRepository.retrieveChallengeWithShortName(challengeName) != null;
    }

    public Idea addIdeaToChallenge(String challengeShortName, Idea idea) {
        Challenge challenge = challengeRepository.retrieveChallengeWithShortName(challengeShortName);
        idea.setDateAdded(Instant.now());
        challenge.addIdea(idea);
        challengeRepository.save(challenge);
        return idea; //FIXME: should return the new/updated idea
    }
}
