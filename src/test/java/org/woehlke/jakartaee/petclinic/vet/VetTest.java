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
    void runEntityTest01(){
        log.info("runEntityTest01");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(name01.compareTo(name02)==0);
        Vet o01 = new Vet();
        o01.setLastName(name01);
        o01.setFirstName(name02);
        o01.setUuid(uuid01);
        Vet o02 = new Vet();
        o02.setLastName(name01);
        o02.setFirstName(name02);
        o02.setUuid(uuid02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest02(){
        log.info("runEntityTest02");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        Vet o01 = new Vet();
        o01.setLastName(name01);
        o01.setFirstName(name02);
        o01.setId(id01);
        o01.setUuid(uuid01);
        Vet o02 = new Vet();
        o02.setLastName(name01);
        o02.setFirstName(name02);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest11(){
        log.info("runEntityTest11");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Vet o01 = new Vet();
        o01.setLastName(name01);
        o01.setFirstName(name01);
        o01.setUuid(uuid01);
        Vet o02 = new Vet();
        o02.setLastName(name02);
        o02.setFirstName(name02);
        o02.setUuid(uuid02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest12(){
        log.info("runEntityTest12");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        Vet o01 = new Vet();
        o01.setLastName(name01);
        o01.setFirstName(name01);
        o01.setId(id01);
        o01.setUuid(uuid01);
        Vet o02 = new Vet();
        o02.setLastName(name02);
        o02.setFirstName(name02);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest21(){
        log.info("runEntityTest21");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Vet o01 = new Vet();
        o01.setLastName(name01);
        o01.setFirstName(name01);
        o01.setUuid(uuid);
        Vet o02 = new Vet();
        o02.setLastName(name02);
        o02.setFirstName(name02);
        o02.setUuid(uuid);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest22(){
        log.info("runEntityTest22");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Vet o01 = new Vet();
        o01.setLastName(name01);
        o01.setFirstName(name01);
        o01.setId(id);
        o01.setUuid(uuid);
        Vet o02 = new Vet();
        o02.setLastName(name02);
        o02.setFirstName(name02);
        o02.setUuid(uuid);
        o02.setId(id);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest99(){
        log.info("runEntityTest99");
        Collections.sort(vetList);
        Assert.assertTrue(vetList.size() > 2);
        Iterator<Vet> i =  vetList.iterator();
        Vet firstEntity = i.next();
        while(i.hasNext()){
            Vet secondEntity = i.next();
            int compared = secondEntity.compareTo(firstEntity);
            Assert.assertTrue(compared > 0);
            firstEntity = secondEntity;
        }
    }

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
