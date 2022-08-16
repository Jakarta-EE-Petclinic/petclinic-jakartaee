package org.woehlke.jakartaee.petclinic.pet;


import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.JAXBException;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pet.api.PetListDto;
import org.woehlke.jakartaee.petclinic.pet.db.PetService;
import org.woehlke.jakartaee.petclinic.pet.api.PetDto;
import org.woehlke.jakartaee.petclinic.pet.api.PetEndpointUtil;

import java.io.Serializable;

/**
 *
 */
@Log
@Path("/pet")
@Stateless
public class PetEndpoint implements Serializable {

    private static final long serialVersionUID = 6505290301528514574L;

    @EJB
    private PetService petService;

    private final PetEndpointUtil petEndpointUtil = new PetEndpointUtil();

    private String dtoJsonFactory(PetDto dto) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(dto);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public PetListDto getList() {
        log.info("getList");
        return this.petEndpointUtil.dtoListFactory(petService.getAll());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PetDto getEntity(@PathParam("id") Long id) {
        log.info("getEntity");
        return this.petEndpointUtil.dtoFactory(petService.findById(id));
    }

    @GET
    @Path("/list+json")
    @Produces(MediaType.APPLICATION_JSON)
    public PetListDto getListAsJson() {
        log.info("getList");
        return this.petEndpointUtil.dtoListFactory(petService.getAll());
    }

    @GET
    @Path("/{id}+json")
    @Produces(MediaType.APPLICATION_JSON)
    public PetDto getEntityAsJson(@PathParam("id") Long id) {
        log.info("getEntity");
        return this.petEndpointUtil.dtoFactory(petService.findById(id));
    }

    @GET
    @Path("/list+xml")
    @Produces(MediaType.APPLICATION_XML)
    public PetListDto getListAsXml() throws JAXBException {
        log.info("getListAsXml");
        return this.petEndpointUtil.dtoListFactory(petService.getAll());
    }

    @GET
    @Path("/{id}+xml")
    @Produces(MediaType.APPLICATION_XML)
    public PetDto getEntityAsXml(@PathParam("id") Long id) throws JAXBException {
        log.info("getEntityAsXml");
        return this.petEndpointUtil.dtoFactory(petService.findById(id));
    }

}
