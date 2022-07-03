package org.woehlke.jakartaee.petclinic.vet.api;

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
import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
public class VetEndpointIT {

  private static final Jsonb JSONB = JsonbBuilder.create();

  @Test
  public void testGetListJson() {
    String port = "9080";
    String context = "petclinic";
    String url = "http://localhost:" + port + "/" + context;
    String endpoint = url + "/rest" + "/vet" + "/list";
    log.info("------------------------------------------------------------");
    log.info(" endpoint URL: " + endpoint);
    log.info("------------------------------------------------------------");
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(endpoint);
    Response response = target.request().get();
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
                 "Incorrect response code from " + endpoint);
    String json = response.readEntity(String.class);
    VetListDto petTypeListDto = JSONB.fromJson(json, VetListDto.class);
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
    String port = "9080";
    String context = "petclinic";
    String url = "http://localhost:" + port + "/" + context;
    String endpoint = url + "/rest" + "/vet" + "/xml/list";
    log.info("------------------------------------------------------------");
    log.info(" endpoint URL: " + endpoint);
    log.info("------------------------------------------------------------");
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(endpoint);
    Response response = target.request().get();
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
                 "Incorrect response code from " + endpoint);
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
