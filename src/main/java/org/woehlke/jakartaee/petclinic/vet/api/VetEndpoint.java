package org.woehlke.jakartaee.petclinic.vet.api;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.JAXBException;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.vet.VetService;


import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 05.01.14
 * Time: 09:27
 * To change this template use File | Settings | File Templates.
 */
@Log
@Path("/vet")
@ApplicationScoped
public class VetEndpoint implements Serializable {

    private static final long serialVersionUID = 607664665910620584L;

    @EJB
    private VetService vetService;

    private final VetEndpointUtil vetEndpointUtil = new VetEndpointUtil();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        log.info("getList");
        return this.vetEndpointUtil.dtoListJsonFactory(vetEndpointUtil.dtoListFactory(vetService.getAll()));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntity(@PathParam("id") Long id) {
        log.info("getEntity");
        return this.vetEndpointUtil.dtoJsonFactory(vetEndpointUtil.dtoFactory(vetService.findById(id)));
    }

    @GET
    @Path("/xml/list")
    @Produces(MediaType.APPLICATION_XML)
    public String getListAsXml() throws JAXBException {
        log.info("getListAsXml");
        return this.vetEndpointUtil.dtoListXmlFactory(vetEndpointUtil.dtoListFactory(vetService.getAll()));
    }

    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getEntityAsXml(@PathParam("id") Long id) throws JAXBException {
        log.info("getEntityAsXml");
        return this.vetEndpointUtil.dtoXmlFactory(vetEndpointUtil.dtoFactory(vetService.findById(id)));
    }

}
