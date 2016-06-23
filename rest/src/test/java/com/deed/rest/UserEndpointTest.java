package com.deed.rest;


import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.WebTarget;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.Connection;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.HttpServerFilter;
import org.glassfish.grizzly.http.server.HttpServerProbe;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.deed.rest.client.RESTClient;
import com.deed.rest.endpoints.UserEndpoint;
import com.deed.rest.model.User;

public class UserEndpointTest {


	
	 /** end point for read queries */
    private WebTarget UserTarget;

    /** end point to supply updates */
    private WebTarget collect;
	private static final String BASE_URL = "http://localhost:8080";
	private static final String WEB_CONTEXT = "rest-template";
	private static final String REST_CONTEXT = "service";
	private static final String RESOURCE = "User";
    private static final Logger log = Logger.getLogger(UserEndpointTest.class);
    static HttpServer server = null;
	private RESTClient client = null;
	
	public UserEndpointTest(){
		RESTClient client = new RESTClient(BASE_URL,WEB_CONTEXT,REST_CONTEXT,RESOURCE);
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
    public static void  setUp() throws Exception {
		log.info("Starting local testing server: " + BASE_URL);
		log.info("Not for production use");

		final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(UserEndpoint.class);
        
		server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URL), resourceConfig, false);

		HttpServerProbe probe = new HttpServerProbe.Adapter() {
		    public void onRequestReceiveEvent(HttpServerFilter filter, Connection connection, Request request) {
		        //System.out.println(request.getRequestURI());
		    }
		};

		server.getServerConfiguration().getMonitoringConfig().getWebServerConfig().addProbes(probe);
		server.start();
		 log.info(format(" Server started.\n url=%s\n", BASE_URL));  

	}
	

	
	@Test
    public void createTest() {
		log.info("Create Response "+client.createUser(new User("shahbeg","shaheen","begum")));
		log.info("Get all Response "+client.getUsers());
		log.info("Update Response "+client.updateUser(new User("shahbeg","shaheen","begum")));
		log.info("Get Response "+client.getUser("shahbeg"));
		log.info("Delete Response "+client.deleteUser("shahbeg"));
		
		String response = client.createUser(new User("shahbeg","shaheen","begum"));
		System.out.println(response);
		assertEquals("{\"username\":\"shahbeg\",\"firstname\":\"shaheen\",\"lastname\":\"begum\"}",response );
		
    }
    
	@Test
    public void getUsers() {
		String response = client.getUsers();
		System.out.println(response);
		assertEquals("{\"username\":\"shahbeg\",\"firstname\":\"shaheen\",\"lastname\":\"begum\"}",response );
		
    }
	
	 @AfterClass
    public static void tearDown() throws Exception {
		log.info("Shuting down the server: " + BASE_URL);
		log.info("Not for production use");
        server.shutdownNow();
    }

  
	

}
