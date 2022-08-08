package org.woehlke.jakartaee.petclinic.it.deployments;

import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import java.util.*;

public abstract class TestData {

    protected static List<Pet> petList = new ArrayList<>();
    protected static List<Date> dateOfBirthList = new ArrayList<>();
    protected static List<PetType> petTypeList = new ArrayList<>();
    protected static Set<Pet> petSet = new HashSet<>();
    protected static List<Owner> ownerList = new ArrayList<>();
    protected static List<Visit> visitList = new ArrayList<>();

    protected static final String petTypeNameArray[] = {
            "A Animal 1 Farm",
            "A Animal 2 Farm",
            "A Animal 3 Farm"
    };
    protected static final String petTypeNames[] = {
            "A Dog",
            "A Cat",
            "A Elephant",
            "A Kitten",
            "A Donkey",
            "A Cow",
            "A Pig",
            "A Chicken"
    };
    protected static final String petNames[] = {
            "A Jessie",
            "A Lucifer Sam",
            "A Nelly",
            "A Kitten",
            "A Benjamin",
            "A Pauline Wayne",
            "A Snowball",
            "A Gallus gallus domesticus"
    };
    protected static final String vetNames[][] = {
            {"A Hippocrates 1", "A of Kos 1"},
            {"A Hippocrates 2", "A of Kos 2"},
            {"A Hippocrates 3", "A of Kos 3"}
    };
    protected static final String specialtyNameArray[] = {
            "A Hippocrates 1",
            "A Hippocrates 2",
            "A Hippocrates 3"
    };


    static {
        for (String petTypeName : petTypeNames){
            PetType o = new PetType();
            o.setName(petTypeName);
            o.setUuid(UUID.randomUUID());
            petTypeList.add(o);
        }
    }
    static {
        int year = 2001;
        int month = 1;
        int day = 5;
        for (String petName : petNames){
            @SuppressWarnings("deprecation")
            Date dob = new Date(year,month,day);
            dateOfBirthList.add(dob);
            year++;
            month++;
            day++;
        }
    }
    static {
        int i=0;
        int k=0;
        for (String petName : petNames){
            Date dob = dateOfBirthList.get(k);
            Pet o = new Pet();
            o.setName(petName);
            o.setBirthDate(dob);
            o.setType(petTypeList.get(i));
            o.setUuid(UUID.randomUUID());
            petList.add(o);
            petSet.add(o);
            i++;
            i %= petTypeList.size();
            k++;
        }
    }
    static {
        Owner o = new Owner();
        o.setFirstName("A1 Kurt");
        o.setLastName("A1 Tucholsky");
        o.setAddress("Lübecker Straße");
        o.setHouseNumber("13");
        o.setCity("Berlin");
        o.setZipCode("10559");
        o.setPhoneNumber("+49 30 3946364");
        o.setEmail("kurt.tucholsky@vistaberlin.de");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("A2 Heinrich");
        o.setLastName("A2 Heine");
        o.setAddress("Bolkerstraße");
        o.setHouseNumber("53");
        o.setCity("Düsseldorf");
        o.setZipCode("40213");
        o.setPhoneNumber("+4921120054294");
        o.setEmail("heinrich.heine@heinehaus.de");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("A3 Alan");
        o.setLastName("A3 Turing");
        o.setAddress("Bletchley Park");
        o.setHouseNumber("Block H");
        o.setCity("Milton Keynes");
        o.setZipCode("MK3 6EB");
        o.setPhoneNumber("+441908374708");
        o.setEmail("alan.turing@tnmoc.org");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("A4 Grace");
        o.setLastName("A4 Hopper");
        o.setAddress("St Ronan St");
        o.setHouseNumber("160");
        o.setAddressInfo("Yale University");
        o.setCity("New Haven");
        o.setZipCode("CT 06520");
        o.setPhoneNumber("+12034324771");
        o.setEmail("grace.hopper@yale.edu");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("A5 Mahatma");
        o.setLastName("A5 Ghandi");
        o.setAddress("Sevagram");
        o.setHouseNumber("PMH7 H42");
        o.setAddressInfo("Mahatma Gandhi Ashram");
        o.setCity("Maharashtra");
        o.setZipCode("442102");
        o.setPhoneNumber("+91 7152 284753");
        o.setEmail("mahatma.ghandi@gandhiashramsevagram.org");
        ownerList.add(o);
        for(Owner oo:ownerList){
            oo.setUuid(UUID.randomUUID());
            oo.setPets(petSet);
        }
    }
    static {
        long i = 0;
        Pet p = petList.get(2);
        for(Date day : dateOfBirthList){
            i++;
            Visit v = new Visit();
            v.setPet(p);
            v.setDate(day);
            v.setDescription("woooolloooomoooolloooo "+i);
            v.setUuid(UUID.randomUUID());
            v.setId(i);
            visitList.add(v);
        }
    }
}
