package org.woehlke.jakartaee.petclinic.owner.views;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.application.config.messages.MessageProvider;
import org.woehlke.jakartaee.petclinic.application.views.FrontendMessagesView;
import org.woehlke.jakartaee.petclinic.application.views.LanguageView;
import org.woehlke.jakartaee.petclinic.owner.OwnerService;
import org.woehlke.jakartaee.petclinic.pet.PetService;
import org.woehlke.jakartaee.petclinic.pettype.PetTypeService;
import org.woehlke.jakartaee.petclinic.visit.VisitService;

import java.io.Serializable;

@Log
@Named("ownerPageView")
@SessionScoped
public class OwnerPageView implements Serializable {

    private static final long serialVersionUID = -3378330831315654285L;

    private final static String JSF_PAGE = "owner.jsf";

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
    private FrontendMessagesView frontendMessagesView;

    @Inject
    private OwnerViewFlow ownerViewFlow;

    private MessageProvider messageProvider;

    @PostConstruct
    public void init() {
        this.messageProvider = new MessageProvider();
        log.info("postConstruct: "+OwnerPageView.class.getSimpleName());
    }

}
