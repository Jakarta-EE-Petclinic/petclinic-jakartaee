package org.woehlke.jakartaee.petclinic.owner.api;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.OwnerService;

import java.io.Serializable;

/**
 *
 */
@Log
@Path("/owner")
@ApplicationScoped
public class OwnerEndpoint implements Serializable {

    private static final long serialVersionUID = 532726561254887897L;

    @EJB
    private OwnerService ownerService;

    @Inject
    private OwnerEndpointUtil ownerEndpointUtil;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        log.info("getList");
        return ownerEndpointUtil.dtoListJsonFactory(ownerEndpointUtil.dtoListFactory(ownerService.getAll()));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntity(@PathParam("id") Long id) {
        log.info("getEntity");
        return ownerEndpointUtil.dtoJsonFactory(ownerEndpointUtil.dtoFactory(ownerService.findById(id)));
    }

    @GET
    @Path("/xml/list")
    @Produces(MediaType.APPLICATION_XML)
    public String getListAsXml() throws JAXBException {
        log.info("getListAsXml");
        return ownerEndpointUtil.dtoListXmlFactory(ownerEndpointUtil.dtoListFactory(ownerService.getAll()));
    }

    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getEntityAsXml(@PathParam("id") Long id) throws JAXBException {
        log.info("getEntityAsXml");
        return ownerEndpointUtil.dtoXmlFactory(ownerEndpointUtil.dtoFactory(ownerService.findById(id)));
    }

}
