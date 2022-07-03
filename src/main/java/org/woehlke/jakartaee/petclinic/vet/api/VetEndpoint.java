package org.woehlke.jakartaee.petclinic.vet.api;

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
import org.woehlke.jakartaee.petclinic.vet.Vet;
import org.woehlke.jakartaee.petclinic.vet.VetService;


import java.io.Serializable;
import java.io.StringWriter;

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

    @Inject
    private VetEndpointUtil vetEndpointUtil;

    private String dtoJsonFactory(VetDto dto) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(dto);
    }

    private String dtoListJsonFactory(VetListDto vetListDto) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(vetListDto);
    }

    private String dtoXmlFactory(VetDto dto) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(VetDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(dto, stringWriter);
        return stringWriter.toString();
    }

    private String dtoListXmlFactory(VetListDto vetListDto) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(VetListDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(vetListDto, stringWriter);
        return stringWriter.toString();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getList() {
        log.info("getList");
        return this.dtoListJsonFactory(vetEndpointUtil.dtoListFactory(vetService.getAll()));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEntity(@PathParam("id") Long id) {
        log.info("getEntity");
        return this.dtoJsonFactory(vetEndpointUtil.dtoFactory(vetService.findById(id)));
    }

    @GET
    @Path("/xml/list")
    @Produces(MediaType.APPLICATION_XML)
    public String getListAsXml() throws JAXBException {
        log.info("getListAsXml");
        return this.dtoListXmlFactory(vetEndpointUtil.dtoListFactory(vetService.getAll()));
    }

    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getEntityAsXml(@PathParam("id") Long id) throws JAXBException {
        log.info("getEntityAsXml");
        return this.dtoXmlFactory(vetEndpointUtil.dtoFactory(vetService.findById(id)));
    }

}
