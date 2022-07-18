package org.woehlke.jakartaee.petclinic.application.conf;

import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;
import org.woehlke.jakartaee.petclinic.vet.Vet;

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
    protected Date dob01 = new Date(2021,6,14);
    protected Date dob02 = new Date(2020,5,12);

    protected static List<Specialty> specialtyList = new ArrayList<>();
    protected static Set<Specialty> specialtySet = new HashSet<>();
    protected static Map<String,String> vetNames = new HashMap<>();
    protected static List<Vet> vetList = new ArrayList<>();
    protected static List<Date> dateOfBirthList = new ArrayList<>();
    protected static List<PetType> petTypeList = new ArrayList<>();
    protected static List<Pet> petList = new ArrayList<>();
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
        int year = 2021;
        int month = 1;
        int day = 5;
        for (String petTypeName : petTypeNames) {
            Date dob = new Date(year, month, day);
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

}
