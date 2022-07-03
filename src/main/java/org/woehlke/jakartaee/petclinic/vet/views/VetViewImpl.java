package org.woehlke.jakartaee.petclinic.vet.views;

import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import lombok.extern.java.Log;
import org.primefaces.model.DualListModel;
import org.woehlke.jakartaee.petclinic.application.config.messages.MessageProvider;
import org.woehlke.jakartaee.petclinic.application.views.FrontendMessagesView;
import org.woehlke.jakartaee.petclinic.application.views.LanguageView;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;
import org.woehlke.jakartaee.petclinic.vet.Vet;
import org.woehlke.jakartaee.petclinic.specialty.SpecialtyService;
import org.woehlke.jakartaee.petclinic.vet.VetService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.ejb.EJBTransactionRolledbackException;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 01.01.14
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
@Log
@Named("vetView")
@SessionScoped
public class VetViewImpl implements VetView {

    private static final long serialVersionUID = 2838339162976374606L;

    private final static String JSF_PAGE = "veterinarian.jsf";

    private MessageProvider provider;

    @Inject
    private SecurityContext securityContext;

    @Inject
    private LanguageView languageView;

    @Inject
    private FrontendMessagesView frontendMessagesView;

    @Inject
    private VetViewFlow vetViewFlow;

    @EJB
    private SpecialtyService specialtyService;

    @EJB
    private VetService entityService;

    private Vet entity;
    private Vet selected;
    private List<Vet> list;

    private String searchterm;

    private DualListModel<Specialty> specialtiesPickList;

    @Override
    @PostConstruct
    public void init() {
        log.info("postConstruct: " + VetViewImpl.class.getSimpleName());
        this.provider = new MessageProvider();
        this.vetViewFlow.setFlowStateList();
        loadList();
        initSpecialtiesPickList();
    }

    private void initSpecialtiesPickList() {
        log.info("initSpecialtiesPickList");
        List<Specialty> srcList = specialtyService.getAll();
        List<Specialty> targetList = new ArrayList<>();
        this.specialtiesPickList = new DualListModel<Specialty>(srcList, targetList);
    }

    private void resetSpecialtiesPickList() {
        log.info("resetSpecialtiesPickList");
        List<Specialty> srcList = new ArrayList<>();
        List<Specialty> targetList = new ArrayList<>();
        for (Specialty specialty : this.entity.getSpecialties()) {
            targetList.add(specialty);
        }
        for (Specialty specialty : this.specialtyService.getAll()) {
            if (!targetList.contains(specialty)) {
                srcList.add(specialty);
            }
        }
        this.specialtiesPickList = new DualListModel<>(srcList, targetList);
    }


    @Override
    public DualListModel<Specialty> getSpecialtiesPickList() {
        return specialtiesPickList;
    }

    @Override
    public void setSpecialtiesPickList(DualListModel<Specialty> specialtiesPickList) {
        this.specialtiesPickList = specialtiesPickList;
    }


    @Override
    public Specialty findSpecialtyByName(String name) {
        return specialtyService.findSpecialtyByName(name);
    }

    @Override
    public Vet getEntity() {
        return entity;
    }

    @Override
    public void setEntity(Vet entity) {
        this.entity = entity;
    }

    @Override
    public Vet getSelected() {
        return selected;
    }

    @Override
    public void setSelected(Vet selected) {
        this.selected = selected;
    }

    public FrontendMessagesView getFrontendMessagesView() {
        return frontendMessagesView;
    }

    public void setFrontendMessagesView(FrontendMessagesView frontendMessagesView) {
        this.frontendMessagesView = frontendMessagesView;
    }

    @Override
    public ResourceBundle getMsg() {
        return this.provider.getBundle();
    }

    public void setMsg(ResourceBundle msg) {
    }

    @Override
    public String showNewForm() {
        log.info("showNewForm");
        this.newEntity();
        this.initSpecialtiesPickList();
        this.vetViewFlow.setFlowStateNew();
        return JSF_PAGE;
    }

