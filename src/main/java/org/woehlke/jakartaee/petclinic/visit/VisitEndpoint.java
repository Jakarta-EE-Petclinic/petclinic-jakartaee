package org.woehlke.jakartaee.petclinic.visit;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.JAXBException;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.visit.db.VisitService;
import org.woehlke.jakartaee.petclinic.visit.api.VisitEndpointUtil;

import java.io.Serializable;

/**
 *
 */
@Log
@Path("/visit")
@Stateless
public class VisitEndpoint implements Serializable {

    private static final long serialVersionUID = 7444366391126982311L;

    @EJB
    private VisitService visitService;

    private final VisitEndpointUtil visitEndpointUtil = new VisitEndpointUtil();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        log.info("getList");
        return this.visitEndpointUtil.dtoListJsonFactory(visitEndpointUtil.dtoListFactory(visitService.getAll()));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntity(@PathParam("id") Long id) {
        log.info("getEntity");
        return this.visitEndpointUtil.dtoJsonFactory(visitEndpointUtil.dtoFactory(visitService.findById(id)));
    }

    @GET
    @Path("/xml/list")
    @Produces(MediaType.APPLICATION_XML)
    public String getListAsXml() throws JAXBException {
        log.info("getListAsXml");
        return this.visitEndpointUtil.dtoListXmlFactory(visitEndpointUtil.dtoListFactory(visitService.getAll()));
    }

    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getEntityAsXml(@PathParam("id") Long id) throws JAXBException {
        log.info("getEntityAsXml");
        return this.visitEndpointUtil.dtoXmlFactory(visitEndpointUtil.dtoFactory(visitService.findById(id)));
    }

}
