package org.woehlke.jakartaee.petclinic.deployments;

import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;
import org.woehlke.jakartaee.petclinic.vet.Vet;
import org.woehlke.jakartaee.petclinic.visit.Visit;

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
    protected GregorianCalendar gc1 = new GregorianCalendar(121, 6, 14);
    protected GregorianCalendar gc2 = new GregorianCalendar(121, 5, 12);
    protected Date dob01 = Date.from(gc1.toInstant());
    protected Date dob02 = Date.from(gc2.toInstant());
	
    protected static List<Specialty> specialtyList = new ArrayList<>();
    protected static Set<Specialty> specialtySet = new HashSet<>();
    protected static Map<String,String> vetNames = new HashMap<>();
    protected static List<Vet> vetList = new ArrayList<>();
    protected static List<Date> dateOfBirthList = new ArrayList<>();
    protected static List<PetType> petTypeList = new ArrayList<>();
    protected static List<Pet> petList = new ArrayList<>();
    protected static Set<Pet> petSet = new HashSet<>();
    protected static List<Visit> visitList = new ArrayList<>();
    protected static List<Owner> ownerList = new ArrayList<>();

    protected static final String specialtyNames[] = {
            "Surgeon",
            "Oncologist",
            "Radiologist",
            "Neurosurgeon",
            "Cardiologist",
            "Dermatologist",
            "Orthopedist",
            "Dentist",
            "Impostor",
            "Faith Healer"
    };

    static {
        vetNames.put("von Kos","Hippokrates");
        vetNames.put("Koch","Robert");
        vetNames.put("Fleming","Alexander");
        vetNames.put("Virchow","Rudolf");
        vetNames.put("Freud","Sigmund");
        vetNames.put("Stertinius Xenophon","Gaius");
        vetNames.put("von Behring","Emil");
        vetNames.put("Ehrlich","Paul");
        vetNames.put("Shibasaburō","Kitasato");
        vetNames.put("Hispalensis","Isidorus");
        vetNames.put("Schweitzer","Albert");
        vetNames.put("Montessori","Maria Tecla Artemisia");
    }

    protected static final String petTypeNames[] = {
            "Dog",
            "Cat",
            "Elephant",
            "Kitten",
            "Donkey",
            "Cow",
            "Pig",
            "Chicken"
    };

    protected static final String petNames[] = {
            "Jessie",
            "Lucifer Sam",
            "Nelly",
            "Kitten",
            "Benjamin",
            "Pauline Wayne",
            "Snowball",
            "Gallus gallus domesticus"
    };

    static {
        for (String specialtyName : specialtyNames){
            Specialty specialty = new Specialty();
            specialty.setName(specialtyName);
            specialty.setUuid(UUID.randomUUID());
            specialtyList.add(specialty);
            specialtySet.add(specialty);
        }
    }

    static {
        for (String petTypeName : petTypeNames){
            PetType o = new PetType();
            o.setName(petTypeName);
            o.setUuid(UUID.randomUUID());
            petTypeList.add(o);
        }
    }

    static {
        int year = 2010;
        int month = 1;
        int day = 5;
        for (String petTypeName : petTypeNames) {
            GregorianCalendar gc = new GregorianCalendar(year,month,day);
            Date dob = Date.from(gc.toInstant());
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
        for(Map.Entry<String,String> vetName:vetNames.entrySet()){
            Vet v = new Vet();
            v.setLastName(vetName.getKey());
            v.setFirstName(vetName.getValue());
            v.setUuid(UUID.randomUUID());
            v.setSpecialties(specialtySet);
            vetList.add(v);
        }
    }

    static {
        Owner o = new Owner();
        o.setFirstName("Kurt");
        o.setLastName("Tucholsky");
        o.setAddress("Lübecker Straße");
        o.setHouseNumber("13");
        o.setCity("Berlin");
        o.setZipCode("10559");
        o.setPhoneNumber("+49 30 3946364");
        o.setEmail("kurt.tucholsky@vistaberlin.de");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("Heinrich");
        o.setLastName("Heine");
        o.setAddress("Bolkerstraße");
        o.setHouseNumber("53");
        o.setCity("Düsseldorf");
        o.setZipCode("40213");
        o.setPhoneNumber("+49 211 20054294");
        o.setEmail("heinrich.heine@heinehaus.de");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("Alan");
        o.setLastName("Turing");
        o.setAddress("Bletchley Park");
        o.setHouseNumber("Block H");
        o.setCity("Milton Keynes");
        o.setZipCode("MK3 6EB");
        o.setPhoneNumber("+441908374708");
        o.setEmail("alan.turing@tnmoc.org");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("Grace");
        o.setLastName("Hopper");
        o.setAddress("St Ronan St");
        o.setHouseNumber("160");
        o.setAddressInfo("Yale University");
        o.setCity("New Haven");
        o.setZipCode("CT 06520");
        o.setPhoneNumber("+12034324771");
        o.setEmail("grace.hopper@yale.edu");
        ownerList.add(o);
        o = new Owner();
        o.setFirstName("Mahatma");
        o.setLastName("Ghandi");
        o.setAddress("Sevagram");
        o.setHouseNumber("PMH7 H42");
        o.setAddressInfo("Mahatma Gandhi Ashram");
        o.setCity("Maharashtra");
        o.setZipCode("442102");
        o.setPhoneNumber("+91-7152-284753");
        o.setEmail("mahatma.ghandi@gandhiashramsevagram.org");
        ownerList.add(o);
        for(Owner oo:ownerList){
            oo.setUuid(UUID.randomUUID());
            oo.setPets(petSet);
        }
    }


    protected static Pet pet1 = new Pet();
    protected static Pet pet2 = new Pet();

    static {
        pet1.setBirthDate(dateOfBirthList.get(0));
        pet1.setType(petTypeList.get(2));
        pet1.setName(petNames[2]);
        pet1.setUuid(UUID.randomUUID());
        pet2.setBirthDate(dateOfBirthList.get(1));
        pet2.setType(petTypeList.get(3));
        pet2.setName(petNames[3]);
        pet2.setUuid(UUID.randomUUID());
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
