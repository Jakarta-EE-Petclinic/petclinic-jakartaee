package org.woehlke.jakartaee.petclinic.application.views.impl;

import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.application.views.FlashMessagesView;
import org.woehlke.jakartaee.petclinic.application.framework.entity.EntityBase;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Log
@Named("flashMessagesView")
@SessionScoped
public class FlashMessagesViewImpl implements FlashMessagesView {

    private static final long serialVersionUID = -2267751568724878682L;

    //TODO: Table:  FacesMessage.SEVERITY_INFO -> Logging Severity -> Color Frontend

    public void addInfoMessage(String summary, String detail) {
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_INFO;
        String clientId = null;
        this.addMessage(messageSeverity, summary, detail, clientId);
    }

    public void addWarnMessage(String summary, String detail) {
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_WARN;
        String clientId = null;
        this.addMessage(messageSeverity, summary, detail, clientId);
    }

    public void addErrorMessage(String summary, String detail) {
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_ERROR;
        String clientId = null;
        this.addMessage(messageSeverity, summary, detail, clientId);
    }

    public void addFatalMessage(String summary, String detail) {
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_FATAL;
        String clientId = null;
        this.addMessage(messageSeverity, summary, detail, clientId);
    }

    @Override
    public void addInfoMessage(String summary, EntityBase entity) {
        String clientId = null;
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_INFO;
        this.addMessageForEntity(summary, entity, clientId, messageSeverity);
    }

    @Override
    public void addWarnMessage(String summary, EntityBase entity) {
        String clientId = null;
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_WARN;
        this.addMessageForEntity(summary, entity, clientId, messageSeverity);
    }

    @Override
    public void addErrorMessage(String summary, EntityBase entity) {
        String clientId = null;
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_ERROR;
        this.addMessageForEntity(summary, entity, clientId, messageSeverity);
    }

    @Override
    public void addFatalMessage(String summary, EntityBase entity) {
        String clientId = null;
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_FATAL;
        this.addMessageForEntity(summary, entity, clientId, messageSeverity);
    }

    @Override
    public void addInfoMessage(RuntimeException e, EntityBase entity) {
        String clientId = null;
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_INFO;
        this.addMessageForEntityAndRuntimeException(e, entity, clientId, messageSeverity);
    }

    @Override
    public void addWarnMessage(RuntimeException e, EntityBase entity) {
        String clientId = null;
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_WARN;
        this.addMessageForEntityAndRuntimeException(e, entity, clientId, messageSeverity);
    }

    @Override
    public void addErrorMessage(RuntimeException e, EntityBase entity) {
        String clientId = null;
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_ERROR;
        this.addMessageForEntityAndRuntimeException(e, entity, clientId, messageSeverity);
    }

    @Override
    public void addFatalMessage(RuntimeException e, EntityBase entity) {
        String clientId = null;
        FacesMessage.Severity messageSeverity = FacesMessage.SEVERITY_FATAL;
        this.addMessageForEntityAndRuntimeException(e, entity, clientId, messageSeverity);
    }


    //TODO: simplify
    //TODO: display all flash messeges
    private void doLogging(
            List<String> logInfos,
            FacesMessage.Severity messageSeverity
    ) {
        if (!logInfos.isEmpty()) {
            int first = 0;
            String firstLine = logInfos.remove(first);
            if (messageSeverity.equals(FacesMessage.SEVERITY_INFO)) {
                log.info(firstLine);
            }
            if (messageSeverity.equals(FacesMessage.SEVERITY_WARN)) {
                log.info(firstLine);
            }
            if (messageSeverity.equals(FacesMessage.SEVERITY_ERROR)) {
                log.info(firstLine);
            }
            if (messageSeverity.equals(FacesMessage.SEVERITY_FATAL)) {
                log.info(firstLine);
            }
            for (String logInfo : logInfos) {
                log.info(logInfo);
            }
        }
    }

