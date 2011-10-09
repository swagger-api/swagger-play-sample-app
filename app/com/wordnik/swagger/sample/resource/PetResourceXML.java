package com.wordnik.swagger.sample.resource;

import javax.ws.rs.*;

import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.core.Api;

@Path("/pet.xml")
@Api(value = "/pet", description = "Operations about pets")
@Singleton
@Produces({"application/xml"})
public class PetResourceXML extends PetResource {}