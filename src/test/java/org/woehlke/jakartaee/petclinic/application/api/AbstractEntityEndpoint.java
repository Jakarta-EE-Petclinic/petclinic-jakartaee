package org.woehlke.jakartaee.petclinic.application.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class AbstractEntityEndpoint {

    protected static final Jsonb JSONB = JsonbBuilder.create();

    protected String port = "8080";
    protected String context = "petclinic";
    protected String url = "http://localhost:" + port + "/" + context;
    protected Client client = ClientBuilder.newClient();
}
