package com.hl.minigarage.controller;

import com.hl.minigarage.entity.Challenge;
import com.hl.minigarage.entity.Idea;
import com.hl.minigarage.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class TestController {

    @Autowired private ChallengeService challengeService;

    @RequestMapping(value = "/add-challenge", method = RequestMethod.GET)
    public String populate() {
        Challenge challenge = new Challenge();
        challenge.setChallengeName("My_new_challenge_2");
//        challenge.setChallengeId(1);
        challenge.setDateAdded(Instant.now());
        challenge.setDescription("My new challenge");
        Idea idea = new Idea();
        idea.setIdeaName("My newest idea!");
        idea.setDateAdded(Instant.now());
        challenge.addIdea(idea);
        challengeService.addChallenge(challenge);
        return "Done";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String itsWorking() {
        return "It is working";
    }

}
