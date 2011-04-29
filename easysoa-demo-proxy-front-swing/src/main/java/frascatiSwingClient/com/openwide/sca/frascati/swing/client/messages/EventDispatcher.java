package frascatiSwingClient.com.openwide.sca.frascati.swing.client.messages;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class EventDispatcher {

	public final static String subscribe() {
		// Send HTTP GET request to subscribe
        ClientConfig cc = new DefaultClientConfig();
        Client c = Client.create(cc);		
        WebResource resource = c.resource("http://localhost:7002/");
        String response = resource.queryParam("action", "subscribe").queryParam("port", "7003").get(String.class);
        System.out.println("Event dispatcher response : " + response.toString());
        return response;
	}
	
	public final static String unsubscribe(){
		// Send HTTP GET request to subscribe
        ClientConfig cc = new DefaultClientConfig();
        Client c = Client.create(cc);		
        WebResource resource = c.resource("http://localhost:7002/");
        String response = resource.queryParam("action", "unsubscribe").get(String.class);
        System.out.println("Event dispatcher response : " + response.toString());
        return response;
	}
	
    @GET
	@Path("/")
	@Produces("test/plain")
	public String listenMessage(){
		return ("Message transmitted !");
	}	
}
