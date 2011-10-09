package com.wordnik.swagger.sample.resource;

import com.wordnik.swagger.core.*;
import com.wordnik.swagger.sample.data.UserData;
import com.wordnik.swagger.sample.model.User;
import com.wordnik.swagger.sample.exception.ApiException;
import com.wordnik.swagger.sample.exception.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

public class UserResource {
	static UserData userData = new UserData();

	@POST
	@ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.")
	public Response createUser(
			@ApiParam(value = "Created user object", required = true) User user) {
		userData.addUser(user);
		return Response.ok().entity("").build();
	}

	@PUT
	@Path("/{username}")
	@ApiOperation(value = "Updated user", notes = "This can only be done by the logged in user.")
	@ApiErrors(value = {
			@ApiError(code = 400, reason = "Invalid user supplied"),
			@ApiError(code = 404, reason = "User not found") })
	public Response updateUser(
			@ApiParam(value = "name that need to be deleted", required = true) @PathParam("username") String username,
			@ApiParam(value = "Updated user object", required = true) User user) {
		userData.addUser(user);
		return Response.ok().entity("").build();
	}

	@DELETE
	@Path("/{username}")
	@ApiOperation(value = "Delete user", notes = "This can only be done by the logged in user.")
	@ApiErrors(value = {
			@ApiError(code = 400, reason = "Invalid username supplied"),
			@ApiError(code = 404, reason = "User not found") })
	public Response deleteUser(
			@ApiParam(value = "The name that needs to be deleted", required = true) @PathParam("username") String username) {
		userData.removeUser(username);
		return Response.ok().entity("").build();
	}

	@GET
	@Path("/{username}")
	@ApiOperation(value = "Get user by user name", responseClass = "com.wordnik.swagger.sample.model.User")
	@ApiErrors(value = {
			@ApiError(code = 400, reason = "Invalid username supplied"),
			@ApiError(code = 404, reason = "User not found") })
	public Response getUserByName(
			@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathParam("username") String username) 
		throws ApiException {
		User user = userData.findUserByName(username);
		if (null != user) {
			return Response.ok().entity(user).build();
		} else {
			throw new NotFoundException(404, "User not found");
		}
	}

	@GET
	@Path("/login")
	@ApiOperation(value = "Logs user into the system", responseClass = "String")
	@ApiErrors(value = { @ApiError(code = 400, reason = "Invalid username/password supplied") })
	public Response loginUser(
			@ApiParam(value = "The user name for login", required = true) @QueryParam("username") String username,
			@ApiParam(value = "The password for login in clear text", required = true) @QueryParam("password") String password) {
		return Response.ok()
				.entity("logged in user session:" + System.currentTimeMillis())
				.build();
	}

	@GET
	@Path("/logout")
	@ApiOperation(value = "Logs out current logged in user session")
	public Response logoutUser() {
		return Response.ok().entity("").build();
	}
}
