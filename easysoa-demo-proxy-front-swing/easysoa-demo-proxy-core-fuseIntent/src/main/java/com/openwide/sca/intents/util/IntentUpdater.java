package com.openwide.sca.intents.util;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public interface IntentUpdater {

	@GET
	@Path("/updateProperty")
	public String updateProperty(@Context UriInfo ui, @QueryParam("property") String propName, @QueryParam("value") String propValue);
	
}
