package com.hl.minigarage.repository;

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
public class IdeaRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Idea> getAllIdeasForChallenge(String challengeName) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Idea.class);
        criteria.add(Restrictions.eq("challengeName", challengeName));
//        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Idea> result = criteria.list();
        return result;
    }

}
