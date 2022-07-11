package org.woehlke.jakartaee.petclinic.owner.impl;

import jakarta.ejb.EJB;
import jakarta.ejb.PostActivate;
import jakarta.ejb.PrePassivate;
import jakarta.ejb.Stateless;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pet.impl.PetDao;
import org.woehlke.jakartaee.petclinic.visit.impl.VisitDao;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.visit.Visit;
import org.woehlke.jakartaee.petclinic.owner.OwnerService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.util.List;

/**
 * Created by tw on 10.03.14.
 */
@Log
@Stateless
public class OwnerServiceImpl implements OwnerService {

    private static final long serialVersionUID = -553095693269912269L;

    @EJB
    private OwnerDao ownerDao;

    @EJB
    private PetDao petDao;

    @EJB
    private VisitDao visitDao;

    @Override
    public Visit addNewVisit(Visit visit) {
        log.info("addNew Visit: " + visit.toString());
        Pet pet = visit.getPet();
        Owner owner = pet.getOwner();
        visit.setPet(null);
        visit = visitDao.addNew(visit);
        owner = ownerDao.update(owner);
        pet.setOwner(owner);
        pet = petDao.update(pet);
        visit.setPet(pet);
        visit = visitDao.update(visit);
        log.info("added new Visit - updated owner: " + owner.toString());
        log.info("added new Visit - updated pet:   " + pet.toString());
        log.info("added new Visit:                 " + visit.toString());
        return visit;
    }

    @Override
    public void resetSearchIndex() {
        for(Owner o: this.getAll()){
            for(Pet p:o.getPets()){
                for(Visit v:p.getVisits()){
                    this.visitDao.update(v);
                }
                this.petDao.update(p);
            }
            this.ownerDao.update(o);
        }
    }

    @Override
    public List<Owner> getAll() {
        return this.ownerDao.getAll();
    }

    @Override
    public void delete(long id) {
        log.info("delete Owner: " + id);
        this.ownerDao.delete(id);
    }

    @Override
    public Owner addNew(Owner owner) {
        owner = this.updateSearchindex(owner);
        log.info("addNew Owner: " + owner.toString());
        return this.ownerDao.addNew(owner);
    }

    @Override
    public Owner findById(long id) {
        return this.ownerDao.findById(id);
    }

    @Override
    public Owner update(Owner owner) {
        owner = this.updateSearchindex(owner);
        log.info("update Owner: " + owner.toString());
        return this.ownerDao.update(owner);
    }

    private Owner updateSearchindex(Owner owner) {
        for(Pet p:owner.getPets()){
            for(Visit v:p.getVisits()){
                this.visitDao.update(v);
            }
            this.petDao.update(p);
        }
        return owner;
    }

    @Override
    public List<Owner> search(String searchterm) {
        return this.ownerDao.search(searchterm);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+OwnerServiceImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+OwnerServiceImpl.class.getSimpleName());
    }

    @PrePassivate
    public void prePassivate() {
        log.info("prePassivate: "+OwnerServiceImpl.class.getSimpleName());
    }

    @PostActivate
    public void postActivate() {
        log.info("postActivate: "+OwnerServiceImpl.class.getSimpleName());
    }
}
