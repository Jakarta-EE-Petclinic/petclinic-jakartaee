package org.woehlke.jakartaee.petclinic.vet.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;
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
    public Vet addNew(Vet vet) {
        vet.setUuid(UUID.randomUUID());
        vet = updateSearchindex(vet);
        log.info("addNew Vet: " + vet.toString());
        entityManager.persist(vet);
        log.info("addded New Vet: " + vet.toString());
        return vet;
    }

    @Override
    public Vet update(Vet vet) {
        vet = updateSearchindex(vet);
        log.info("update Vet: " + vet.toString());
        return entityManager.merge(vet);
    }

    private Vet updateSearchindex(Vet vet) {
        List<String> vetElements = new ArrayList<>();
        for(String element :vet.getFirstName().split("\\W")){
            vetElements.add(element);
        }
        for(String element :vet.getLastName().split("\\W")){
            vetElements.add(element);
        }
        for(Specialty s: vet.getSpecialties()){
            for(String element :s.getName().split("\\W")) {
                vetElements.add(element);
            }
        }
        StringBuilder b = new StringBuilder();
        for(String e: vetElements){
            b.append(e);
            b.append(" ");
        }
        vet.setSearchindex(b.toString());
        return vet;
    }

    @Override
    public List<Vet> search(String searchterm) {
        log.info("search Vet: " + searchterm);
        String qlString = "select v from Vet v where v.searchindex like :searchterm";
        TypedQuery<Vet> q = entityManager.createQuery(qlString, Vet.class);
        q.setParameter("searchterm", "%" + searchterm + "%");
        List<Vet> list = q.getResultList();
        return list;
    }

    @Override
    public void resetSearchIndex() {
        log.info("resetSearchIndex Vet");
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
