package org.woehlke.jakartaee.petclinic.pettype.db;

import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
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
public class PetTypeDaoImpl implements PetTypeDao, Serializable {

    private static final long serialVersionUID = -7332614951852278897L;

    @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public List<PetType> getAll() {
        TypedQuery<PetType> q = entityManager.createNamedQuery("PetType.getAll", PetType.class);
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
        petType = updateSearchindex(petType);
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
        petType = updateSearchindex(petType);
        log.info("update PetType: " + petType.toString());
        return entityManager.merge(petType);
    }

    private PetType updateSearchindex(PetType petType) {
        String element[] = petType.getName().split("\\W");

        StringBuilder b = new StringBuilder();
        for(String e: element){
            b.append(e);
            b.append(" ");
        }
        petType.setSearchindex(b.toString());
        return petType;
    }

    @Override
    public List<PetType> search(String searchterm) {
        log.info("search PetType for: " + searchterm);
        TypedQuery<PetType> q = entityManager.createNamedQuery( "PetType.search", PetType.class);
        q.setParameter("searchterm", "%" + searchterm + "%");
        List<PetType> list = q.getResultList();
        return list;
    }

    @Override
    public void resetSearchIndex() {
    }

    @Override
    public PetType findByName(String name) {
        TypedQuery<PetType> query = entityManager.createNamedQuery( "PetType.findByName", PetType.class);
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
}
