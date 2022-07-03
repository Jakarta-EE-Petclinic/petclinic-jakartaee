package org.woehlke.jakartaee.petclinic.owner.views;

import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.ejb.EJBTransactionRolledbackException;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.application.config.messages.MessageProvider;
import org.woehlke.jakartaee.petclinic.application.views.FrontendMessagesView;
import org.woehlke.jakartaee.petclinic.application.views.LanguageView;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.visit.Visit;
import org.woehlke.jakartaee.petclinic.owner.OwnerService;
import org.woehlke.jakartaee.petclinic.pet.PetService;
import org.woehlke.jakartaee.petclinic.pettype.PetTypeService;
import org.woehlke.jakartaee.petclinic.visit.VisitService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 06.01.14
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
@Log
@Named("ownerView")
@SessionScoped
public class OwnerViewImpl implements OwnerView {

    private static final long serialVersionUID = -4809817472969005481L;

    private final static String JSF_PAGE = "owner.jsf";

    private MessageProvider messageProvider;

    @EJB
    private OwnerService entityService;

    @EJB
    private PetService petService;

    @EJB
    private PetTypeService petTypeService;

    @EJB
    private VisitService visitService;

    @Inject
    private SecurityContext securityContext;

    @Inject
    private LanguageView languageView;

    @Inject
    private FrontendMessagesView frontendMessagesView;

    @Inject
    private OwnerViewFlow ownerViewFlow;

    private String searchterm;
    private List<Owner> list;
    private Owner entity;
    private Owner selected;
    private Pet pet;
    private Pet petSelected;
    private List<PetType> petTypeList;
    private long petTypeId;
    private Visit visit;

    @Override
    @PostConstruct
    public void init() {
        log.info("postConstruct: " + OwnerViewImpl.class.getSimpleName());
        this.messageProvider = new MessageProvider();
        this.ownerViewFlow.setFlowStateList();
    }

    @Override
    public boolean reloadEntityFromSelected() {
        log.info("reloadEntityFromSelected");
        if (this.selected != null) {
            this.entity = entityService.findById(this.selected.getId());
            this.selected = this.entity;
            return true;
        } else {
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.list.choose.summary";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            String detailKey = "org.woehlke.jakartaee.petclinic.owner.list.choose.detail";
            String detail = this.messageProvider.getBundle().getString(detailKey);
            frontendMessagesView.addWarnMessage(summary, detail);
            return false;
        }
    }

    @Override
    public void loadList() {
        this.list = entityService.getAll();
    }

    @Override
    public void saveNewEntity() {
        log.info("saveNewEntity");
        try {
            this.ownerViewFlow.setFlowStateList();
            if (this.entity != null) {
                this.entity = this.entityService.addNew(this.entity);
                this.selected = this.entity;
                String summaryKey = "org.woehlke.jakartaee.petclinic.owner.addNew.done";
                String summary = this.messageProvider.getBundle().getString(summaryKey);
                frontendMessagesView.addInfoMessage(summary, this.entity);
            } else {
                this.newEntity();
            }
        } catch (EJBException e) {
            this.ownerViewFlow.setFlowStateNew();
            frontendMessagesView.addWarnMessage(e, this.entity);
        }
    }

    @Override
    public void saveEditedEntity() {
        log.info("saveEditedEntity");
        try {
            this.ownerViewFlow.setFlowStateList();
            if (this.entity != null) {
                this.entity = entityService.update(this.entity);
                this.selected = this.entity;
                String summaryKey = "org.woehlke.jakartaee.petclinic.owner.edit.done";
                String summary = this.messageProvider.getBundle().getString(summaryKey);
                frontendMessagesView.addInfoMessage(summary, this.entity);
            }
        } catch (EJBException e) {
            this.ownerViewFlow.setFlowStateEdit();
            frontendMessagesView.addWarnMessage(e, this.entity);
        }
    }

