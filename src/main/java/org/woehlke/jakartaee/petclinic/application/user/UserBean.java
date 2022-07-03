package org.woehlke.jakartaee.petclinic.application.user;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;

import java.io.Serializable;


@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return "foo";
    }

    public String getRoles() {
        return "";
    }

    public boolean isAuthenticated(){
        return true;
    }

}
