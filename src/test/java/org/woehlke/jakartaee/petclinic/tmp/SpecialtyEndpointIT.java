package org.woehlke.jakartaee.petclinic.tmp;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.woehlke.jakartaee.petclinic.specialty.api.SpecialtyDto;
import org.woehlke.jakartaee.petclinic.specialty.api.SpecialtyListDto;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

@Log
public class SpecialtyEndpointIT extends AbstractEndpointTest {

  @Test
  public void testGetListJson() {
    String endpoint = url + "/rest" + "/specialty" + "/list";
    log.info("------------------------------------------------------------");
    log.info(" endpoint URL: " + endpoint);
    log.info("------------------------------------------------------------");
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(endpoint);
    Response response = target.request().get();
    assertThat(
            Response.Status.OK.getStatusCode()==
            response.getStatus()
    );
    String json = response.readEntity(String.class);
    SpecialtyListDto petTypeListDto = jsonb.fromJson(json, SpecialtyListDto.class);
    for(SpecialtyDto dto: petTypeListDto.getSpecialty()){
      log.info("fetched dto: "+dto.toString());
    }
    json = "\n\n" + json +  "\n\n";
    log.info(json);
    response.close();
    client.close();
  }

  @Test
  public void testGetListXml() throws JAXBException {
    String endpoint = url + "/rest" + "/specialty" + "/xml/list";
    log.info("------------------------------------------------------------");
    log.info(" endpoint URL: " + endpoint);
    log.info("------------------------------------------------------------");
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(endpoint);
    Response response = target.request().get();
    assertThat(
            Response.Status.OK.getStatusCode()==
            response.getStatus()
    );
    String xml = response.readEntity(String.class);
    JAXBContext jc = JAXBContext.newInstance(SpecialtyListDto.class);
    Unmarshaller m = jc.createUnmarshaller();
    StringReader r  = new StringReader(xml);
    SpecialtyListDto o = (SpecialtyListDto) m.unmarshal(r);
    for(SpecialtyDto dto: o.getSpecialty()){
      log.info("fetched dto: "+dto.toString());
    }
    xml = "\n\n" + xml +  "\n\n";
    log.info(xml);
    response.close();
    client.close();
  }

}
