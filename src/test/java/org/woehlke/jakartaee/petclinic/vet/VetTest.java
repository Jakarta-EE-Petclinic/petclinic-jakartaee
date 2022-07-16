package org.woehlke.jakartaee.petclinic.vet;

import junit.framework.Assert;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.woehlke.jakartaee.petclinic.application.api.AbstractEntityTest;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.util.*;

@Log
public class VetTest extends AbstractEntityTest {


    @Test
    public void testGetSpecialtiesAsList01(){
        log.info("testGetSpecialtiesAsList01");
        int expectedSize  = 0;
        Vet entity = new Vet();
        int size = entity.getSpecialties().size();
        Assert.assertEquals(expectedSize,size);
    }

    @Test
    public void testGetSpecialtiesAsList02(){
        log.info("testGetSpecialtiesAsList02");
        int expectedSize  = 1;
        Vet entity = new Vet();
        String specialtyName = AbstractEntityTest.specialtyName[0];
        Assert.assertEquals("Surgeon",specialtyName);
        Specialty specialty = new Specialty();
        specialty.setName(specialtyName);
        entity.addSpecialty(specialty);
        int size = entity.getSpecialties().size();
        Assert.assertEquals(expectedSize,size);

    }

    @Test
    public void testGetSpecialtiesAsList03(){
        log.info("testGetSpecialtiesAsList03");
        Vet entity = new Vet();
        String specialtyName =  AbstractEntityTest.specialtyName[0];
        Assert.assertEquals("Surgeon",specialtyName);
        Specialty specialty = new Specialty();
        specialty.setName(specialtyName);
        entity.addSpecialty(specialty);
        specialty = entity.getSpecialties().iterator().next();
        Assert.assertEquals(specialtyName, specialty.getName());
    }

    @Test
    public void testGetSpecialtiesAsList04() {
        log.info("testGetSpecialtiesAsList04");
        Vet entity = new Vet();
        int expectedSize  = specialtySet.size();
        entity.setSpecialties(specialtySet);
        int size = entity.getSpecialtiesAsList().size();
        Assert.assertEquals(expectedSize,size);
    }

    @Test
    public void testGetSpecialtiesAsList05() {
        log.info("testGetSpecialtiesAsList05");
        Vet entity = new Vet();
        entity.setSpecialties(specialtySet);
        List<Specialty> listSpecialty = entity.getSpecialtiesAsList();
        Assert.assertEquals(specialtySet.size(), listSpecialty.size());
        Assert.assertTrue(listSpecialty.size() > 2);
        Iterator<Specialty> i =  listSpecialty.iterator();
        Specialty firstSpecialty = i.next();
        while(i.hasNext()){
            Specialty secondSpecialty = i.next();
            int compared = secondSpecialty.compareTo(firstSpecialty);
            Assert.assertTrue(compared > 0);
            firstSpecialty = secondSpecialty;
        }
    }
}
