package org.woehlke.jakartaee.petclinic.pet.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pettype.api.PetTypeEndpointUtil;
import org.woehlke.jakartaee.petclinic.visit.api.VisitEndpointUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Log
@ApplicationScoped
public class PetEndpointUtil implements Serializable {

    private static final long serialVersionUID = 7444366391126982311L;

    @Inject
    private PetTypeEndpointUtil petTypeEndpointUtil;

    @Inject
    private VisitEndpointUtil visitEndpointUtil;

    public PetDto dtoFactory(Pet e) {
        PetDto dto = new PetDto();
        dto.setId(e.getId());
        dto.setUuid(e.getUuid());
        dto.setBirthDate(e.getBirthDate());
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

}
