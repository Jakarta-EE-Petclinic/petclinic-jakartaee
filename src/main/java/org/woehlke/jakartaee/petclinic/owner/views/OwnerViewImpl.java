package org.woehlke.jakartaee.petclinic.owner.views;

import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.ejb.EJBTransactionRolledbackException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.application.messages.MessageProvider;
import org.woehlke.jakartaee.petclinic.application.views.FlashMessagesView;
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
@Getter
@Setter
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
    private LanguageView languageView;

    @Inject
    private FlashMessagesView flashMessagesView;

    @Inject
    private OwnerFlowViewImpl ownerFlowViewImpl;

    private String searchterm;
    private List<Owner> list;
    private Owner entity;
    private Owner selected;
    private Pet pet;
    private Pet petSelected;
    private List<PetType> petTypeList;
    private long petTypeId;
    private Visit visit;

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
            flashMessagesView.addWarnMessage(summary, detail);
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
            this.ownerFlowViewImpl.setFlowStateList();
            if (this.entity != null) {
                this.entity = this.entityService.addNew(this.entity);
                this.selected = this.entity;
                String summaryKey = "org.woehlke.jakartaee.petclinic.owner.addNew.done";
                String summary = this.messageProvider.getBundle().getString(summaryKey);
                flashMessagesView.addInfoMessage(summary, this.entity);
            } else {
                this.newEntity();
            }
        } catch (EJBException e) {
            this.ownerFlowViewImpl.setFlowStateNew();
            flashMessagesView.addWarnMessage(e, this.entity);
        }
    }

    @Override
    public void saveEditedEntity() {
        log.info("saveEditedEntity");
        try {
            this.ownerFlowViewImpl.setFlowStateList();
            if (this.entity != null) {
                this.entity = entityService.update(this.entity);
                this.selected = this.entity;
                String summaryKey = "org.woehlke.jakartaee.petclinic.owner.edit.done";
                String summary = this.messageProvider.getBundle().getString(summaryKey);
                flashMessagesView.addInfoMessage(summary, this.entity);
            }
        } catch (EJBException e) {
            this.ownerFlowViewImpl.setFlowStateEdit();
            flashMessagesView.addWarnMessage(e, this.entity);
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
                this.ownerFlowViewImpl.setFlowStateList();
                String summaryKey = "org.woehlke.jakartaee.petclinic.owner.delete.done";
                String summary = this.messageProvider.getBundle().getString(summaryKey);
                flashMessagesView.addInfoMessage(summary, msgInfo);
                this.ownerFlowViewImpl.setFlowStateDelete();
            } else {
                this.ownerFlowViewImpl.setFlowStateList();
            }
        } catch (EJBTransactionRolledbackException e) {
            this.ownerFlowViewImpl.setFlowStateDelete();
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.delete.denied";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            flashMessagesView.addWarnMessage(summary, this.selected);
        } catch (EJBException e) {
            this.ownerFlowViewImpl.setFlowStateDelete();
            flashMessagesView.addErrorMessage(e.getLocalizedMessage(), this.selected);
        }
    }

    @Override
    public void newEntity() {
        this.entity = new Owner();
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
    public String search() {
        log.info("search");
        String summaryKey = "org.woehlke.jakartaee.petclinic.owner.search.done";
        String summary = this.messageProvider.getBundle().getString(summaryKey);
        if (searchterm == null || searchterm.isEmpty()) {
            String missingKey = "org.woehlke.jakartaee.petclinic.list.searchterm.missing";
            String detail = this.messageProvider.getBundle().getString(missingKey);
            flashMessagesView.addInfoMessage(summary, detail);
            this.ownerFlowViewImpl.setFlowStateList();
        } else {
            this.performSearch();
            String foundKey = "org.woehlke.jakartaee.petclinic.list.searchterm.found";
            String resultsKey = "org.woehlke.jakartaee.petclinic.list.searchterm.results";
            String found = this.messageProvider.getBundle().getString(foundKey);
            String results = this.messageProvider.getBundle().getString(resultsKey);
            String detail = found + " " + this.list.size() + " " + results + " " + searchterm;
            flashMessagesView.addInfoMessage(summary, detail);
            this.ownerFlowViewImpl.setFlowStateSearchResult();
        }
        return JSF_PAGE;
    }

    @Override
    public void performSearch() {
        log.info("performSearch");
        this.list = entityService.search(this.searchterm);
    }


    @Override
    public String clearSearchterm(){
        log.info("clearSearchterm");
        this.searchterm = null;
        this.ownerFlowViewImpl.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String showNewForm() {
        log.info("showNewForm");
        this.newEntity();
        this.ownerFlowViewImpl.setFlowStateNew();
        return JSF_PAGE;
    }

    @Override
    public String saveNew() {
        log.info("saveNew");
        this.saveNewEntity();
        this.ownerFlowViewImpl.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String cancelNew() {
        log.info("cancelNew");
        this.ownerFlowViewImpl.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String cancelOwnerPetVisitNew() {
        log.info("cancelOwnerPetVisitNew");
        this.reloadEntityFromSelected();
        this.ownerFlowViewImpl.setFlowStateEdit();
        return JSF_PAGE;
    }

    @Override
    public String showOwnerEditForm() {
        log.info("showOwnerEditForm");
        if (this.reloadEntityFromSelected()) {
            this.ownerFlowViewImpl.setFlowStateEdit();
        } else {
            this.ownerFlowViewImpl.setFlowStateList();
        }
        return JSF_PAGE;
    }

    @Override
    public String showEditForm() {
        log.info("showEditForm");
        this.reloadEntityFromSelected();
        this.ownerFlowViewImpl.setFlowStateEdit();
        return JSF_PAGE;
    }

    @Override
    public String cancelEdited() {
        log.info("cancelEdited");
        this.ownerFlowViewImpl.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String saveEdited() {
        log.info("saveEdited");
        this.saveEditedEntity();
        this.ownerFlowViewImpl.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String showDeleteForm() {
        log.info("showDeleteForm");
        if (this.reloadEntityFromSelected()) {
            this.ownerFlowViewImpl.setFlowStateDelete();
        } else {
            this.ownerFlowViewImpl.setFlowStateList();
        }
        return JSF_PAGE;
    }

    @Override
    public String cancelDelete() {
        log.info("cancelDelete");
        this.ownerFlowViewImpl.setFlowStateList();
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
            this.ownerFlowViewImpl.setFlowStateList();
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.delete.done";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            flashMessagesView.addInfoMessage(summary, selectedPrimaryKey);
        } catch (EJBException e) {
            this.ownerFlowViewImpl.setFlowStateDelete();
            flashMessagesView.addWarnMessage(e, this.selected);
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
        this.ownerFlowViewImpl.setFlowStateNewPet();
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
            flashMessagesView.addInfoMessage(summary, this.pet);
            this.ownerFlowViewImpl.setFlowStateEdit();
        } catch (EJBException e) {
            this.ownerFlowViewImpl.setFlowStateNewPet();
            flashMessagesView.addWarnMessage(e, this.pet);
        }
        return JSF_PAGE;
    }

    @Override
    public String cancelOwnerPetNew() {
        log.info("cancelOwnerPetNew");
        this.ownerFlowViewImpl.setFlowStateEdit();
        this.reloadEntityFromSelected();
        return JSF_PAGE;
    }

    @Override
    public String showOwnerPetEditForm() {
        log.info("showOwnerPetEditForm");
        if (this.petSelected != null) {
            this.pet = petService.findById(this.petSelected.getId());
            this.ownerFlowViewImpl.setFlowStateEditPet();
            return JSF_PAGE;
        } else {
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.pet.choose.summary";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            String msgKey = "org.woehlke.jakartaee.petclinic.owner.pet.choose.detail";
            String msg = this.messageProvider.getBundle().getString(msgKey);
            flashMessagesView.addWarnMessage(summary, msg);
            this.ownerFlowViewImpl.setFlowStateEdit();
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
            flashMessagesView.addInfoMessage(summary, this.pet);
            this.ownerFlowViewImpl.setFlowStateEdit();
        } catch (EJBException e) {
            this.ownerFlowViewImpl.setFlowStateEditPet();
            flashMessagesView.addWarnMessage(e, this.pet);
        }
        return JSF_PAGE;
    }

    @Override
    public String cancelOwnerPetEdit() {
        log.info("cancelOwnerPetEdit");
        this.reloadEntityFromSelected();
        this.ownerFlowViewImpl.setFlowStateEdit();
        return JSF_PAGE;
    }

    @Override
    public String editOwnerPetVisitNewForm() {
        log.info("editOwnerPetVisitNewForm");
        if (this.petSelected != null) {
            this.pet = petService.findById(this.petSelected.getId());
            this.petTypeId = this.pet.getType().getId();
            this.visit = new Visit();
            this.ownerFlowViewImpl.setFlowStateNewVisit();
            return JSF_PAGE;
        } else {
            String summaryKey = "org.woehlke.jakartaee.petclinic.owner.pet.choose.summary";
            String summary = this.messageProvider.getBundle().getString(summaryKey);
            String msgKey = "org.woehlke.jakartaee.petclinic.owner.pet.choose.detail";
            String msg = this.messageProvider.getBundle().getString(msgKey);
            flashMessagesView.addWarnMessage(summary, msg);
            this.ownerFlowViewImpl.setFlowStateEdit();
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
                flashMessagesView.addInfoMessage(summary, this.visit);
            } else {
                String summaryKey = "org.woehlke.jakartaee.petclinic.owner.pet.visit.addNew";
                String summary = this.messageProvider.getBundle().getString(summaryKey);
                String msgKey = "org.woehlke.jakartaee.petclinic.owner.pet.visit.addNew.denied";
                String msg = this.messageProvider.getBundle().getString(msgKey);
                flashMessagesView.addWarnMessage(summary, msg);
            }
            this.reloadEntityFromSelected();
            this.ownerFlowViewImpl.setFlowStateEdit();
            return JSF_PAGE;
        } catch (EJBException e) {
            this.ownerFlowViewImpl.setFlowStateNewVisit();
            flashMessagesView.addWarnMessage(e, this.visit);
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
        if (this.ownerFlowViewImpl.isFlowStateSearchResult()) {
            performSearch();
        } else {
            loadList();
        }
        this.flashMessagesView.flashTheMessages();
        return list;
    }

    @Override
    public ResourceBundle getMsg() {
        return this.messageProvider.getBundle();
    }

    public void setMsg(ResourceBundle msg) {}

    @Override
    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: " + OwnerViewImpl.class.getSimpleName());
        this.messageProvider = new MessageProvider();
        this.ownerFlowViewImpl.setFlowStateList();
    }
}
