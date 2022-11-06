package org.woehlke.jakartaee.petclinic.visit.db;

import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 07.01.14
 * Time: 12:43
 * To change this template use File | Settings | File Templates.
 */
@Log
@Stateless
public class VisitDaoImpl implements VisitDao, Serializable {

    private static final long serialVersionUID = 892248114140040519L;

    @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public List<Visit> getVisits(@NotNull Pet pet) {
        TypedQuery<Visit> q = entityManager.createNamedQuery("Visit.getVisits", Visit.class);
        q.setParameter("pet", pet);
        List<Visit> list = q.getResultList();
        return list;
    }

    @Override
    public List<Visit> getAll() {
        TypedQuery<Visit> q = entityManager.createNamedQuery("Visit.getAll", Visit.class);
        List<Visit> list = q.getResultList();
        return list;
    }

    @Override
    public Visit findById(long id) {
        return entityManager.find(Visit.class, id);
    }

    private Visit updateSearchindex(Visit visit) {
        String element1[] = visit.getDate().toInstant().toString().split("\\W");
        String element2[] = visit.getDescription().split("\\W");
        StringBuilder b = new StringBuilder();
        for(String e: element1){
            b.append(e);
            b.append(" ");
        }
        for(String e: element2) {
            b.append(e);
            b.append(" ");
        }
        visit.setSearchindex(b.toString());
        return visit;
    }

    @Override
    public Visit addNew(Visit visit) {
        visit.setUuid(UUID.randomUUID());
        visit = updateSearchindex(visit);
        log.info("addNew Visit: " + visit.toString());
        entityManager.persist(visit);
        return visit;
    }

    @Override
    public Visit update(Visit visit) {
        visit = updateSearchindex(visit);
        log.info("addNew Visit: " + visit.toString());
        return entityManager.merge(visit);
    }

    @Override
    public void delete(long id) {
        Visit visit = entityManager.find(Visit.class, id);
        visit = updateSearchindex(visit);
        log.info("delete Visit: " + visit.toString());
        entityManager.remove(visit);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+VisitDaoImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+VisitDaoImpl.class.getSimpleName());
    }

}
