package com.openwide.sca.intents.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

public interface EventDispatcherMessage {

	/**
	 * Returns extended information of a given user in JSON format.
	 */
	@GET
	@Path("/")
	@Produces("text/plain")
	//String getServerResponse(@QueryParam("user") String user);
	String sendMessage(@QueryParam("message") String message, @QueryParam("action") String action);
	
}
