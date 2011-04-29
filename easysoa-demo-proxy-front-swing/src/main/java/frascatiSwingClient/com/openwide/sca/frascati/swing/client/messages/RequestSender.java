package frascatiSwingClient.com.openwide.sca.frascati.swing.client.messages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RequestSender {

	public String sendRequest(String user) {
		String userParam = "";
		if(user != null){
			userParam = user;
		}
		// Send HTTP GET request to server
        ClientConfig cc = new DefaultClientConfig();
        Client c = Client.create(cc);		
        WebResource resource = c.resource("http://localhost:7000/");
        try{
        	String response = resource.queryParam("user", userParam).accept(MediaType.APPLICATION_JSON).get(String.class);
        	System.out.println(response.toString());
        	return response;
        }
        catch(Exception ex){
        	return "";
        }
	}
	
}