    @Override
    public String saveNew() {
        log.info("saveNew");
        this.saveNewEntity();
        this.vetViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String cancelNew() {
        log.info("cancelNew");
        this.vetViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public List<Vet> getList() {
        if (this.vetViewFlow.isFlowStateSearchResult()) {
            this.performSearch();
        } else {
            this.loadList();
        }
        return this.list;
    }

    @Override
    public void setList(List<Vet> list) {
        this.list = list;
    }

    @Override
    public String showEditForm() {
        log.info("showEditForm");
        if (this.reloadEntityFromSelected()) {
            this.resetSpecialtiesPickList();
            this.vetViewFlow.setFlowStateEdit();
        } else {
            this.vetViewFlow.setFlowStateList();
        }
        return JSF_PAGE;
    }

    @Override
    public String saveEdited() {
        log.info("saveEdited");
        this.saveEditedEntity();
        this.vetViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String cancelEdited() {
        log.info("cancelEdited");
        this.vetViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String showDeleteForm() {
        log.info("showDeleteForm");
        if (this.reloadEntityFromSelected()) {
            this.vetViewFlow.setFlowStateDelete();
        } else {
            this.vetViewFlow.setFlowStateList();
        }
        return JSF_PAGE;
    }

    @Override
    public String performDelete() {
        log.info("performDelete");
        this.deleteSelectedEntity();
        this.vetViewFlow.setFlowStateList();
        return JSF_PAGE;
    }

    @Override
    public String cancelDelete() {
        log.info("cancelDelete");
        this.vetViewFlow.setFlowStateList();
        return JSF_PAGE;
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
    public String search() {
        log.info("search");
        this.vetViewFlow.setFlowStateSearchResult();
        return JSF_PAGE;
    }

    @Override
    public void performSearch() {
        log.info("performSearch");
        String summaryKey = "org.woehlke.jakartaee.petclinic.veterinarian.search.done";
        String summary = this.provider.getBundle().getString(summaryKey);
        if (searchterm == null || searchterm.isEmpty()) {
            this.vetViewFlow.setFlowStateList();
            String missingKey = "org.woehlke.jakartaee.petclinic.frontend.web.entity.list.searchterm.missing";
            String detail = this.provider.getBundle().getString(missingKey);
            frontendMessagesView.addInfoMessage(summary, detail);
        } else {
            try {
                this.vetViewFlow.setFlowStateSearchResult();
                this.list = entityService.search(searchterm);
                String foundKey = "org.woehlke.jakartaee.petclinic.frontend.web.entity.list.searchterm.found";
                String resultsKey = "org.woehlke.jakartaee.petclinic.frontend.web.entity.list.searchterm.results";
                String found = this.provider.getBundle().getString(foundKey);
                String results = this.provider.getBundle().getString(resultsKey);
                String detail = found + " " + this.list.size() + " " + results + " " + searchterm;
                frontendMessagesView.addInfoMessage(summary, detail);
            } catch (Exception e) {
                this.vetViewFlow.setFlowStateList();
                frontendMessagesView.addWarnMessage(e.getLocalizedMessage(), searchterm);
            }
        }
    }

    @Override
    public LanguageView getLanguageView() {
        return this.languageView;
    }

    @Override
    public void setLanguageView(LanguageView languageView) {
        this.languageView = languageView;
    }

    @Override
    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy");
    }

    @Override
    public boolean reloadEntityFromSelected() {
        log.info("reloadEntityFromSelected");
        if (this.selected != null) {
            this.entity = entityService.findById(this.selected.getId());
            this.selected = this.entity;
            return true;
        } else {
            String summaryKey = "org.woehlke.jakartaee.petclinic.veterinarian.list.choose.summary";
            String summary = this.provider.getBundle().getString(summaryKey);
            String detailKey = "org.woehlke.jakartaee.petclinic.veterinarian.list.choose.detail";
            String detail = this.provider.getBundle().getString(detailKey);
            frontendMessagesView.addWarnMessage(summary, detail);
            return false;
        }
    }

    @Override
    public void loadList() {
        this.list = this.entityService.getAll();
    }

    @Override
    public void saveNewEntity() {
        log.info("saveNewEntity");
        try {
            log.info("try to save New: " + this.entity.toString());
            this.entity.removeSpecialties();
            this.entity.setUuid(UUID.randomUUID());
            this.entity = entityService.addNew(this.entity);
            this.entity = entityService.findById(this.entity.getId());
            log.info("nr source: " + this.specialtiesPickList.getSource().size());
            log.info("nr target: " + this.specialtiesPickList.getTarget().size());
            for (Specialty specialtyTransient : this.specialtiesPickList.getTarget()) {
                Specialty specialty = specialtyService.findSpecialtyByName(specialtyTransient.getName());
                this.entity.addSpecialty(specialty);
            }
            this.entity = entityService.update(this.entity);
            log.info("saved New: " + this.entity.toString());
            this.selected = this.entity;
            String summaryKey = "org.woehlke.jakartaee.petclinic.veterinarian.addNew.done";
            String summary = this.provider.getBundle().getString(summaryKey);
            frontendMessagesView.addInfoMessage(summary, this.entity);
        } catch (EJBException e) {
            log.info(e.getMessage() + this.entity.toString());
            frontendMessagesView.addWarnMessage(e, this.entity);
        }
    }

    @Override
    public void saveEditedEntity() {
        log.info("saveEditedEntity");
        try {
            this.entity.removeSpecialties();
            for (Specialty specialtyTransient : this.specialtiesPickList.getTarget()) {
                log.info(" added transient via saveEditedEntity: " + specialtyTransient.getPrimaryKeyWithId());
                Specialty specialty = specialtyService.findSpecialtyByName(specialtyTransient.getName());
                this.entity.addSpecialty(specialty);
            }
            this.entity = entityService.update(this.entity);
            this.selected = this.entity;
            String summaryKey = "org.woehlke.jakartaee.petclinic.veterinarian.edit.done";
            String summary = this.provider.getBundle().getString(summaryKey);
            frontendMessagesView.addInfoMessage(summary, this.entity);
        } catch (EJBException e) {
            log.info(e.getMessage() + this.entity.toString());
            frontendMessagesView.addWarnMessage(e, this.entity);
        }
    }

    @Override
    public void deleteSelectedEntity() {
        log.info("deleteSelectedEntity");
        try {
            if (this.selected != null) {
                String msgInfo = this.selected.getPrimaryKey();
                boolean same = (this.selected.compareTo(this.entity) == 0);
                long id = this.selected.getId();
                entityService.delete(id);
                if (same) {
                    this.entity = null;
                }
                this.selected = null;
                String summaryKey = "org.woehlke.jakartaee.petclinic.veterinarian.delete.done";
                String summary = this.provider.getBundle().getString(summaryKey);
                frontendMessagesView.addInfoMessage(summary, msgInfo);
            }
            loadList();
        } catch (EJBTransactionRolledbackException e) {
            String summaryKey = "org.woehlke.jakartaee.petclinic.veterinarian.delete.denied";
            String summary = this.provider.getBundle().getString(summaryKey);
            frontendMessagesView.addWarnMessage(summary, this.selected);
        } catch (EJBException e) {
            frontendMessagesView.addErrorMessage(e.getLocalizedMessage(), this.selected);
        }
    }

    @Override
    public void newEntity() {
        log.info("newEntity");
        this.entity = new Vet();
    }

    public VetViewFlow getVetViewFlow() {
        return vetViewFlow;
    }

    public void setVetViewFlow(VetViewFlow vetViewFlow) {
        this.vetViewFlow = vetViewFlow;
    }
}
