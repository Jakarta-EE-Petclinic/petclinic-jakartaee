package org.woehlke.jakartaee.petclinic.owner.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.api.PetEndpointUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Log
@ApplicationScoped
public class OwnerEndpointUtil implements Serializable {

    private static final long serialVersionUID = 532726561254887897L;
    @Inject
    private PetEndpointUtil petEndpointUtil;

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
        dto.setPetList(this.petEndpointUtil.dtoListFactory(o.getPets()));
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

}
