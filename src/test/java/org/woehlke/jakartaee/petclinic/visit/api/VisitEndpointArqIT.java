package org.woehlke.jakartaee.petclinic.visit.api;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.java.Log;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@Log
@ExtendWith(ArquillianExtension.class)
public class VisitEndpointArqIT {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class);
    }

    @ArquillianResource
    private URL base;

    private Client client;

    @BeforeEach
    public void setup() {
        log.info("call BeforeEach");
        this.client = ClientBuilder.newClient();
        //removed the Jackson json provider registry, due to OpenLiberty 21.0.0.1 switched to use Resteasy.
    }

    @AfterEach
    public void teardown() {
        log.info("call AfterEach");
        if (this.client != null) {
            this.client.close();
        }
    }

    @Test
    @DisplayName("Given a name:`JakartaEE` should return `Say Hello to JakartaEE`")
    public void should_create_greeting() throws MalformedURLException {
        log.info(" client: "+client+", baseURL: "+ base);

        String endpoint = "/rest" + "/visit" + "/list";
        log.info("------------------------------------------------------------");
        log.info(" endpoint URL: " + base + endpoint);
        log.info("------------------------------------------------------------");

        final var greetingTarget = this.client.target(new URL(this.base, endpoint).toExternalForm());
        try (final Response greetingGetResponse = greetingTarget.request()
                .accept(MediaType.APPLICATION_JSON)
                .get()) {
            assertThat(greetingGetResponse.getStatus()).isEqualTo(200);
            //assertThat(greetingGetResponse.readEntity(GreetingMessage.class).getMessage()).startsWith("Say Hello to JakartaEE");
        }
    }
}
