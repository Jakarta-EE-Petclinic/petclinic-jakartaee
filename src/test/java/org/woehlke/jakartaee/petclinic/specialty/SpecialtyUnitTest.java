package org.woehlke.jakartaee.petclinic.specialty;

import junit.framework.Assert;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.woehlke.jakartaee.petclinic.application.api.AbstractEntityTest;

import java.util.Collections;
import java.util.Iterator;


@Log
public class SpecialtyUnitTest extends AbstractEntityTest {

    @Test
    void runEntityTest01(){
        log.info("runEntityTest01");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Specialty o01 = new Specialty();
        o01.setName(name01);
        o01.setUuid(uuid01);
        Specialty o02 = new Specialty();
        o02.setName(name01);
        o02.setUuid(uuid02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest02(){
        log.info("runEntityTest02");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        Specialty o01 = new Specialty();
        o01.setName(name01);
        o01.setId(id01);
        o01.setUuid(uuid01);
        Specialty o02 = new Specialty();
        o02.setName(name01);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertTrue(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest11(){
        log.info("runEntityTest11");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Specialty o01 = new Specialty();
        o01.setName(name01);
        o01.setUuid(uuid01);
        Specialty o02 = new Specialty();
        o02.setName(name02);
        o02.setUuid(uuid02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest12(){
        log.info("runEntityTest12");
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Assert.assertFalse(id01.compareTo(id02)==0);
        Specialty o01 = new Specialty();
        o01.setName(name01);
        o01.setId(id01);
        o01.setUuid(uuid01);
        Specialty o02 = new Specialty();
        o02.setName(name02);
        o02.setUuid(uuid02);
        o02.setId(id02);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest21(){
        log.info("runEntityTest21");
        Specialty o01 = new Specialty();
        o01.setName(name01);
        o01.setUuid(uuid);
        Specialty o02 = new Specialty();
        o02.setName(name02);
        o02.setUuid(uuid);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest22(){
        log.info("runEntityTest22");
        Specialty o01 = new Specialty();
        o01.setName(name01);
        o01.setId(id);
        o01.setUuid(uuid);
        Specialty o02 = new Specialty();
        o02.setName(name02);
        o02.setUuid(uuid);
        o02.setId(id);
        Assert.assertFalse(o01.compareTo(o02)==0);
    }

    @Test
    void runEntityTest99(){
        log.info("runEntityTest99");
        Collections.sort(specialtyList);
        Assert.assertTrue(specialtyList.size() > 2);
        Iterator<Specialty> i =  specialtyList.iterator();
        Specialty firstEntity = i.next();
        while(i.hasNext()){
            Specialty secondEntity = i.next();
            int compared = secondEntity.compareTo(firstEntity);
            Assert.assertTrue(compared > 0);
            firstEntity = secondEntity;
        }
    }
}
