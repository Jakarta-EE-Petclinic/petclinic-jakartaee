package org.woehlke.jakartaee.petclinic.application.api;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 05.01.14
 * Time: 09:27
 * To change this template use File | Settings | File Templates.
 */
@ApplicationPath("/rest")
public class PetclinicApplication extends Application implements Serializable {

    private static final long serialVersionUID = 6101321761195838117L;
}
