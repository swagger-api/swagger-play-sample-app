package com.wordnik.swagger.sample.resource;

import javax.ws.rs.*;

import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.core.Api;

@Path("/pet.json")
@Api(value = "/pet", description = "Operations about pets")
@Singleton
@Produces({"application/json"})
public class PetResourceJSON extends PetResource {}