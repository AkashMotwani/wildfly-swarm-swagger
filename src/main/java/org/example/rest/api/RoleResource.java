package org.example.rest.api;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/hello")
@Api(value = "/time", description = "Get message based on role endpoint", tags = "role")
@Produces(MediaType.TEXT_PLAIN)
public class RoleResource {

	
	//TODO Apply OAuth 2 Role Based Security
	@GET
	@Path("/userMessage")
	@ApiOperation(value = "Get user message", notes = "Returns user message as a string", response = String.class)
	@Produces(MediaType.TEXT_PLAIN)
	public Response userMsg() {
		return Response.ok("This is demo message from user").build();
	}
	
	//TODO Apply OAuth 2 Role Based Security
	@GET
	@Path("/adminMessage")
	@ApiOperation(value = "Get admin message", notes = "Returns admin message as a string", response = String.class)
	@Produces(MediaType.TEXT_PLAIN)
	public Response adminMsg() {
		return Response.ok("This is demo message from admin").build();
	}
}