package org.woehlke.jakartaee.petclinic.vet.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.vet.VetDao;
import org.woehlke.jakartaee.petclinic.vet.Vet;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 02.01.14
 * Time: 08:30
 * To change this template use File | Settings | File Templates.
 */
@Log
@Stateless
public class VetDaoImpl implements VetDao {

    private static final long serialVersionUID = -1003870150408928198L;

    @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public List<Vet> getAll() {
        String qlString = "select v from Vet v order by v.lastName,v.firstName";
        TypedQuery<Vet> q = entityManager.createQuery(qlString, Vet.class);
        List<Vet> list = q.getResultList();
        return list;
    }

    @Override
    public Vet findById(long id) {
        Vet vet = entityManager.find(Vet.class, id);
        return vet;
    }

    @Override
    public void delete(long id) {
        Vet vet = entityManager.find(Vet.class, id);
        log.info("delete Vet: " + vet.toString());
        entityManager.remove(vet);
    }

    @Override
    public Vet addNew(@NotNull Vet vet) {
        vet.setUuid(UUID.randomUUID());
        log.info("addNew Vet: " + vet.toString());
        entityManager.persist(vet);
        log.info("addded New Vet: " + vet.toString());
        return vet;
    }

    @Override
    public Vet update(@NotNull Vet vet) {
        log.info("update Vet: " + vet.toString());
        return entityManager.merge(vet);
    }

    @Override
    public List<Vet> search(String searchterm) {
        log.info("search Vet: " + searchterm);
    /*
    FullTextEntityManager fullTextEntityManager =
        org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
    QueryBuilder qb = fullTextEntityManager.getSearchFactory()
        .buildQueryBuilder().forEntity(Vet.class).get();
    org.apache.lucene.search.Query query = qb
        .keyword()
        .onFields("firstName", "lastName", "specialties.name")
        .matching(searchterm)
        .createQuery();
    // wrap Lucene query in a javax.persistence.Query
    javax.persistence.Query persistenceQuery =
        fullTextEntityManager.createFullTextQuery(query, Vet.class);
    // execute search
    @SuppressWarnings("unchecked")
    List<Vet> result = persistenceQuery.getResultList();
    return result;
    */
        return new ArrayList<Vet>();
    }

    @Override
    public void resetSearchIndex() {
        log.info("resetSearchIndex Vet");
    /*
    FullTextEntityManager fullTextEntityManager =
        org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
    String qlString = "select o from Vet o";
    TypedQuery<Vet> findAllActionItems = fullTextEntityManager.createQuery(
        qlString,
        Vet.class
    );
    for (Vet vet : findAllActionItems.getResultList()) {
      fullTextEntityManager.index(vet);
    }
    fullTextEntityManager.flushToIndexes();
     */
        //fullTextEntityManager.clear();
    }


    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+VetDaoImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+VetDaoImpl.class.getSimpleName());
    }

    @PrePassivate
    public void prePassivate() {
        log.info("prePassivate: "+VetDaoImpl.class.getSimpleName());
    }

    @PostActivate
    public void postActivate() {
        log.info("postActivate: "+VetDaoImpl.class.getSimpleName());
    }
}
