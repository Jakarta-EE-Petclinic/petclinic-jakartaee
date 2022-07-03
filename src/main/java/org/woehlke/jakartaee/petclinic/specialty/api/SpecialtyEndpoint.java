package org.woehlke.jakartaee.petclinic.specialty.api;


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
import org.woehlke.jakartaee.petclinic.specialty.Specialty;
import org.woehlke.jakartaee.petclinic.specialty.SpecialtyService;

import java.io.Serializable;
import java.io.StringWriter;

/**
 *
 */
@Log
@Path("/specialty")
@ApplicationScoped
public class SpecialtyEndpoint implements Serializable {

    private static final long serialVersionUID = 607664665910620584L;

    @EJB
    private SpecialtyService specialtyService;

    @Inject
    private SpecialtyEndpointUtil specialtyEndpointUtil;

    private String dtoJsonFactory(SpecialtyDto dto) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(dto);
    }

    private String dtoListJsonFactory(SpecialtyListDto dtoList) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(dtoList);
    }

    private String dtoXmlFactory(SpecialtyDto dto) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(SpecialtyDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(dto, stringWriter);
        return stringWriter.toString();
    }

    private String dtoListXmlFactory(SpecialtyListDto dtoList) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(SpecialtyListDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(dtoList, stringWriter);
        return stringWriter.toString();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        log.info("getList");
        return this.dtoListJsonFactory(specialtyEndpointUtil.dtoListFactory(specialtyService.getAll()));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntity(@PathParam("id") Long id) {
        log.info("getEntity");
        return this.dtoJsonFactory(specialtyEndpointUtil.dtoFactory(specialtyService.findById(id)));
    }

    @GET
    @Path("/xml/list")
    @Produces(MediaType.APPLICATION_XML)
    public String getListAsXml() throws JAXBException {
        log.info("getListAsXml");
        return this.dtoListXmlFactory(specialtyEndpointUtil.dtoListFactory(specialtyService.getAll()));
    }

    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getEntityAsXml(@PathParam("id") Long id) throws JAXBException {
        log.info("getEntityAsXml");
        return this.dtoXmlFactory(specialtyEndpointUtil.dtoFactory(specialtyService.findById(id)));
    }
}
