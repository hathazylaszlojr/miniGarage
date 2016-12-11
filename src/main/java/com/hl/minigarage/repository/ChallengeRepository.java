package com.hl.minigarage.repository;

import com.hl.minigarage.entity.Challenge;
import com.hl.minigarage.entity.Idea;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ChallengeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Challenge save(Challenge challenge) {
        sessionFactory.getCurrentSession().saveOrUpdate(challenge);
        return challenge;
    }

    public List<Challenge> listAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Challenge.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    public Challenge retrieveChallengeWithShortName(String challengeShortName) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Challenge.class);
        criteria.add(Restrictions.eq("challengeShortName", challengeShortName));
        return (Challenge) criteria.uniqueResult();
    }
}