    @Override
    public void deleteSelectedEntity() {
        log.info("deleteSelectedEntity");
        try {
            if (this.reloadEntityFromSelected()) {
                String msgInfo = this.selected.getPrimaryKey();
                if (this.selected.compareTo(this.entity) == 0) {
                    this.entity = null;
                }
                entityService.delete(this.selected.getId());
                this.selected = null;
                this.ownerViewFlow.setFlowStateList();
                String summaryKey = "org.woehlke.jakartaee.petclinic.owner.delete.done";
                String summary = this.messageProvider.getBundle().getString(summaryKey);
                frontendMessagesView.addInfoMessage(summary, msgInfo);
                this.ownerViewFlow.setFlowStateDelete();
            } else {
                this.ownerViewFlow.setFlowStateList();
            }
        } catch (EJBTransactionRolledbackException e) {
            this.ownerViewFlow.setFlowStateDelete();
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.delete.denied";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            frontendMessagesView.addWarnMessage(summary, this.selected);
        } catch (EJBException e) {
            this.ownerViewFlow.setFlowStateDelete();
            frontendMessagesView.addErrorMessage(e.getLocalizedMessage(), this.selected);
        }
    }

    @Override
    public void newEntity() {
        this.entity = new Owner();
    }

    @Override
    public Visit getVisit() {
        return visit;
    }

    @Override
    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    @Override
    public Pet getPet() {
        return pet;
    }

    @Override
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public long getPetTypeId() {
        return petTypeId;
    }

    @Override
    public void setPetTypeId(long petTypeId) {
        this.petTypeId = petTypeId;
    }

    @Override
    public String getSearchterm() {
        return searchterm;
    }

    @Override
    public void setSearchterm(String searchterm) {
        this.searchterm = searchterm;
    }

    @Override
    public Pet getPetSelected() {
        return petSelected;
    }

    @Override
    public void setPetSelected(Pet petSelected) {
        this.petSelected = petSelected;
    }

    @Override
    public void loadPetTypeList() {
        this.petTypeList = this.petTypeService.getAll();
    }

    @Override
    public List<PetType> getPetTypeList() {
        this.loadPetTypeList();
        return petTypeList;
    }

    @Override
    public void setPetTypeList(List<PetType> petTypeList) {
        this.petTypeList = petTypeList;
    }

    @Override
    public String search() {
        log.info("search");
        performSearch();
        return JSF_PAGE;
    }

    @Override
    public void performSearch() {
        log.info("performSearch");
        String summaryKey = "org.woehlke.jakartaee.petclinic.owner.search.done";
        String summary = this.messageProvider.getBundle().getString(summaryKey);
        if (searchterm == null || searchterm.isEmpty()) {
            String missingKey = "org.woehlke.jakartaee.petclinic.list.searchterm.missing";
            String detail = this.messageProvider.getBundle().getString(missingKey);
            frontendMessagesView.addInfoMessage(summary, detail);
            this.ownerViewFlow.setFlowStateList();
        } else {
            try {
                this.list = entityService.search(searchterm);
                String foundKey = "org.woehlke.jakartaee.petclinic.list.searchterm.found";
                String resultsKey = "org.woehlke.jakartaee.petclinic.list.searchterm.results";
                String found = this.messageProvider.getBundle().getString(foundKey);
                String results = this.messageProvider.getBundle().getString(resultsKey);
                String detail = found + " " + this.list.size() + " " + results + " " + searchterm;
                frontendMessagesView.addInfoMessage(summary, detail);
                this.ownerViewFlow.setFlowStateSearchResult();
            } catch (Exception e) {
                this.ownerViewFlow.setFlowStateList();
                frontendMessagesView.addWarnMessage(e.getLocalizedMessage(), searchterm);
            }
        }
    }

    @Override
    public String showNewForm() {
        log.info("showNewForm");
        this.newEntity();
        this.ownerViewFlow.setFlowStateNew();
        return JSF_PAGE;
    }

