package org.woehlke.jakartaee.petclinic.application.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class AbstractEntityEndpoint {

    protected static final Jsonb jsonb = JsonbBuilder.create();
    protected Client client = ClientBuilder.newClient();

    private String port = "8080";
    private String context = "petclinic";
    private String host = "localhost";
    private String protocol = "http";

    protected String url = protocol + "://"+ host +":" + port + "/" + context;

}
