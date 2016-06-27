package com.deed.rest;



import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.deed.rest.endpoints.UserEndpoint;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.junit.Assert.assertEquals;

public class RunGrizlly {
    public static final URI BASE_URI = UriBuilder.fromUri("http://localhost").port(8080).build();
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {

    	final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(UserEndpoint.class);
        server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig);

        server.start();
        Client c = ClientBuilder.newClient();
        target = c.target(BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("User").request().get(String.class); // <--- line 45 in exception!!!
        System.out.println(responseMsg);
        System.out.println(BASE_URI.toString());
        assertEquals("Got it!", responseMsg);
    }
}