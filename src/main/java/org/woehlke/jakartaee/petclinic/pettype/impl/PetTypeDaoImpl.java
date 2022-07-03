package org.woehlke.jakartaee.petclinic.pettype.impl;

import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pettype.PetTypeDao;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Fert
 * Date: 06.01.14
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
@Log
@Stateless
public class PetTypeDaoImpl implements PetTypeDao {

    private static final long serialVersionUID = -7332614951852278897L;

    @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public List<PetType> getAll() {
        String qlString = "select pt from PetType pt order by pt.name";
        TypedQuery<PetType> q = entityManager.createQuery(qlString, PetType.class);
        return q.getResultList();
    }

    @Override
    public void delete(long id) {
        PetType petType = entityManager.find(PetType.class, id);
        log.info("delete PetType: " + petType.toString());
        entityManager.remove(petType);
    }

    @Override
    public PetType addNew(PetType petType) {
        log.info("addNew PetType: " + petType.toString());
        petType.setUuid(UUID.randomUUID());
        entityManager.persist(petType);
        return petType;
    }

    @Override
    public PetType findById(long id) {
        return entityManager.find(PetType.class, id);
    }

    @Override
    public PetType update(PetType petType) {
        log.info("update PetType: " + petType.toString());
        return entityManager.merge(petType);
    }

    @Override
    public List<PetType> search(String searchterm) {
    /*
    log.info("search for: " + searchterm);
    FullTextEntityManager fullTextEntityManager =
        org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
    QueryBuilder qb = fullTextEntityManager.getSearchFactory()
        .buildQueryBuilder().forEntity(PetType.class).get();
    org.apache.lucene.search.Query query = qb
        .keyword()
        .onFields("name")
        .matching(searchterm)
        .createQuery();
    // wrap Lucene query in a javax.persistence.Query
    javax.persistence.Query persistenceQuery =
        fullTextEntityManager.createFullTextQuery(query, PetType.class);
    // execute search
    @SuppressWarnings("unchecked")
    List<PetType> result = persistenceQuery.getResultList();
    log.info("found: " + result.size());
    for (PetType o : result) {
      log.info("found: " + o.getName());
    }
    return result;
     */
        return new ArrayList<>();
    }

    @Override
    public void resetSearchIndex() {
    /*
    FullTextEntityManager fullTextEntityManager =
        org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
    String qlString = "select o from PetType o";
    TypedQuery<PetType> findAllActionItems = fullTextEntityManager.createQuery(qlString, PetType.class);
    for (PetType petType : findAllActionItems.getResultList()) {
      fullTextEntityManager.index(petType);
    }
    */
        //fullTextEntityManager.flushToIndexes();
        //fullTextEntityManager.clear();
    }

    @Override
    public PetType findByName(String name) {
        String ql = "select s from PetType s where s.name=:name";
        TypedQuery<PetType> query = entityManager.createQuery(ql, PetType.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }


    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+PetTypeDaoImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+PetTypeDaoImpl.class.getSimpleName());
    }

    @PrePassivate
    public void prePassivate() {
        log.info("prePassivate: "+PetTypeDaoImpl.class.getSimpleName());
    }

    @PostActivate
    public void postActivate() {
        log.info("postActivate: "+PetTypeDaoImpl.class.getSimpleName());
    }
}
