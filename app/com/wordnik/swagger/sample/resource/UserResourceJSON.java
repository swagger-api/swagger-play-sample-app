package com.wordnik.swagger.sample.resource;

import javax.ws.rs.*;

import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.core.Api;

@Path("/user.json")
@Singleton
@Api(value="/user", description = "Operations about user")
@Produces({"application/json"})
public class UserResourceJSON extends UserResource {}
