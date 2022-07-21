package org.woehlke.jakartaee.petclinic.owner.db;


import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Stateless;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.Owner;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import java.util.*;


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
        owner = updateSearchindex(owner);
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
        owner = updateSearchindex(owner);
        log.info("update Owner: " + owner.toString());
        return entityManager.merge(owner);
    }

    private Owner updateSearchindex(Owner owner) {
        List<String> l = new ArrayList<>();
        for(Pet p: owner.getPetsAsList()){
            l.add(p.getSearchindex());
        }
        String x = owner.getAddressInfo();
        if( null != x){
            l.add(x);
        }
        l.add(owner.getFirstName());
        l.add(owner.getLastName());
        l.add(owner.getAddress());
        l.add(owner.getHouseNumber());
        l.add(owner.getZipCode());
        l.add(owner.getCity());
        l.add(owner.getPhoneNumber());
        l.add(owner.getEmail());
        StringBuilder b = new StringBuilder();
        for(String ll:l){
            for(String e:ll.split("\\W")){
                b.append(e);
                b.append(" ");
            }
        }
        owner.setSearchindex(b.toString());
        return owner;
    }

    @Override
    public List<Owner> search(String searchterm) {
        log.info("search Owner: " + searchterm);
        String qlString = "select v from Owner v where v.searchindex like :searchterm";
        TypedQuery<Owner> q = entityManager.createQuery(qlString, Owner.class);
        q.setParameter("searchterm", "%" + searchterm + "%");
        List<Owner> list = q.getResultList();
        return list;
    }

    @Override
    public void resetSearchIndex() {

    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+OwnerDaoImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+OwnerDaoImpl.class.getSimpleName());
    }
}
