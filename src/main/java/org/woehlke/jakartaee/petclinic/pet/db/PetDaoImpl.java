package org.woehlke.jakartaee.petclinic.pet.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 06.01.14
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
@Log
@Stateless
public class PetDaoImpl implements PetDao {

    private static final long serialVersionUID = -9149391932558758266L;

    @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public Pet addNew(Pet pet) {
        pet.setUuid(UUID.randomUUID());
        pet = updateSearchindex(pet);
        log.info("transient New Pet: " + pet.toString());
        entityManager.persist(pet);
        log.info("persistent New Pet: " + pet.toString());
        return pet;
    }

    @Override
    public List<Pet> getAll() {
        String qlString = "select p from Pet p order by p.name";
        TypedQuery<Pet> q = entityManager.createQuery(qlString, Pet.class);
        return q.getResultList();
    }

    @Override
    public Pet findById(long petId) {
        return entityManager.find(Pet.class, petId);
    }

    @Override
    public Pet update(Pet pet) {
        pet = updateSearchindex(pet);
        log.info("update Pet: " + pet.toString());
        return entityManager.merge(pet);
    }

    private Pet updateSearchindex(Pet pet) {
        String element[] = pet.getName().split("\\W");
        StringBuilder b = new StringBuilder();
        for(String e: element){
            b.append(e);
            b.append(" ");
        }
        pet.setSearchindex(b.toString());
        return pet;
    }

    @Override
    public void delete(long id) {
        Pet p = this.findById(id);
        log.info("delete Pet: " + p.toString());
        entityManager.remove(p);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+PetDaoImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+PetDaoImpl.class.getSimpleName());
    }

    @PrePassivate
    public void prePassivate() {
        log.info("prePassivate: "+PetDaoImpl.class.getSimpleName());
    }

    @PostActivate
    public void postActivate() {
        log.info("postActivate: "+PetDaoImpl.class.getSimpleName());
    }
}