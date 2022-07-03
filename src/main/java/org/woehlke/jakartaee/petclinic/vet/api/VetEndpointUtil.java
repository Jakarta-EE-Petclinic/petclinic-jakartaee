package org.woehlke.jakartaee.petclinic.vet.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;
import org.woehlke.jakartaee.petclinic.specialty.api.SpecialtyDto;
import org.woehlke.jakartaee.petclinic.specialty.api.SpecialtyEndpointUtil;
import org.woehlke.jakartaee.petclinic.specialty.api.SpecialtyListDto;
import org.woehlke.jakartaee.petclinic.vet.Vet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Log
@ApplicationScoped
public class VetEndpointUtil implements Serializable {

    private static final long serialVersionUID = 607664665910620584L;

    @Inject
    private SpecialtyEndpointUtil specialtyEndpointUtil;

    public VetDto dtoFactory(Vet vet) {
        VetDto dto = new VetDto();
        dto.setId(vet.getId());
        dto.setUuid(vet.getUuid());
        dto.setFirstName(vet.getFirstName());
        dto.setLastName(vet.getLastName());
        SpecialtyListDto specialtyList = this.specialtyEndpointUtil.dtoListFactory(vet.getSpecialties());
        dto.setSpecialtyList(specialtyList);
        return dto;
    }

    public VetListDto dtoListFactory(List<Vet> vetList) {
        List<VetDto> dtoList = new ArrayList<>();
        for (Vet vet : vetList) {
            VetDto dto = this.dtoFactory(vet);
            dtoList.add(dto);
        }
        return new VetListDto(dtoList);
    }
}
