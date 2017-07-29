package com.kpgn.indiasaysserver.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;

@Path("/bwc")
public class BaseWebController {
	
	/*************************** Check Connection ****************************/
	
	@GET
    @Path("/isconnected")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
    public Response isConnected() {
        return Response.status(HttpStatus.SC_OK).build();
    }
	
}