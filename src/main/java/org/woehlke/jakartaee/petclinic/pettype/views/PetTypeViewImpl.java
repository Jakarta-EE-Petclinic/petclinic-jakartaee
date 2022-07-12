package org.woehlke.jakartaee.petclinic.pettype.views;


import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.ejb.EJBTransactionRolledbackException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.application.messages.MessageProvider;
import org.woehlke.jakartaee.petclinic.application.views.FlashMessagesView;
import org.woehlke.jakartaee.petclinic.application.views.LanguageView;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.pettype.PetTypeService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.woehlke.jakartaee.petclinic.pettype.PetTypeView;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Fert
 * Date: 06.01.14
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */
@Log
@Named("petTypeView")
@SessionScoped
@Getter
@Setter
public class PetTypeViewImpl implements PetTypeView {

    private static final long serialVersionUID = -528406859430949031L;

    private MessageProvider provider;

    @EJB
    private PetTypeService entityService;

    @Inject
    private LanguageView languageView;

    @Inject
    private FlashMessagesView flashMessagesView;

    @Inject
    private PetTypeFlowViewImpl petTypeViewFlow;


    private PetType entity;
    private List<PetType> list;
    private String searchterm;


    @Override
    public String showDetailsForm(PetType o) {
        log.info("showDetailsForm");;
        if (o != null) {
            this.entity = entityService.findById(o.getId());
            this.petTypeViewFlow.setFlowStateDetails();
        } else {
            this.petTypeViewFlow.setFlowStateList();
        }
        return JSF_PAGE;
    }

