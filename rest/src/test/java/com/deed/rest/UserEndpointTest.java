package com.deed.rest;


import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.Connection;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.HttpServerFilter;
import org.glassfish.grizzly.http.server.HttpServerProbe;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.deed.rest.client.RESTClient;
import com.deed.rest.endpoints.UserEndpoint;
import com.deed.rest.model.User;

public class UserEndpointTest   {
	
	public static final URI BASE_URI = UriBuilder.fromUri("http://localhost").port(8080).build();
	private static final String RESOURCE = "User";
    private static final Logger log = Logger.getLogger(UserEndpointTest.class);
    static HttpServer server = null;
	private RESTClient client = null;
	  private WebTarget target;
	
	public UserEndpointTest(){
		RESTClient client = new RESTClient(BASE_URI.toString(),RESOURCE);
        this.client=client;
		/* create a new user */
		// String responseString = client.createUser(new
		// User("shahbeg","shaheen","begum"));

		/* update a new user */
		// String responseString = client.updateUser(new
		// User("shahbeg","shaheen","begum"));

		/* get all user */
		String responseString = client.getUsers();

		/* get a user */
		// String responseString = client.getUser("hanusingh");

		/* delete a user */
		// String responseString = client.deleteUser("hanusingh");

		System.out.println(responseString);

      
	}
	

	    @BeforeClass
	    public static void setUp() throws Exception {
            
	    	final ResourceConfig resourceConfig = new ResourceConfig();
			resourceConfig.register(UserEndpoint.class);
	        server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig,false);
	        server.start();
	        log.info("Grizly server started at : " + BASE_URI);
			log.info("Not for production use");
	      
	    }

	    @AfterClass
	    public static void tearDown() throws Exception {
	    	log.info("Shutting down the server ... ");
	        server.shutdownNow();
	    }


	
	@Test
    public void createTest() {	
		String response = client.createUser(new User("shahbeg","shaheen","begum"));
		assertEquals("{\"username\":\"shahbeg\",\"firstname\":\"shaheen\",\"lastname\":\"begum\"}",response );
		
    }
	
	@Test
    public void updateTest() {
		// first we will create a user
		String response = client.createUser(new User("shahbeg","shaheen","begum"));
		assertEquals("{\"username\":\"shahbeg\",\"firstname\":\"shaheen\",\"lastname\":\"begum\"}",response );
		response = client.updateUser(new User("shahbeg","shaheen1","begum"));
		System.out.println(response);
		assertEquals("{\"username\":\"shahbeg\",\"firstname\":\"shaheen1\",\"lastname\":\"begum\"}",response );
		
    }
	
	
    
	@Test
    public void readUsers() {
		String response = client.getUsers();
		System.out.println(response);
		assert(response!=null&&response.contains("\"username\":\"deedsing\""));
		
    }
	
	@Test
    public void readUser() {
		String response = client.getUser("shahbeg");
		System.out.println(response);
		assert(response!=null&&response.contains("\"username\":\"shahbeg\""));
		
    }
	
	@Test
    public void deleteUsers() {
		String response = client.createUser(new User("shahbeg","shaheen","begum"));
		assertEquals("{\"username\":\"shahbeg\",\"firstname\":\"shaheen\",\"lastname\":\"begum\"}",response );
		String responseCode = client.deleteUser("shahbeg");
		assertEquals("200",responseCode );
		
    }

	

}
