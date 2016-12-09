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

    public long save(Challenge challenge) {
        sessionFactory.getCurrentSession().saveOrUpdate(challenge);
        return challenge.getChallengeId();
    }

    public List<Challenge> listAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Challenge.class);
        return criteria.list();
    }

    public Challenge retrieveChallengeWithName(String challengeName) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Challenge.class);
        criteria.add(Restrictions.eq("challengeName", challengeName));
        return (Challenge) criteria.uniqueResult();
    }
}
