package com.wordnik.swagger.sample.resource;

import javax.ws.rs.*;

import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.core.Api;

@Path("/user.xml")
@Singleton
@Api(value="/user", description = "Operations about user")
@Produces({"application/xml"})
public class UserResourceXML extends UserResource {}
