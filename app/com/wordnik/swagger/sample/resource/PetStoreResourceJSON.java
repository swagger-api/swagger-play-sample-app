package com.wordnik.swagger.sample.resource;

import javax.ws.rs.*;

import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.core.Api;

@Path("/store.json")
@Singleton
@Api(value="/store" , description = "Operations about store")
@Produces({"application/json"})
public class PetStoreResourceJSON extends PetStoreResource {}
