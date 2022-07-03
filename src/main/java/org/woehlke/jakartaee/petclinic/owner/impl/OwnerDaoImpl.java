package org.woehlke.jakartaee.petclinic.owner.impl;


import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Stateless;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.OwnerDao;
import org.woehlke.jakartaee.petclinic.owner.Owner;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 06.01.14
 * Time: 09:38
 * To change this template use File | Settings | File Templates.
 */
@Log
@Stateless
public class OwnerDaoImpl implements OwnerDao {

    private static final long serialVersionUID = 1313423542L;

    @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public List<Owner> getAll() {
        String jpaQuery = "select o from Owner o order by o.lastName, o.firstName";
        TypedQuery<Owner> q = entityManager.createQuery(jpaQuery, Owner.class);
        return q.getResultList();
    }

    @Override
    public void delete(long id) {
        Owner owner = entityManager.find(Owner.class, id);
        log.info("delete Owner: " + owner.toString());
        entityManager.remove(owner);
    }

    @Override
    public Owner addNew(Owner owner) {
        owner.setUuid(UUID.randomUUID());
        log.info("addNew Owner: " + owner.toString());
        entityManager.persist(owner);
        return owner;
    }

    @Override
    public Owner findById(long id) {
        return entityManager.find(Owner.class, id);
    }

    @Override
    public Owner update(Owner owner) {
        log.info("update Owner: " + owner.toString());
        return entityManager.merge(owner);
    }

    @Override
    public List<Owner> search(String searchterm) {
        log.info("search Owner: " + searchterm);
    /*
    FullTextEntityManager fullTextEntityManager =
        org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
    QueryBuilder qb = fullTextEntityManager.getSearchFactory()
        .buildQueryBuilder().forEntity(Owner.class).get();
    org.apache.lucene.search.Query query = qb
        .keyword()
        .onFields("firstName", "lastName", "city", "pets.name")
        .matching(searchterm)
        .createQuery();
    // wrap Lucene query in a javax.persistence.Query
    javax.persistence.Query persistenceQuery =
        fullTextEntityManager.createFullTextQuery(query, Owner.class);
    // execute search
    @SuppressWarnings("unchecked")
    List<Owner> result = persistenceQuery.getResultList();
    for (Owner o : result) {
      log.info("found: " + o.getFullName());
    }
    return result;
    */
        return new ArrayList<>();
    }

    @Override
    public void resetSearchIndex() {
        log.info("resetSearchIndex Owner");
    /*
    FullTextEntityManager fullTextEntityManager =
        org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
    String jpaQuery = "select o from Owner o";
    TypedQuery<Owner> findAllActionItems = fullTextEntityManager.createQuery(jpaQuery,Owner.class);
    for (Owner owner : findAllActionItems.getResultList()) {
      fullTextEntityManager.index(owner);
    }
    fullTextEntityManager.flushToIndexes();
     */
        //fullTextEntityManager.clear();
    }


    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+OwnerDaoImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+OwnerDaoImpl.class.getSimpleName());
    }

    @PrePassivate
    public void prePassivate() {
        log.info("prePassivate: "+OwnerDaoImpl.class.getSimpleName());
    }

    @PostActivate
    public void postActivate() {
        log.info("postActivate: "+OwnerDaoImpl.class.getSimpleName());
    }
}
