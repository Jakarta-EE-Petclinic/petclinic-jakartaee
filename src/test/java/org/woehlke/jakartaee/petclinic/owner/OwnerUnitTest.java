package org.woehlke.jakartaee.petclinic.owner;

import junit.framework.Assert;
import lombok.extern.java.Log;
import org.junit.jupiter.api.*;
import org.woehlke.jakartaee.petclinic.application.conf.AbstractEntityTest;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import java.util.*;

@Log
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OwnerUnitTest extends AbstractEntityTest {

    @Test
    @Order(1)
    void runEntityTest01(){
        log.info("runEntityTest01");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(name01.compareTo(name02)==0);
        Owner o01 = new Owner();
        o01.setLastName(name01);
        o01.setFirstName(name02);
        o01.setUuid(uuid01);
        Owner o02 = new Owner();
        o02.setLastName(name01);
        o02.setFirstName(name02);
        o02.setUuid(uuid02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    @Order(2)
    void runEntityTest02(){
        log.info("runEntityTest02");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        Owner o01 = new Owner();
        o01.setLastName(name01);
        o01.setFirstName(name02);
        o01.setId(id01);
        o01.setUuid(uuid01);
        Owner o02 = new Owner();
        o02.setLastName(name01);
        o02.setFirstName(name02);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    @Order(3)
    void runEntityTest11(){
        log.info("runEntityTest11");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Owner o01 = new Owner();
        o01.setLastName(name01);
        o01.setFirstName(name01);
        o01.setUuid(uuid01);
        Owner o02 = new Owner();
        o02.setLastName(name02);
        o02.setFirstName(name02);
        o02.setUuid(uuid02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    @Order(4)
    void runEntityTest12(){
        log.info("runEntityTest12");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        Owner o01 = new Owner();
        o01.setLastName(name01);
        o01.setFirstName(name01);
        o01.setId(id01);
        o01.setUuid(uuid01);
        Owner o02 = new Owner();
        o02.setLastName(name02);
        o02.setFirstName(name02);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    @Order(5)
    void runEntityTest21(){
        log.info("runEntityTest21");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Owner o01 = new Owner();
        o01.setLastName(name01);
        o01.setFirstName(name01);
        o01.setUuid(uuid);
        Owner o02 = new Owner();
        o02.setLastName(name02);
        o02.setFirstName(name02);
        o02.setUuid(uuid);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    @Order(6)
    void runEntityTest22(){
        log.info("runEntityTest22");
        Assert.assertFalse(name01.compareTo(name02)==0);
        Owner o01 = new Owner();
        o01.setLastName(name01);
        o01.setFirstName(name01);
        o01.setId(id);
        o01.setUuid(uuid);
        Owner o02 = new Owner();
        o02.setLastName(name02);
        o02.setFirstName(name02);
        o02.setUuid(uuid);
        o02.setId(id);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    @Order(7)
    void runEntityTest99(){
        log.info("runEntityTest99");
        Collections.sort(ownerList);
        Assert.assertTrue(ownerList.size() > 2);
        Iterator<Owner> i =  ownerList.iterator();
        Owner firstEntity = i.next();
        while(i.hasNext()){
            Owner secondEntity = i.next();
            int compared = secondEntity.compareTo(firstEntity);
            Assert.assertTrue(compared > 0);
            firstEntity = secondEntity;
        }
    }

    @Test
    @Order(8)
    public void testGetPetst01(){
        log.info("testGetPetst01");
        int expectedSize  = 0;
        Owner entity = new Owner();
        int size = entity.getPetsAsList().size();
        Assert.assertEquals(expectedSize,size);
    }

    @Test
    @Order(9)
    public void testGetPetst02(){
        log.info("testGetPetst02");
        Owner entity = ownerList.get(2);
        String petName = AbstractEntityTest.petNames[2];
        int expectedSize  = entity.getPetsAsList().size() + 1;
        Assert.assertEquals("Nelly", petName);
        Pet pet = new Pet();
        pet.setName(petName);
        pet.setBirthDate(new Date());
        pet.setUuid(UUID.randomUUID());
        entity.addPet(pet);
        int size = entity.getPetsAsList().size();
        Assert.assertEquals(expectedSize, size);
    }

    @Test
    @Order(10)
    public void testGetPetst03(){
        log.info("testGetPetst03");
        Owner entity = ownerList.get(2);
        String petName = AbstractEntityTest.petNames[2];
        int expectedSize  = entity.getPetsAsList().size() + 1;
        Assert.assertEquals("Nelly", petName);
        Pet pet = new Pet();
        pet.setBirthDate(new Date());
        pet.setName(petName);
        pet.setUuid(UUID.randomUUID());
        entity.addPet(pet);
        pet = entity.getPetsAsList().iterator().next();
        Assert.assertEquals(petName, pet.getName());
    }

    @Test
    @Order(11)
    public void testGetPetst04() {
        log.info("testGetPetst04");
        Owner entity = ownerList.get(3);
        int expectedSize = petSet.size();
        entity.setPets(petSet);
        int size = entity.getPetsAsList().size();
        Assert.assertEquals(expectedSize, size);
    }

    @Test
    @Order(12)
    public void testGetPetst05() {
        log.info("testGetPetst05");
        Owner entity = ownerList.get(3);
        int expectedSize = petSet.size();
        entity.setPets(petSet);
        int size = entity.getPetsAsList().size();
        Assert.assertEquals(expectedSize, size);
        Assert.assertTrue(petList.size() > 2);
        Iterator<Pet> i =  petList.iterator();
        Pet first = i.next();
        while(i.hasNext()){
            Pet second = i.next();
            int compared = second.compareTo(first);
            Assert.assertTrue(compared > 0);
            first = second;
        }
    }

}
