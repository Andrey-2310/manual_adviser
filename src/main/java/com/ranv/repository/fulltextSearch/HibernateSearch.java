package com.ranv.repository.fulltextSearch;

import com.ranv.model.DB.Manual;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@Repository
@Transactional
public class HibernateSearch {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Manual> fulltextSearching(String keyword, int offset){
        if(keyword.equals("")) return Collections.emptyList();
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Manual.class).get();
        javax.persistence.Query jpaQuery =
                fullTextEntityManager.createFullTextQuery(createQuery(qb, keyword), Manual.class);
        jpaQuery.setFirstResult(offset);
        jpaQuery.setMaxResults(10);
        @SuppressWarnings("unchecked")
        List<Manual> result =  jpaQuery.getResultList();
        return result;
    }

    private  org.apache.lucene.search.Query createQuery(QueryBuilder qb, String keyword){
        return    qb
                .keyword()
                .onFields("name", "introduction", "user.username", "tags.name")
                .matching(keyword)
                .createQuery();
    }


}
