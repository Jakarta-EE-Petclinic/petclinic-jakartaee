package org.woehlke.jakartaee.petclinic.arquillian;


import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
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
import org.woehlke.jakartaee.petclinic.visit.api.VisitDto;
import org.woehlke.jakartaee.petclinic.visit.api.VisitListDto;

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
        Jsonb jsonb = JsonbBuilder.create();
        Client client = ClientBuilder.newClient();

        log.info("------------------------------------------------------------");
        log.info(" client: "+client+", baseURL: "+ base);
        log.info("------------------------------------------------------------");
        String endpoint = "/rest" + "/visit" + "/list";
        log.info("------------------------------------------------------------");
        log.info(" endpoint URL: " + base + endpoint);
        log.info("------------------------------------------------------------");

        WebTarget target = client.target(endpoint);
        Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        String json = response.readEntity(String.class);
        VisitListDto petTypeListDto = jsonb.fromJson(json, VisitListDto.class);
        for(VisitDto dto: petTypeListDto.getVisit()){
            log.info("fetched dto: "+dto.toString());
        }
        json = "\n\n" + json +  "\n\n";
        log.info(json);
        response.close();
        client.close();
    }
}
