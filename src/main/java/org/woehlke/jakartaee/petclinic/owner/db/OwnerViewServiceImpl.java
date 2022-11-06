package org.woehlke.jakartaee.petclinic.owner.db;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pet.db.PetService;
import org.woehlke.jakartaee.petclinic.visit.Visit;
import org.woehlke.jakartaee.petclinic.visit.db.VisitService;

import java.io.Serializable;
import java.util.List;

@Log
@Stateless
public class OwnerViewServiceImpl implements OwnerViewService, Serializable {

    private static final long serialVersionUID = -553095693269912269L;

    @EJB
    private OwnerService ownerService;

    @EJB
    private PetService petService;

    @EJB
    private VisitService visitService;

    @Override
    public void deleteOwner(long ownerId) {
        Owner owner = ownerService.findById(ownerId);
        for(Pet pet:petService.getAllPetsOfAnOwner(owner)){
            for(Visit visit:visitService.getAllVisitsOfAnPet(pet)){
                visitService.delete(visit.getId());
            }
            petService.delete(pet.getId());
        }
        ownerService.delete(owner.getId());
    }

    @Override
    public List<Owner> getAllOwner() {
        return ownerService.getAll();
    }

    @Override
    public List<Owner> searchOwner(String searchterm) {
        return ownerService.search(searchterm);
    }

    @Override
    public List<Pet> getPetsAsList(Owner owner) {
        return ownerService.getPetsAsList(owner);
    }

    @Override
    public String getPetsAsString(Owner owner) {
        return ownerService.getPetsAsString(owner);
    }

    @Override
    public List<Visit> getVisits(Pet ownersPet) {
        return petService.getVisits(ownersPet);
    }

    @Override
    public Visit addNewVisit(Visit visit) {
        return visitService.addNew(visit);
    }

    @Override
    public Pet addNewPet(Pet pet) {
        return petService.addNew(pet);
    }

    @Override
    public Pet findPetById(long id) {
        return petService.findById(id);
    }

    @Override
    public Pet updatePet(Pet pet) {
        return petService.update(pet);
    }

    @Override
    public Owner findOwnerById(long id) {
        return ownerService.findById(id);
    }

    @Override
    public Owner updateOwner(Owner entity) {
        return ownerService.update(entity);
    }

    @Override
    public Owner addNewOwner(Owner entity) {
        return ownerService.addNew(entity);
    }
}
