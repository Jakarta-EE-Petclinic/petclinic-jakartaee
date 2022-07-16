package org.woehlke.jakartaee.petclinic.application.api;

import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.util.*;

public class AbstractEntityTest {

    protected static final String specialtyName[] = {
            "Surgeon",
            "Radiologist",
            "Neurosurgeon",
            "Dentist",
            "Cardiologist",
            "Impostor",
            "Faith Healer"
    };

    protected static List<Specialty> specialtyList = new ArrayList<>();

    protected static Set<Specialty> specialtySet = new HashSet<>();

    static {
        for (String specialtyName : specialtyName){
            Specialty specialty = new Specialty();
            specialty.setName(specialtyName);
            specialty.setUuid(UUID.randomUUID());
            specialtyList.add(specialty);
            specialtySet.add(specialty);
        }
    }

}
