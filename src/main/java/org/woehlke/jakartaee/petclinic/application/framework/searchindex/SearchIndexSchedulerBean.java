package org.woehlke.jakartaee.petclinic.application.framework.searchindex;

//import lombok.extern.log4j.Log4j2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.java.Log;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 */
@Log
@Startup
@Singleton
@ApplicationScoped
public class SearchIndexSchedulerBean implements Serializable {

    private static final long serialVersionUID = 8425286360447275162L;

    @EJB
    private SearchIndexService searchIndexService;

    @Schedules({
            @Schedule(
                    minute = "15",
                    persistent = false
            )
    })
    public void automaticallyScheduled() {
        LocalDateTime now = LocalDateTime.now();
        log.info("automaticallyScheduled: " + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        searchIndexService.resetSearchIndex();
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+SearchIndexSchedulerBean.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy");
    }

    @PrePassivate
    public void prePassivate() {
        log.info("prePassivate");
    }

    @PostActivate
    public void postActivate() {
        log.info("postActivate");
    }
}
