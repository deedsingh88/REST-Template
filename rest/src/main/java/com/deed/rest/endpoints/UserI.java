package com.deed.rest.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deed.rest.model.User;

/**
 * Interface definition that could be shared to clients.
 * @author deedsing
 *
 */
public interface UserI {

	
	/**
	 * Create a User.
	 * @param user
	 * @return
	 */
	@POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUser(User user);
    
    
    /**
     * Get list of all users.
     * @return
     */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() ;
    
	/**
	 * Get a user identified by username {user}
	 * @param user
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/{user}")
	public Response getUser(@PathParam("user") String user) ;
    
	/**
	 * Delete a user identified by username {user}
	 * @param user
	 * @return
	 */
    @DELETE
   	@Produces(MediaType.APPLICATION_JSON)
    @Path("/{user}")
   	public Response deleteUser(@PathParam("user") String user) ;
        
      
    /**
     * Update a user that is already existing in the system.
     * @param user
     * @return
     */
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateUser(User user) ;
   
}

