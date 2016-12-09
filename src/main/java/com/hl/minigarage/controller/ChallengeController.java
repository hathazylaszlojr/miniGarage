package com.hl.minigarage.controller;

import com.hl.minigarage.entity.Challenge;
import com.hl.minigarage.entity.Idea;
import com.hl.minigarage.service.ChallengeService;
import com.hl.minigarage.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private IdeaService ideaService;

    @RequestMapping(method = RequestMethod.POST)
    public void createChallenge(@RequestBody Challenge challenge) {
        challengeService.addChallenge(challenge);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Challenge> getAllChallengesForCurrentUser() {
        return challengeService.getAllChallengesForCurrentUser();
    }

    @RequestMapping(value = "/{challenge_name}/idea", method = RequestMethod.GET)
    public List<Idea> getAllIdeasForChallenge(@PathVariable("challenge_name") String challengeName) {
        return challengeService.retrieveAllIdeasForChallenge(challengeName);
    }

    @RequestMapping(value = "/{challenge_name}/idea", method = RequestMethod.POST)
    public void addIdeaToChallenge(@PathVariable("challenge_name") String challengeName,
                                   @RequestBody Idea idea) {

        if (challengeService.isValidChallengeName(challengeName)) {
            challengeService.addIdeaToChallenge(challengeName, idea);
        } else {
            throw new RuntimeException("Invalid challenge name! Please specify a existing challenge name!"); //FIXME: Add a proper exception
        }
    }

}
