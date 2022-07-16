package org.woehlke.jakartaee.petclinic.specialty;

import junit.framework.Assert;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.woehlke.jakartaee.petclinic.application.api.AbstractEntityTest;

import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;


@Log
public class SpecialtyTest extends AbstractEntityTest {

    @Test
    void runSpecialtyTest01(){
        log.info("runSpecialtyTest01");
        String name = "wooollooomooollooo";
        UUID uuid01 = UUID.randomUUID();
        UUID uuid02 = UUID.randomUUID();
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Specialty specialty01 = new Specialty();
        specialty01.setName(name);
        specialty01.setUuid(uuid01);
        Specialty specialty02 = new Specialty();
        specialty02.setName(name);
        specialty02.setUuid(uuid02);
        Assert.assertTrue(specialty01.compareTo(specialty02)==0);
    }

    @Test
    void runSpecialtyTest02(){
        log.info("runSpecialtyTest02");
        String name = "wooollooomooollooo";
        UUID uuid01 = UUID.randomUUID();
        UUID uuid02 = UUID.randomUUID();
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Long id01 = 1L;
        Long id02 = 2L;
        Assert.assertFalse(id01.compareTo(id02)==0);
        Specialty specialty01 = new Specialty();
        specialty01.setName(name);
        specialty01.setId(id01);
        specialty01.setUuid(uuid01);
        Specialty specialty02 = new Specialty();
        specialty02.setName(name);
        specialty02.setUuid(uuid02);
        specialty02.setId(id02);
        Assert.assertTrue(specialty01.compareTo(specialty02)==0);
    }

    @Test
    void runSpecialtyTest11(){
        log.info("runSpecialtyTest11");
        String name01 = "wooollooomooollooo";
        String name02 = "huulluuumuuulluuu";
        UUID uuid01 = UUID.randomUUID();
        UUID uuid02 = UUID.randomUUID();
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Specialty specialty01 = new Specialty();
        specialty01.setName(name01);
        specialty01.setUuid(uuid01);
        Specialty specialty02 = new Specialty();
        specialty02.setName(name02);
        specialty02.setUuid(uuid02);
        Assert.assertFalse(specialty01.compareTo(specialty02)==0);
    }

    @Test
    void runSpecialtyTest12(){
        log.info("runSpecialtyTest12");
        String name01 = "wooollooomooollooo";
        String name02 = "huulluuumuuulluuu";
        UUID uuid01 = UUID.randomUUID();
        UUID uuid02 = UUID.randomUUID();
        Assert.assertFalse(uuid01.compareTo(uuid02)==0);
        Long id01 = 1L;
        Long id02 = 2L;
        Assert.assertFalse(id01.compareTo(id02)==0);
        Specialty specialty01 = new Specialty();
        specialty01.setName(name01);
        specialty01.setId(id01);
        specialty01.setUuid(uuid01);
        Specialty specialty02 = new Specialty();
        specialty02.setName(name02);
        specialty02.setUuid(uuid02);
        specialty02.setId(id02);
        Assert.assertFalse(specialty01.compareTo(specialty02)==0);
    }

    @Test
    void runSpecialtyTest21(){
        log.info("runSpecialtyTest11");
        String name01 = "wooollooomooollooo";
        String name02 = "huulluuumuuulluuu";
        UUID uuid = UUID.randomUUID();
        Specialty specialty01 = new Specialty();
        specialty01.setName(name01);
        specialty01.setUuid(uuid);
        Specialty specialty02 = new Specialty();
        specialty02.setName(name02);
        specialty02.setUuid(uuid);
        Assert.assertFalse(specialty01.compareTo(specialty02)==0);
    }

    @Test
    void runSpecialtyTest22(){
        log.info("runSpecialtyTest12");
        String name01 = "wooollooomooollooo";
        String name02 = "huulluuumuuulluuu";
        UUID uuid = UUID.randomUUID();
        Long id = 1L;
        Specialty specialty01 = new Specialty();
        specialty01.setName(name01);
        specialty01.setId(id);
        specialty01.setUuid(uuid);
        Specialty specialty02 = new Specialty();
        specialty02.setName(name02);
        specialty02.setUuid(uuid);
        specialty02.setId(id);
        Assert.assertFalse(specialty01.compareTo(specialty02)==0);
    }

    @Test
    void runSpecialtyTest99(){
        log.info("runSpecialtyTest100");
        Collections.sort(specialtyList);
        Assert.assertTrue(specialtyList.size() > 2);
        Iterator<Specialty> i =  specialtyList.iterator();
        Specialty firstSpecialty = i.next();
        while(i.hasNext()){
            Specialty secondSpecialty = i.next();
            int compared = secondSpecialty.compareTo(firstSpecialty);
            Assert.assertTrue(compared > 0);
            firstSpecialty = secondSpecialty;
        }
    }
}
