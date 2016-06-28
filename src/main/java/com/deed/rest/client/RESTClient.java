package com.deed.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.deed.rest.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Client to call rest endpoint and capture response.
 * */
public class RESTClient {

	private static final String BASE_URI = "http://localhost:8080";
	/** end point for read queries */
	private WebTarget user;

	public RESTClient() {
		Client client = ClientBuilder.newClient();
		user = client.target(BASE_URI + "/rest-template/service/User");

	}
	
	/**
	 * This constructor is used to configure Test client and is meant to use with Grizly 
	 * server.
	 * @param baseURI
	 * @param resource
	 */
	public RESTClient(String baseURI,String resource) {
		Client client = ClientBuilder.newClient();
		user = client.target(baseURI+"/"+resource);


	}

	public String createUser(User u) {
		Response response = user.request().post(Entity.entity(u, "application/json"));
		String entity = response.readEntity(String.class);
		return entity;

	}

	public String updateUser(User u) {
		Response response = user.request().put(Entity.entity(u, "application/json"));
		String entity = response.readEntity(String.class);
		return entity;

	}

	public String getUser(String uid) {
		WebTarget path = user.path("/" + uid);
		Response response = path.request().get();
		String entity = response.readEntity(String.class);
		return entity;

	}

	public String deleteUser(String uid) {
		WebTarget path = user.path("/" + uid);
		Response response = path.request().delete();
		String entity = String.valueOf(response.getStatus());
		return entity;

	}

	public String getUsers() {
		Response response = user.request().get();
		String entity = response.readEntity(String.class);
		//String entity = String.valueOf(response.getStatus());
		return entity;

	}

	/**
	 * The method demonstrate how to use this client to perform CRUD operations on running instance of REST service.
	 * Please uncomment and change base URI , to use this client as per the application  setup.
	 * @param args
	 */
	public static void main(String[] args) {
		RESTClient client = new RESTClient();

		/* create a new user */
		 String responseString = client.createUser(new
		 User("shahbeg","shaheen","begum"));

		/* update a new user */
		// String responseString = client.updateUser(new
		// User("shahbeg","shaheen","begum"));

		/* get all user */
		//String responseString = client.getUsers();

		/* get a user */
		// String responseString = client.getUser("hanusingh");

		/* delete a user */
		// String responseString = client.deleteUser("hanusingh");

		System.out.println(responseString);

	}

}
