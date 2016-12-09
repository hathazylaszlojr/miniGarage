package com.hl.minigarage.service;

import com.hl.minigarage.entity.Idea;
import com.hl.minigarage.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    public List<Idea> retrieveAllIdeasForChallenge(String challengeName) {
        return ideaRepository.getAllIdeasForChallenge(challengeName);
    }

    public void addIdea(Idea idea) {
        //FIXME: implement me
    }
}
