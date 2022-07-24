package org.woehlke.jakartaee.petclinic.specialty;


import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.JAXBException;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.specialty.api.SpecialtyEndpointUtil;
import org.woehlke.jakartaee.petclinic.specialty.db.SpecialtyService;

import java.io.Serializable;

/**
 *
 */
@Log
@Path("/specialty")
@Stateless
public class SpecialtyEndpoint implements Serializable {

    private static final long serialVersionUID = 607664665910620584L;

    @EJB
    private SpecialtyService specialtyService;

    private final SpecialtyEndpointUtil specialtyEndpointUtil = new SpecialtyEndpointUtil();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        log.info("getList");
        return this.specialtyEndpointUtil.dtoListJsonFactory(specialtyEndpointUtil.dtoListFactory(specialtyService.getAll()));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntity(@PathParam("id") Long id) {
        log.info("getEntity");
        return this.specialtyEndpointUtil.dtoJsonFactory(specialtyEndpointUtil.dtoFactory(specialtyService.findById(id)));
    }

    @GET
    @Path("/xml/list")
    @Produces(MediaType.APPLICATION_XML)
    public String getListAsXml() throws JAXBException {
        log.info("getListAsXml");
        return this.specialtyEndpointUtil.dtoListXmlFactory(specialtyEndpointUtil.dtoListFactory(specialtyService.getAll()));
    }

    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getEntityAsXml(@PathParam("id") Long id) throws JAXBException {
        log.info("getEntityAsXml");
        return this.specialtyEndpointUtil.dtoXmlFactory(specialtyEndpointUtil.dtoFactory(specialtyService.findById(id)));
    }
}
