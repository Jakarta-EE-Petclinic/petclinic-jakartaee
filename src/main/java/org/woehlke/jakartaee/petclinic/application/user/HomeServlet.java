package org.woehlke.jakartaee.petclinic.application.user;

import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/home")
@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                errorPage = "/error.jsf",
                loginPage = "/welcome.jsf"
        )
)
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = { "user", "admin", "ALL_AUTHENTICATED_USERS" },
                transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL
        )
)
public class HomeServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;

    @Inject
    private SecurityContext securityContext;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (securityContext.isCallerInRole(Utils.ALL_AUTHENTICATED_USERS)) {
            response.sendRedirect("/petclinic/start.jsf");
        } else if (securityContext.isCallerInRole(Utils.EVERYONE)) {
            response.sendRedirect("/petclinic/error.jsf");
        } else if (securityContext.isCallerInRole(Utils.ADMIN)) {
            response.sendRedirect("/petclinic/admin.jsf");
        } else if (securityContext.isCallerInRole(Utils.USER)) {
            response.sendRedirect("/petclinic/user.jsf");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