    @Override
    public  String cancelDetails(){
        log.info("cancelDetails");
        this.petTypeViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String showNewForm() {
        log.info("showNewForm");
        this.newEntity();
        this.petTypeViewFlow.setFlowStateNew();
        return JSF_PAGE;
    }

    @Override
    public String cancelNew() {
        log.info("cancelNew");
        this.petTypeViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String saveNew() {
        log.info("saveNew");
        this.saveNewEntity();
        this.petTypeViewFlow.setFlowStateDetails();
        return JSF_PAGE;
    }

    @Override
    public String showEditForm() {
        log.info("showEditForm");
        if (this.entity != null) {
            this.petTypeViewFlow.setFlowStateEdit();
        } else {
            this.petTypeViewFlow.setFlowStateList();
        }
        return JSF_PAGE;
    }

    @Override
    public String cancelEdited() {
        log.info("cancelEdited");
        this.petTypeViewFlow.setFlowStateDetails();
        return JSF_PAGE;
    }

    @Override
    public String saveEdited() {
        log.info("saveEdited");
        this.saveEditedEntity();
        this.petTypeViewFlow.setFlowStateDetails();
        return JSF_PAGE;
    }

    @Override
    public String showDeleteForm() {
        log.info("showDeleteForm");
        if (this.entity != null) {
            this.petTypeViewFlow.setFlowStateDelete();
        } else {
            this.petTypeViewFlow.setFlowStateList();
        }
        return JSF_PAGE;
    }

    @Override
    public String cancelDelete() {
        log.info("cancelDelete");
        this.petTypeViewFlow.setFlowStateDetails();
        return JSF_PAGE;
    }

    @Override
    public String performDelete() {
        log.info("performDelete");
        this.deleteSelectedEntity();
        this.petTypeViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String search() {
        this.performSearch();
        return JSF_PAGE;
    }

    @Override
    public String clearSearchterm(){
        log.info("clearSearchterm");
        this.searchterm = null;
        return JSF_PAGE;
    }

    @Override
    public PetType getEntity() {
        if (entity == null) {
            newEntity();
        }
        return entity;
    }

    @Override
    public void newEntity() {
        log.info("newEntity");
        this.entity = new PetType();
    }

    @Override
    public void saveNewEntity() {
        log.info("saveNewEntity");
        try {
            log.info((this.entity != null) ? this.entity.toString() : "null");
            this.entity = this.entityService.addNew(this.entity);
            log.info((this.entity != null) ? this.entity.toString() : "null");
            this.petTypeViewFlow.setFlowStateDetails();
            String summaryKey = "org.woehlke.jakartaee.petclinic.petType.addNew.done";
            String summary = this.provider.getBundle().getString(summaryKey);
            flashMessagesView.addInfoMessage(summary, this.entity.getPrimaryKey());
        } catch (EJBException e) {
            this.petTypeViewFlow.setFlowStateNew();
            log.info(e.getMessage() + this.entity.toString());
            flashMessagesView.addWarnMessage(e, this.entity);
        }
    }

    @Override
    public void saveEditedEntity() {
        log.info("saveEditedEntity");
        try {
            log.info((this.entity != null) ? this.entity.toString() : "null");
            this.entity = this.entityService.update(this.entity);
            log.info((this.entity != null) ? this.entity.toString() : "null");
            this.petTypeViewFlow.setFlowStateDetails();
            String summaryKey = "org.woehlke.jakartaee.petclinic.petType.edit.done";
            String summary = this.provider.getBundle().getString(summaryKey);
            flashMessagesView.addInfoMessage(summary, this.entity.getPrimaryKey());
        } catch (EJBException e) {
            this.petTypeViewFlow.setFlowStateEdit();
            log.info(e.getMessage() + this.entity.toString());
        }
    }

    @Override
    public void deleteSelectedEntity() {
        log.info("deleteSelectedEntity");
        try {
            if (this.entity != null) {
                String msgInfo = this.entity.getPrimaryKey();
                entityService.delete(this.entity.getId());
                this.entity = null;
                String summaryKey = "org.woehlke.jakartaee.petclinic.petType.delete.done";
                String summary = this.provider.getBundle().getString(summaryKey);
                flashMessagesView.addInfoMessage(summary, msgInfo);
                this.petTypeViewFlow.setFlowStateList();
            }
            this.petTypeViewFlow.setFlowStateList();
        } catch (EJBTransactionRolledbackException e) {
            this.petTypeViewFlow.setFlowStateDelete();
            String summaryKey = "org.woehlke.jakartaee.petclinic.petType.delete.denied";
            String summary = this.provider.getBundle().getString(summaryKey);
            flashMessagesView.addWarnMessage(summary, this.entity);
        } catch (EJBException e) {
            this.petTypeViewFlow.setFlowStateDelete();
            flashMessagesView.addErrorMessage(e.getLocalizedMessage(), this.entity);
        }
    }

    @Override
    public void performSearch() {
        String summaryKey = "org.woehlke.jakartaee.petclinic.petType.search.done";
        String summary = this.provider.getBundle().getString(summaryKey);
        if (searchterm == null || searchterm.isEmpty()) {
            this.petTypeViewFlow.setFlowStateList();
            String missingKey = "org.woehlke.jakartaee.petclinic.list.searchterm.missing";
            String detail = this.provider.getBundle().getString(missingKey);
            flashMessagesView.addInfoMessage(summary, detail);
        } else {
            this.petTypeViewFlow.setFlowStateSearchResult();
            this.list = entityService.search(searchterm);
            String foundKey = "org.woehlke.jakartaee.petclinic.list.searchterm.found";
            String resultsKey = "org.woehlke.jakartaee.petclinic.list.searchterm.results";
            String found = this.provider.getBundle().getString(foundKey);
            String results = this.provider.getBundle().getString(resultsKey);
            String detail = found + " " + this.list.size() + " " + results + " " + searchterm;
            flashMessagesView.addInfoMessage(summary, detail);
        }
    }

    public List<PetType> getList() {
        if (this.petTypeViewFlow.isFlowStateSearchResult()) {
            performSearch();
        } else {
            loadList();
        }
        this.flashMessagesView.flashTheMessages();
        return list;
    }

    @Override
    public void loadList() {
        this.list = this.entityService.getAll();
    }


    public ResourceBundle getMsg() {
        return this.provider.getBundle();
    }

    public void setMsg(ResourceBundle msg) {
    }

    @Override
    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: " + PetTypeViewImpl.class.getSimpleName());
        this.provider = new MessageProvider();
        this.petTypeViewFlow.setFlowStateList();
    }

    @Override
    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy");
    }

}
