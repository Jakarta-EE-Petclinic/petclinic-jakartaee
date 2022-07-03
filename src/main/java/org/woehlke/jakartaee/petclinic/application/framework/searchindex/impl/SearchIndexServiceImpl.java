package org.woehlke.jakartaee.petclinic.application.framework.searchindex.impl;

import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.application.framework.searchindex.SearchIndexService;
import org.woehlke.jakartaee.petclinic.owner.OwnerDao;
import org.woehlke.jakartaee.petclinic.pettype.PetTypeDao;
import org.woehlke.jakartaee.petclinic.specialty.SpecialtyDao;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;

/**
 *
 */
@Log
@Stateless
public class SearchIndexServiceImpl implements SearchIndexService {

    private static final long serialVersionUID = 2941468681052495358L;

    @EJB
    private OwnerDao ownerDao;

    @EJB
    private PetTypeDao petTypeDao;

    @EJB
    private SpecialtyDao specialtyDao;

    @Override
    @Asynchronous
    public void resetSearchIndex() {
        log.info("resetSearchIndex Start");
        ownerDao.resetSearchIndex();
        petTypeDao.resetSearchIndex();
        specialtyDao.resetSearchIndex();
        log.info("resetSearchIndex Done");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+SearchIndexServiceImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: s"+SearchIndexServiceImpl.class.getSimpleName());
    }

    @PrePassivate
    public void prePassivate() {
        log.info("prePassivate: "+SearchIndexServiceImpl.class.getSimpleName());
    }

    @PostActivate
    public void postActivate() {
        log.info("postActivate: "+SearchIndexServiceImpl.class.getSimpleName());
    }
}
