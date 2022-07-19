package org.woehlke.jakartaee.petclinic.pet;

import junit.framework.Assert;
import lombok.extern.java.Log;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.woehlke.jakartaee.petclinic.application.conf.AbstractEntityTest;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import java.util.Collections;
import java.util.Iterator;

@Log
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetUnitTest extends AbstractEntityTest {

    @Test
    @Order(1)
    void runEntityTest01(){
        log.info("runEntityTest01");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        PetType petType = petTypeList.get(2);
        Pet o01 = new Pet();
        o01.setType(petType);
        o01.setBirthDate(dob01);
        o01.setName(name01);
        o01.setUuid(uuid01);
        Pet o02 = new Pet();
        o02.setType(petType);
        o02.setBirthDate(dob01);
        o02.setName(name01);
        o02.setUuid(uuid02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    @Order(2)
    void runEntityTest02(){
        log.info("runEntityTest02");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        PetType petType = petTypeList.get(2);
        Pet o01 = new Pet();
        o01.setType(petType);
        o01.setBirthDate(dob01);
        o01.setName(name01);
        o01.setId(id01);
        o01.setUuid(uuid01);
        Pet o02 = new Pet();
        o02.setType(petType);
        o02.setBirthDate(dob01);
        o02.setName(name01);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    @Order(3)
    void runEntityTest11(){
        log.info("runEntityTest11");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        PetType petType = petTypeList.get(2);
        Pet o01 = new Pet();
        o01.setType(petType);
        o01.setBirthDate(dob01);
        o01.setName(name01);
        o01.setUuid(uuid01);
        Pet o02 = new Pet();
        o02.setType(petType);
        o02.setBirthDate(dob02);
        o02.setName(name02);
        o02.setUuid(uuid02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    @Order(4)
    void runEntityTest12(){
        log.info("runEntityTest12");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        PetType petType = petTypeList.get(2);
        Pet o01 = new Pet();
        o01.setType(petType);
        o01.setBirthDate(dob01);
        o01.setName(name01);
        o01.setId(id01);
        o01.setUuid(uuid01);
        Pet o02 = new Pet();
        o02.setType(petType);
        o02.setBirthDate(dob02);
        o02.setName(name02);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    @Order(5)
    void runEntityTest21(){
        log.info("runEntityTest21");
        PetType petType = petTypeList.get(2);
        Pet o01 = new Pet();
        o01.setType(petType);
        o01.setBirthDate(dob01);
        o01.setName(name01);
        o01.setUuid(uuid);
        Pet o02 = new Pet();
        o02.setType(petType);
        o02.setBirthDate(dob02);
        o02.setName(name02);
        o02.setUuid(uuid);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    @Order(6)
    void runEntityTest22(){
        log.info("runEntityTest22");
        PetType petType = petTypeList.get(2);
        Pet o01 = new Pet();
        o01.setType(petType);
        o01.setBirthDate(dob01);
        o01.setName(name01);
        o01.setId(id);
        o01.setUuid(uuid);
        Pet o02 = new Pet();
        o02.setType(petType);
        o02.setBirthDate(dob02);
        o02.setName(name02);
        o02.setUuid(uuid);
        o02.setId(id);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    @Order(7)
    void runEntityTest99(){
        log.info("runEntityTest99");
        Collections.sort(petList);
        Assert.assertTrue(petList.size() > 2);
        Iterator<Pet> i =  petList.iterator();
        Pet firstEntity = i.next();
        while(i.hasNext()){
            Pet secondEntity = i.next();
            int compared = secondEntity.compareTo(firstEntity);
            //log.info("runEntityTest99: "+ compared);
            Assert.assertTrue(compared > 0);
            firstEntity = secondEntity;
        }
    }
}