    private void addMessageForEntity(
            String summary,
            EntityBase entity,
            String clientId,
            FacesMessage.Severity messageSeverity
    ) {
        List<String> logInfos = new ArrayList<>();
        logInfos.add("summary:           " + summary);
        String detail = "";
        if (entity != null) {
            logInfos.add("addFrontendMessageForEntity.PrimaryKey: " + entity.getPrimaryKey());
            logInfos.add("addFrontendMessageForEntity.id:         " + entity.getId());
            logInfos.add("addFrontendMessageForEntity.uud:        " + entity.getUuid());
            if (clientId != null) {
                logInfos.add("addFrontendMessageForEntity.clientId:   " + clientId);
            }
            detail = entity.getPrimaryKey();
        } else {
            String msg = "entity == null ";
            logInfos.add(msg);
            detail = msg;
        }
        this.doLogging(logInfos, messageSeverity);
        this.addMessage(messageSeverity, summary, detail, clientId);
    }

    private void addMessageForEntityAndRuntimeException(
            RuntimeException e,
            EntityBase entity,
            String clientId,
            FacesMessage.Severity messageSeverity
    ) {
        String summary = e.getLocalizedMessage();
        StringBuilder sb1 = new StringBuilder("\n");
        sb1.append("-----------------------------------------------------\n");
        sb1.append("entity Table       " + entity.getTableName() + "\n");
        sb1.append("entity Class       " + entity.getClass().getName() + "\n");
        sb1.append("entity UUID        " + entity.getUuid() + "\n");
        sb1.append("entity ID          " + entity.getId() + "\n");
        sb1.append("entity PK          " + entity.getPrimaryKey() + "\n");
        sb1.append("-----------------------------------------------------\n");
        sb1.append("RuntimeException Class   " + e.getClass().getName() + "\n");
        sb1.append("RuntimeException Message " + e.getLocalizedMessage() + "\n");
        sb1.append("Exception Cause Class    " + e.getCause().getClass().getName() + "\n");
        sb1.append("Exception Cause Message   " + e.getCause().getLocalizedMessage() + "\n");
        sb1.append("-----------------------------------------------------\n");
        StringBuilder sb = new StringBuilder("\n");
        long i = 0L;
        for (StackTraceElement element : e.getStackTrace()) {
            i++;
            StringBuilder lfdnr = new StringBuilder();
            if (i < 10) {
                lfdnr.append(" ");
            }
            if (i < 100) {
                lfdnr.append(" ");
            }
            lfdnr.append(i);
            sb.append("StackTrace[" + lfdnr.toString() + "]: " + element.getClassName());
            sb.append(" . " + element.getMethodName() + " in: \n");
            sb.append("StackTrace[" + lfdnr.toString() + "]: " + element.getFileName());
            sb.append(" ( Line " + element.getLineNumber() + ")\n");
        }
        sb.append("-----------------------------------------------------\n");
        List<String> logInfos = new ArrayList<>();
        logInfos.add(sb.toString());
        logInfos.add(sb1.toString());
        this.doLogging(logInfos, messageSeverity);
        this.addMessageForEntity(summary, entity, clientId, messageSeverity);
    }

    private void addMessage(
            FacesMessage.Severity messageSeverity,
            String summary,
            String detail,
            String clientId
    ) {
        List<String> logInfos = new ArrayList<>();
        logInfos.add("addFrontendMessage.summary:   " + summary);
        logInfos.add("addFrontendMessage.detail:    " + detail);
        if (clientId != null) {
            logInfos.add("addFrontendMessage.clientId:  " + clientId);
        }
        this.doLogging(logInfos, messageSeverity);

        // TODO: Store messages in Session and display them
        FacesMessage message = new FacesMessage(messageSeverity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(clientId, message);
    }


    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+ FlashMessagesViewImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+ FlashMessagesViewImpl.class.getSimpleName());
    }

}
