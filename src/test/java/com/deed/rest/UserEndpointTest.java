package com.deed.rest;


import static org.junit.Assert.assertEquals;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.apache.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.deed.rest.client.RESTClient;
import com.deed.rest.endpoints.UserEndpoint;
import com.deed.rest.model.User;

/**
 * Junit test class for com.deed.rest.endpoints.UserEndpoint resource.
 * Some pointers to developers:-
 * 1. One Test class for one resource.
 * 2. Naming convention : <ClassName>Test , as an example; For a class named 'UserEndpoint' the corresponding  test class should be named 'UserEndpointTest'
 * 3. Each test case should be independent of each other.
 * @author deedsing
 *
 */
public class UserEndpointTest   {
	
	public static final URI BASE_URI = UriBuilder.fromUri("http://localhost").port(8000).build();
	private static final String RESOURCE = "User";
    private static final Logger log = Logger.getLogger(UserEndpointTest.class);
    static HttpServer server = null;
	private RESTClient client = null;

	/*Use constructor to do some intializaion , here we will create a RESTClient object*/
	public UserEndpointTest(){
		RESTClient client = new RESTClient(BASE_URI.toString(),RESOURCE);
        this.client=client;      
	}
	

	    @BeforeClass
	    public static void setUp() throws Exception {
            
	    	final ResourceConfig resourceConfig = new ResourceConfig();
			
	    	/*Register REST Resource or Webservice endpoints. */
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
		String response = client.createUser(new User("hanusing","opender","deep"));
		assertEquals("{\"username\":\"hanusing\",\"firstname\":\"opender\",\"lastname\":\"deep\"}",response );
		
    }
	
	@Test
    public void updateTest() {
		String response = client.createUser(new User("hanusing","opender","deep"));
		assertEquals("{\"username\":\"hanusing\",\"firstname\":\"opender\",\"lastname\":\"deep\"}",response );
		response = client.updateUser(new User("hanusing","Openderdeep","Singh"));
		System.out.println(response);
		assertEquals("{\"username\":\"hanusing\",\"firstname\":\"Openderdeep\",\"lastname\":\"Singh\"}",response );
		
    }
	
	
    
	@Test
    public void readUsers() {
		String response = client.getUsers();
		System.out.println(response);
		assert(response!=null&&response.contains("\"username\":\"deedsing\""));
		
    }
	
	@Test
    public void readUser() {
		String response = client.getUser("deedsing");
		System.out.println(response);
		assert(response!=null&&response.contains("\"username\":\"deedsing\""));
		
    }
	
	@Test
    public void deleteUsers() {
		String response = client.createUser(new User("hanusing","opender","deep"));
		assertEquals("{\"username\":\"hanusing\",\"firstname\":\"opender\",\"lastname\":\"deep\"}",response );
		String responseCode = client.deleteUser("hanusing");
		assertEquals("200",responseCode );
		
    }

	

}
