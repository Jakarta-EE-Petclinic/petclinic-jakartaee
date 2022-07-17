package org.woehlke.jakartaee.petclinic.pettype;

import junit.framework.Assert;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.woehlke.jakartaee.petclinic.application.api.AbstractEntityTest;

import java.util.Collections;
import java.util.Iterator;

@Log
public class PetTypeTest extends AbstractEntityTest {

    @Test
    void runRntityTest01(){
        log.info("runRntityTest01");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        PetType o01 = new PetType();
        o01.setName(name01);
        o01.setUuid(uuid01);
        PetType o02 = new PetType();
        o02.setName(name01);
        o02.setUuid(uuid02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    void runRntityTest02(){
        log.info("runRntityTest02");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        PetType o01 = new PetType();
        o01.setName(name01);
        o01.setId(id01);
        o01.setUuid(uuid01);
        PetType o02 = new PetType();
        o02.setName(name01);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    void runRntityTest11(){
        log.info("runRntityTest11");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(name01.compareTo(name02)==0);
        PetType o01 = new PetType();
        o01.setName(name01);
        o01.setUuid(uuid01);
        PetType o02 = new PetType();
        o02.setName(name02);
        o02.setUuid(uuid02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runRntityTest12(){
        log.info("runRntityTest12");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        PetType o01 = new PetType();
        o01.setName(name01);
        o01.setId(id01);
        o01.setUuid(uuid01);
        PetType o02 = new PetType();
        o02.setName(name02);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runRntityTest21(){
        log.info("runRntityTest21");
        PetType o01 = new PetType();
        o01.setName(name01);
        o01.setUuid(uuid);
        PetType o02 = new PetType();
        o02.setName(name02);
        o02.setUuid(uuid);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runRntityTest22(){
        log.info("runRntityTest22");
        PetType o01 = new PetType();
        o01.setName(name01);
        o01.setId(id);
        o01.setUuid(uuid);
        PetType o02 = new PetType();
        o02.setName(name02);
        o02.setUuid(uuid);
        o02.setId(id);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runRntityTest99(){
        log.info("runRntityTest99");
        Collections.sort(petTypeList);
        Assert.assertTrue(petTypeList.size() > 2);
        Iterator<PetType> i =  petTypeList.iterator();
        PetType firstEntity = i.next();
        while(i.hasNext()){
            PetType secondEntity = i.next();
            int compared = secondEntity.compareTo(firstEntity);
            Assert.assertTrue(compared > 0);
            firstEntity = secondEntity;
        }
    }

}
