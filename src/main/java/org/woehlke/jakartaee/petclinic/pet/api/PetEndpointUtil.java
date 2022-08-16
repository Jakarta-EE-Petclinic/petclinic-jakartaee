package org.woehlke.jakartaee.petclinic.pet.api;


import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pettype.api.PetTypeEndpointUtil;
import org.woehlke.jakartaee.petclinic.visit.api.VisitEndpointUtil;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


@Log
public class PetEndpointUtil implements Serializable {

    private static final long serialVersionUID = 7444366391126982311L;

    private final PetTypeEndpointUtil petTypeEndpointUtil = new PetTypeEndpointUtil();

    private final VisitEndpointUtil visitEndpointUtil = new VisitEndpointUtil();

    public PetDto dtoFactory(Pet e) {
        PetDto dto = new PetDto();
        dto.setId(e.getId());
        dto.setUuid(e.getUuid());
        dto.setBirthDate( e.getBirthDate());
        dto.setName(e.getName());
        dto.setPetType(this.petTypeEndpointUtil.dtoFactory(e.getType()));
        dto.setVisitList(this.visitEndpointUtil.dtoListFactory(e.getVisits()));
        return dto;
    }

    public PetListDto dtoListFactory(List<Pet> petTypeList) {
        List<PetDto> dtoList = new ArrayList<>();
        for (Pet e : petTypeList) {
            PetDto dto = this.dtoFactory(e);
            dtoList.add(dto);
        }
        return new PetListDto(dtoList);
    }


    public String dtoListJsonFactory(PetListDto listDto) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(listDto);
    }

    public String dtoXmlFactory(PetDto dto) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(PetDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(dto, stringWriter);
        return stringWriter.toString();
    }

    public String dtoListXmlFactory(PetListDto listDto) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(PetListDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(listDto, stringWriter);
        return stringWriter.toString();
    }
}
