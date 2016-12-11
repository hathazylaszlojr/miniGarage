package com.hl.minigarage.service;

import com.hl.minigarage.entity.Challenge;
import com.hl.minigarage.entity.Idea;
import com.hl.minigarage.repository.ChallengeRepository;
import com.hl.minigarage.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    @Autowired
    ChallengeRepository challengeRepository;

    public List<Idea> retrieveAllIdeasForChallenge(String challengeName) {
        Challenge challenge = challengeRepository.retrieveChallengeWithShortName(challengeName);
        return ideaRepository.getAllIdeasForChallenge(challenge.getChallengeId());
    }

}
