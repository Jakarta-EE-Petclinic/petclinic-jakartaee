package org.woehlke.jakartaee.petclinic.pettype.api;

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
import jakarta.xml.bind.*;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pettype.PetTypeService;

import java.io.Serializable;
import java.io.StringWriter;

@Log
@Path("/petType")
@ApplicationScoped
public class PetTypeEndpoint implements Serializable {

    private static final long serialVersionUID = -105453087511255998L;

    @EJB
    private PetTypeService petTypeService;

    @Inject
    private PetTypeEndpointUtil petTypeEndpointUtil;

    private String dtoJsonFactory(PetTypeDto dto) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(dto);
    }

    private String dtoListJsonFactory(PetTypeListDto petTypeListDto) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(petTypeListDto);
    }

    private String dtoXmlFactory(PetTypeDto dto) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(PetTypeDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(dto, stringWriter);
        return stringWriter.toString();
    }

    private String dtoListXmlFactory(PetTypeListDto petTypeListDto) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(PetTypeListDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(petTypeListDto, stringWriter);
        return stringWriter.toString();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        log.info("getList");
        return this.dtoListJsonFactory(petTypeEndpointUtil.dtoListFactory(petTypeService.getAll()));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntity(@PathParam("id") Long id) {
        log.info("getEntity");
        return this.dtoJsonFactory(petTypeEndpointUtil.dtoFactory(petTypeService.findById(id)));
    }

    @GET
    @Path("/xml/list")
    @Produces(MediaType.APPLICATION_XML)
    public String getListAsXml() throws JAXBException {
        log.info("getListAsXml");
        return this.dtoListXmlFactory(petTypeEndpointUtil.dtoListFactory(petTypeService.getAll()));
    }

    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getEntityAsXml(@PathParam("id") Long id) throws JAXBException {
        log.info("getEntityAsXml");
        return this.dtoXmlFactory(petTypeEndpointUtil.dtoFactory(petTypeService.findById(id)));
    }

}
