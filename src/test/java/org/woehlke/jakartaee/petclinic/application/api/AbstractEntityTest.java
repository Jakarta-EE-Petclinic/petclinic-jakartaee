package org.woehlke.jakartaee.petclinic.application.api;

import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.util.*;

public class AbstractEntityTest {

    protected String name01 = "wooollooomooollooo";
    protected String name02 = "huulluuumuuulluuu";
    protected UUID uuid01 = UUID.randomUUID();
    protected UUID uuid02 = UUID.randomUUID();
    protected UUID uuid = UUID.randomUUID();
    protected Long id01 = 1L;
    protected Long id02 = 2L;
    protected Long id = 3L;

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


    protected static final String petTypeName[] = {
            "Dog",
            "Cat",
            "Elephant",
            "Kitten",
            "Donkey",
            "Cow",
            "Pig",
            "Chicken"
    };

    protected static List<PetType> petTypeList = new ArrayList<>();

    static {
        for (String petTypeName : petTypeName){
            PetType o = new PetType();
            o.setName(petTypeName);
            o.setUuid(UUID.randomUUID());
            petTypeList.add(o);
        }
    }

    protected static final String petName[] = {
            "Dog",
            "Cat",
            "Elephant",
            "Kitten",
            "Donkey",
            "Cow",
            "Pig",
            "Chicken"
    };

    protected static List<Pet> petList = new ArrayList<>();

    static {
        int year=2021;
        int month=11;
        int day=15;
        int i=0;
        for (String petTypeName : petTypeName){
            Date dob = new Date(year,month,day);
            Pet o = new Pet();
            o.setName(petTypeName);
            o.setBirthDate(dob);
            o.setUuid(UUID.randomUUID());
            o.setType(petTypeList.get(i));
            petList.add(o);
            year--;
            month--;
            day--;
            i++;
            i %= petTypeList.size();
        }
    }
}
