package org.woehlke.jakartaee.petclinic.owner.api;


import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.api.PetEndpointUtil;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


@Log
public class OwnerEndpointUtil implements Serializable {

    private static final long serialVersionUID = 532726561254887897L;

    private final PetEndpointUtil petEndpointUtil = new PetEndpointUtil();

    public OwnerDto dtoFactory(Owner o) {
        OwnerDto dto = new OwnerDto();
        dto.setId(o.getId());
        dto.setUuid(o.getUuid());
        dto.setFirstName(o.getFirstName());
        dto.setLastName(o.getLastName());
        dto.setAddress(o.getAddress());
        dto.setAddressInfo(o.getAddressInfo());
        dto.setHouseNumber(o.getHouseNumber());
        dto.setCity(o.getCity());
        dto.setZipCode(o.getZipCode());
        dto.setPhoneNumber(o.getPhoneNumber());
        dto.setPetList(this.petEndpointUtil.dtoListFactory(o.getPetsAsList()));
        return dto;
    }

    public OwnerListDto dtoListFactory(List<Owner> sList) {
        List<OwnerDto> dtoList = new ArrayList<>();
        for (Owner o : sList) {
            OwnerDto dto = this.dtoFactory(o);
            dtoList.add(dto);
        }
        return new OwnerListDto(dtoList);
    }

    public String dtoJsonFactory(OwnerDto dto) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(dto);
    }

    public String dtoListJsonFactory(OwnerListDto dtoList) throws JsonbException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(dtoList);
    }

    public String dtoXmlFactory(OwnerDto dto) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(OwnerDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(dto, stringWriter);
        return stringWriter.toString();
    }

    public String dtoListXmlFactory(OwnerListDto dtoList) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(OwnerListDto.class);
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        m.marshal(dtoList, stringWriter);
        return stringWriter.toString();
    }
}
