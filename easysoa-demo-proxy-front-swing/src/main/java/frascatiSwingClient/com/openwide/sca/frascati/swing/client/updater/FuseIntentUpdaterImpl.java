package frascatiSwingClient.com.openwide.sca.frascati.swing.client.updater;

import javax.script.Bindings;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.ws.rs.core.MediaType;

import org.objectweb.fractal.fscript.jsr223.FScriptEngineFactoryProxy;
import org.objectweb.fractal.fscript.jsr223.InvocableScriptEngine;
import org.ow2.frascati.fscript.jsr223.FraSCAtiScriptEngineFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class FuseIntentUpdaterImpl implements FuseIntentUpdater {

	public void updateMaxRequestsNumber(int newValue) throws ScriptException {
    	// THIS CODE DOESN'T WORKS.
		/*System.setProperty(FScriptEngineFactoryProxy.SCRIPT_ENGINE_FACTORY_PROPERTY_NAME,"org.ow2.frascati.fscript.jsr223.FraSCAtiScriptEngineFactory");
        ScriptEngineManager manager = new ScriptEngineManager();
        new FraSCAtiScriptEngineFactory().addDomainToContext( manager.getBindings() ); // Add a global var for domain
        InvocableScriptEngine engine = (InvocableScriptEngine) manager.getEngineByExtension("fscript");
        Bindings ctx = engine.createBindings(); // our execution context

        engine.eval("fuse = $domain/scachild::fuse/scachild::components/scachild::fuseIntentHandler;", ctx);
        engine.eval("maxRequestsNumber = $fuse/scaproperty::maxRequestsNumber;", ctx);
        engine.eval("set-value($maxRequestsNumber," + newValue + ")", ctx);
        */
    }

	public String rearmFuse() throws ScriptException {
		// Send HTTP GET request to server
        ClientConfig cc = new DefaultClientConfig();
        Client c = Client.create(cc);		
        WebResource resource = c.resource("http://localhost:7000/updateProperty");
        try{
        	String response = resource.queryParam("property", "trippedFuse").queryParam("value", "false").accept(MediaType.TEXT_PLAIN).get(String.class);
        	System.out.println(response.toString());
        	return response;
        }
        catch(Exception ex){
        	ex.printStackTrace();
        	return "An error occurs while trying to update property !";
        }		
	}
	
}
