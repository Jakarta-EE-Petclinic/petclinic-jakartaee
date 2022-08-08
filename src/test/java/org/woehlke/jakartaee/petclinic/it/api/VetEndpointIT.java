package org.woehlke.jakartaee.petclinic.it.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.java.Log;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.woehlke.jakartaee.petclinic.deployments.Deployments;
import org.woehlke.jakartaee.petclinic.vet.api.VetDto;
import org.woehlke.jakartaee.petclinic.vet.api.VetListDto;

import java.io.StringReader;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@Log
@ExtendWith(ArquillianExtension.class)
public class VetEndpointIT {

  @Deployment(testable = false)
  public static WebArchive createDeployment() {
    return Deployments.createDeployment();
  }

  @ArquillianResource
  private URL base;

  private Client client;

  @BeforeEach
  public void setup() {
    log.info("call BeforeEach");
    this.client = ClientBuilder.newClient();
  }

  @AfterEach
  public void teardown() {
    log.info("call AfterEach");
    if (this.client != null) {
      this.client.close();
    }
  }

  @Test
  public void testGetListJson() {
    String endpoint = base + "/rest" + "/vet" + "/list";
    log.info("------------------------------------------------------------");
    log.info(" endpoint URL: " + endpoint);
    log.info("------------------------------------------------------------");
    Jsonb jsonb = JsonbBuilder.create();
    WebTarget target = client.target(endpoint);
    Response response = target.request().get();
    assertThat(
            Response.Status.OK.getStatusCode() ==
            response.getStatus()
    );
    String json = response.readEntity(String.class);
    VetListDto petTypeListDto = jsonb.fromJson(json, VetListDto.class);
    for(VetDto dto: petTypeListDto.getVetList()){
      log.info("fetched dto: "+dto.toString());
    }
    json = "\n\n" + json +  "\n\n";
    log.info(json);
    response.close();
    client.close();
  }

  @Test
  public void testGetListXml() throws JAXBException {
    String endpoint = base + "/rest" + "/vet" + "/xml/list";
    log.info("------------------------------------------------------------");
    log.info(" endpoint URL: " + endpoint);
    log.info("------------------------------------------------------------");
    WebTarget target = client.target(endpoint);
    Response response = target.request().get();
    assertThat(
            Response.Status.OK.getStatusCode() ==
            response.getStatus()
    );
    String xml = response.readEntity(String.class);
    JAXBContext jc = JAXBContext.newInstance(VetListDto.class);
    Unmarshaller m = jc.createUnmarshaller();
    StringReader r  = new StringReader(xml);
    VetListDto o = (VetListDto) m.unmarshal(r);
    for(VetDto dto: o.getVetList()){
      log.info("fetched dto: "+dto.toString());
    }
    xml = "\n\n" + xml +  "\n\n";
    log.info(xml);
    response.close();
    client.close();
  }
}