    @Override
    public String saveNew() {
        log.info("saveNew");
        this.saveNewEntity();
        this.ownerViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String cancelNew() {
        log.info("cancelNew");
        this.ownerViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String cancelOwnerPetVisitNew() {
        log.info("cancelOwnerPetVisitNew");
        this.reloadEntityFromSelected();
        this.ownerViewFlow.setFlowStateEdit();
        return JSF_PAGE;
    }

    @Override
    public String showOwnerEditForm() {
        log.info("showOwnerEditForm");
        if (this.reloadEntityFromSelected()) {
            this.ownerViewFlow.setFlowStateEdit();
        } else {
            this.ownerViewFlow.setFlowStateList();
        }
        return JSF_PAGE;
    }

    @Override
    public String showEditForm() {
        log.info("showEditForm");
        this.reloadEntityFromSelected();
        this.ownerViewFlow.setFlowStateEdit();
        return JSF_PAGE;
    }

    @Override
    public String cancelEdited() {
        log.info("cancelEdited");
        this.ownerViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String saveEdited() {
        log.info("saveEdited");
        this.saveEditedEntity();
        this.ownerViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String showDeleteForm() {
        log.info("showDeleteForm");
        if (this.reloadEntityFromSelected()) {
            this.ownerViewFlow.setFlowStateDelete();
        } else {
            this.ownerViewFlow.setFlowStateList();
        }
        return JSF_PAGE;
    }

    @Override
    public String cancelDelete() {
        log.info("cancelDelete");
        this.ownerViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String performDelete() {
        log.info("performDelete");
        try {
            long id = this.selected.getId();
            String uuid = this.selected.getUuid().toString();
            String selectedPrimaryKey = this.selected.getPrimaryKey() + "(" + id + "," + uuid + ")";
            entityService.delete(id);
            this.selected = null;
            this.entity = null;
            this.ownerViewFlow.setFlowStateList();
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.delete.done";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            frontendMessagesView.addInfoMessage(summary, selectedPrimaryKey);
        } catch (EJBException e) {
            this.ownerViewFlow.setFlowStateDelete();
            frontendMessagesView.addWarnMessage(e, this.selected);
        }
        return JSF_PAGE;
    }

    @Override
    public List<PetType> getAllPetTypes() {
        return petTypeService.getAll();
    }

    @Override
    public String showOwnerPetNewForm() {
        log.info("showOwnerPetNewForm");
        this.pet = new Pet();
        this.ownerViewFlow.setFlowStateNewPet();
        return JSF_PAGE;
    }

    @Override
    public String saveOwnerPetNew() {
        log.info("saveOwnerPetNew");
        try {
            PetType petType = petTypeService.findById(this.petTypeId);
            this.pet.setType(petType);
            this.pet.setOwner(this.entity);
            this.pet = petService.addNew(this.pet);
            this.entity.addPet(this.pet);
            this.entity = entityService.update(this.entity);
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.addNew.done";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            frontendMessagesView.addInfoMessage(summary, this.pet);
            this.ownerViewFlow.setFlowStateEdit();
        } catch (EJBException e) {
            this.ownerViewFlow.setFlowStateNewPet();
            frontendMessagesView.addWarnMessage(e, this.pet);
        }
        return JSF_PAGE;
    }

    @Override
    public String cancelOwnerPetNew() {
        log.info("cancelOwnerPetNew");
        this.ownerViewFlow.setFlowStateEdit();
        this.reloadEntityFromSelected();
        return JSF_PAGE;
    }

    @Override
    public String showOwnerPetEditForm() {
        log.info("showOwnerPetEditForm");
        if (this.petSelected != null) {
            this.pet = petService.findById(this.petSelected.getId());
            this.ownerViewFlow.setFlowStateEditPet();
            return JSF_PAGE;
        } else {
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.pet.choose.summary";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            String msgKey = "org.woehlke.jakartaee.petclinic.owner.pet.choose.detail";
            String msg = this.messageProvider.getBundle().getString(msgKey);
            frontendMessagesView.addWarnMessage(summary, msg);
            this.ownerViewFlow.setFlowStateEdit();
            return JSF_PAGE;
        }
    }

    @Override
    public String saveOwnerPetEdit() {
        log.info("saveOwnerPetEdit");
        try {
            PetType petType = petTypeService.findById(this.petTypeId);
            this.pet.setType(petType);
            petService.update(this.pet);
            long ownerId = this.entity.getId();
            this.entity = this.entityService.findById(ownerId);
            this.selected = this.entity;
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.edit.done";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            frontendMessagesView.addInfoMessage(summary, this.pet);
            this.ownerViewFlow.setFlowStateEdit();
        } catch (EJBException e) {
            this.ownerViewFlow.setFlowStateEditPet();
            frontendMessagesView.addWarnMessage(e, this.pet);
        }
        return JSF_PAGE;
    }

    @Override
    public String cancelOwnerPetEdit() {
        log.info("cancelOwnerPetEdit");
        this.reloadEntityFromSelected();
        this.ownerViewFlow.setFlowStateEdit();
        return JSF_PAGE;
    }

    @Override
    public String editOwnerPetVisitNewForm() {
        log.info("editOwnerPetVisitNewForm");
        if (this.petSelected != null) {
            this.pet = petService.findById(this.petSelected.getId());
            this.petTypeId = this.pet.getType().getId();
            this.visit = new Visit();
            this.ownerViewFlow.setFlowStateNewVisit();
            return JSF_PAGE;
        } else {
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.pet.choose.summary";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            String msgKey = "org.woehlke.jakartaee.petclinic.owner.pet.choose.detail";
            String msg = this.messageProvider.getBundle().getString(msgKey);
            frontendMessagesView.addWarnMessage(summary, msg);
            this.ownerViewFlow.setFlowStateEdit();
            return JSF_PAGE;
        }
    }

    @Override
    public String saveOwnerPetVisitNew() {
        log.info("saveOwnerPetVisitNew");
        try {
            if (this.petSelected != null) {
                this.pet = petService.findById(this.petSelected.getId());
                this.visit.setPet(this.pet);
                this.pet.addVisit(this.visit);
                this.visit = this.entityService.addNewVisit(this.visit);
                log.info("owner1: " + this.entity.toString());
                long ownerId = this.entity.getId();
                this.entity = this.entityService.findById(ownerId);
                this.selected = this.entity;
                log.info("owner2: " + this.entity.toString());
                String summaryKey = "org.woehlke.jakartaee.petclinic.owner.pet.visit.addNew.done";
                String summary = this.messageProvider.getBundle().getString(summaryKey);
                frontendMessagesView.addInfoMessage(summary, this.visit);
            } else {
                String summaryKey = "org.woehlke.jakartaee.petclinic.owner.pet.visit.addNew";
                String summary = this.messageProvider.getBundle().getString(summaryKey);
                String msgKey = "org.woehlke.jakartaee.petclinic.owner.pet.visit.addNew.denied";
                String msg = this.messageProvider.getBundle().getString(msgKey);
                frontendMessagesView.addWarnMessage(summary, msg);
            }
            this.reloadEntityFromSelected();
            this.ownerViewFlow.setFlowStateEdit();
            return JSF_PAGE;
        } catch (EJBException e) {
            this.ownerViewFlow.setFlowStateNewVisit();
            frontendMessagesView.addWarnMessage(e, this.visit);
            return JSF_PAGE;
        }
    }

    @Override
    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy");
    }

    @Override
    public List<Owner> getList() {
        loadList();
        return list;
    }

    @Override
    public void setList(List<Owner> list) {
        this.list = list;
    }

    @Override
    public Owner getEntity() {
        return entity;
    }

    @Override
    public void setEntity(Owner entity) {
        this.entity = entity;
    }

    @Override
    public Owner getSelected() {
        return selected;
    }

    @Override
    public void setSelected(Owner selected) {
        this.selected = selected;
    }

    @Override
    public LanguageView getLanguageView() {
        return languageView;
    }

    @Override
    public void setLanguageView(LanguageView languageView) {
        this.languageView = languageView;
    }

    @Override
    public ResourceBundle getMsg() {
        return this.messageProvider.getBundle();
    }

    public void setMsg(ResourceBundle msg) {

    }

    public FrontendMessagesView getFrontendMessagesView() {
        return frontendMessagesView;
    }

    public void setFrontendMessagesView(FrontendMessagesView frontendMessagesView) {
        this.frontendMessagesView = frontendMessagesView;
    }

}
