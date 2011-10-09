package com.wordnik.swagger.sample.resource;

import javax.ws.rs.*;

import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.core.Api;

@Path("/store.xml")
@Singleton
@Api(value="/store", description = "Operations about store")
@Produces({"application/xml"})
public class PetStoreResourceXML extends PetStoreResource {}
