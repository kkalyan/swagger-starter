
package com.kkalyan.main;

import com.wordnik.swagger.annotations.*;
import com.kkalyan.ApiException;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/user")
@Api(value="/user", description = "Operations about user")
@Produces({"application/json", "application/xml"})
public class UserResource {

  @POST
  @ApiOperation(value = "Create user",
    notes = "This can only be done by the logged in user.",
    position = 1)
  public Response createUser(
      @ApiParam(value = "Created user object", required = true) User user) {
    return Response.ok().entity(user).build();
  }


  @PUT
  @Path("/{username}")
  @ApiOperation(value = "Updated user",
    notes = "This can only be done by the logged in user.",
    position = 4)
  @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Invalid user supplied"),
      @ApiResponse(code = 404, message = "User not found") })
  public Response updateUser(
      @ApiParam(value = "name that need to be deleted", required = true) @PathParam("username") String username,
      @ApiParam(value = "Updated user object", required = true) User user) {
    return Response.ok().entity(user).build();
  }

  @DELETE
  @Path("/{username}")
  @ApiOperation(value = "Delete user",
    notes = "This can only be done by the logged in user.",
    position = 5)
  @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Invalid username supplied"),
      @ApiResponse(code = 404, message = "User not found") })
  public Response deleteUser(
      @ApiParam(value = "The name that needs to be deleted", required = true) @PathParam("username") String username) {
    return Response.ok().entity(new User()).build();
  }

  @GET
  @Path("/{username}")
  @ApiOperation(value = "Get user by user name",
    response = User.class,
    position = 0)
  @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Invalid username supplied"),
      @ApiResponse(code = 404, message = "User not found") })
  public Response getUserByName(
      @ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathParam("username") String username)
    throws ApiException {
      User user = new User();
      user.setName(username);
      return Response.ok().entity(user).build();
    
  }


}
