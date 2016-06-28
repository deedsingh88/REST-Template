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

import com.deed.rest.model.ErrorResponse;
import com.deed.rest.model.User;
import com.deed.rest.model.UserData;

/**
 * <h1>UserEndpoint</h1>
 * <p>A REST service endpoint.
 * REST implementation demonstrating CRUD operations for a {@link User} User object.
 * </p>
 * @author deedsing
 *
 */
@Path("/User")
public class UserEndpoint  implements UserI{

    
	
	@POST
    @Produces("application/json")
    @Consumes("application/json")
    
    public Response createUser(User user) {

      
        	if(user!=null){
            UserData.data.put(user.getUsername(), user);
            return Response.ok(user).build();
        	}else
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse("BAD_REQUEST","User Data not structured properly ")).build();
        }      
    
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
    	//sample data for reference
    	UserData.data.put("deedsing", new User("deedsing","Deed","Singh"));
        return Response.status(Response.Status.OK).entity(UserData.data).build();
	}
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/{user}")
	public Response getUser(@PathParam("user") String user) {
    	if(UserData.data.get(user)!=null){
    		return Response.ok(UserData.data.get(user)).build();
    	}else
    		return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse("NOT_FOUND","User "+user+" does not exist ")).build();
    	
    }
    
    @DELETE
   	@Produces(MediaType.APPLICATION_JSON)
    @Path("/{user}")
   	public Response deleteUser(@PathParam("user") String user) {
       	if(UserData.data.get(user)!=null){
       		UserData.data.remove(user);
       		return Response.ok().build();
       	}else
       		return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse("NOT_FOUND","User "+user+" does not exist ")).build();
       	
       }
        
      
   
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    
    public Response updateUser(User user) {

      
    	if(UserData.data.get(user.getUsername())!=null){
            UserData.data.put(user.getUsername(), user);
            return Response.ok(user).build();
        	}else
        		return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse("NOT_FOUND","User "+user+" does not exist ")).build();
        }


	  

   
    
}

