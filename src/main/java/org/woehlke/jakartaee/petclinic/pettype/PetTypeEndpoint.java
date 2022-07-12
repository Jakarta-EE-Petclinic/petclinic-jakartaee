package org.woehlke.jakartaee.petclinic.pettype;

import jakarta.ejb.EJB;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.*;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pettype.api.PetTypeEndpointUtil;

import java.io.Serializable;

@Log
@Path("/petType")
@Stateless
public class PetTypeEndpoint implements Serializable {

    private static final long serialVersionUID = -105453087511255998L;

    @EJB
    private PetTypeService petTypeService;

    private final PetTypeEndpointUtil petTypeEndpointUtil = new PetTypeEndpointUtil();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        log.info("getList");
        return this.petTypeEndpointUtil.dtoListJsonFactory(petTypeEndpointUtil.dtoListFactory(petTypeService.getAll()));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntity(@PathParam("id") Long id) {
        log.info("getEntity");
        return this.petTypeEndpointUtil.dtoJsonFactory(petTypeEndpointUtil.dtoFactory(petTypeService.findById(id)));
    }

    @GET
    @Path("/xml/list")
    @Produces(MediaType.APPLICATION_XML)
    public String getListAsXml() throws JAXBException {
        log.info("getListAsXml");
        return this.petTypeEndpointUtil.dtoListXmlFactory(petTypeEndpointUtil.dtoListFactory(petTypeService.getAll()));
    }

    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getEntityAsXml(@PathParam("id") Long id) throws JAXBException {
        log.info("getEntityAsXml");
        return this.petTypeEndpointUtil.dtoXmlFactory(petTypeEndpointUtil.dtoFactory(petTypeService.findById(id)));
    }

}
