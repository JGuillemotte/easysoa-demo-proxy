package com.openwide.sca.intents;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

public interface EventDispatcher {

	/**
	 * Returns extended information of a given user in JSON format.
	 */
	@GET
	@Path("/")
	@Produces("text/plain")
	String sendMessage(@QueryParam("user") String user);
		
}