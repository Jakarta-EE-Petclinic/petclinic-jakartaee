package org.woehlke.jakartaee.petclinic.pet;

import junit.framework.Assert;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.woehlke.jakartaee.petclinic.application.api.AbstractEntityTest;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import java.util.Collections;
import java.util.Iterator;

@Log
public class PetTest extends AbstractEntityTest {

    @Test
    void runRntityTest01(){
        log.info("runRntityTest01");
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
    void runRntityTest02(){
        log.info("runRntityTest02");
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
    void runRntityTest11(){
        log.info("runRntityTest11");
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
    void runRntityTest12(){
        log.info("runRntityTest12");
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
    void runRntityTest21(){
        log.info("runRntityTest21");
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
    void runRntityTest22(){
        log.info("runRntityTest22");
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
    void runRntityTest99(){
        log.info("runRntityTest99");
        Collections.sort(petTypeList);
        Assert.assertTrue(petList.size() > 2);
        Iterator<Pet> i =  petList.iterator();
        Pet firstEntity = i.next();
        while(i.hasNext()){
            Pet secondEntity = i.next();
            int compared = secondEntity.compareTo(firstEntity);
            //log.info("runRntityTest99: "+ compared);
            Assert.assertTrue(compared > 0);
            firstEntity = secondEntity;
        }
    }
}
