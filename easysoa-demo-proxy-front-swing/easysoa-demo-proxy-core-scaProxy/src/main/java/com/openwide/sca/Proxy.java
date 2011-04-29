/*
 * Generated from scaProxyTest.composite on 03/24/11 at 10:33:45.
 */

package com.openwide.sca;

import org.osoa.sca.annotations.Remotable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Remotable
public interface Proxy {

	@GET
	@Path("/")
	public String redirectRequests(@Context UriInfo ui);
	
}