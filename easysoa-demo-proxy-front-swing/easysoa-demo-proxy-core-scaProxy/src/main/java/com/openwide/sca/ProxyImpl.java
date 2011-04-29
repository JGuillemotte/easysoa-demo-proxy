/*
 * Generated from scaProxyTest.composite on 03/24/11 at 10:33:45.
 */

package com.openwide.sca;

import java.util.List;

import javax.script.Bindings;
import javax.script.ScriptEngineManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.objectweb.fractal.fscript.jsr223.FScriptEngineFactoryProxy;
import org.objectweb.fractal.fscript.jsr223.InvocableScriptEngine;
import org.osoa.sca.annotations.Service;
import org.osoa.sca.annotations.Reference;
import org.ow2.frascati.fscript.jsr223.FraSCAtiScriptEngineFactory;
import org.ow2.frascati.fscript.FraSCAtiFScript;

@Service(Proxy.class)
public class ProxyImpl implements Proxy {

	/** Reference to the node.js server */
	@Reference
	private NodeJSServer nodeJSServer;

	/*
	 * (non-Javadoc)
	 * @see com.openwide.sca.Proxy#redirectRequests(javax.ws.rs.core.UriInfo)
	 */
	public String redirectRequests(@Context UriInfo ui) {
	    MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
	    MultivaluedMap<String, String> pathParams = ui.getPathParameters();
		if(nodeJSServer == null){
			return "{\"message\" : \"Error : nodeJSServer object is null !\", \"userName\" : \"Not specified\"}";
		} else {
			List<String> params = queryParams.get("user");
			String user = "";
			if(params.size() > 0){
				user = params.get(0);
				System.out.println("[SCA PROXY TEST] user : " + user);
			}
			
			String serverResponse;
			// Call the fscript code to update fuse intent properties 
			// DOESN'T WORKS
			/*try{
				System.out.println("Trying to rearm fuse !");
				//System.setProperty(FScriptEngineFactoryProxy.SCRIPT_ENGINE_FACTORY_PROPERTY_NAME,"org.ow2.frascati.fscript.jsr223.FraSCAtiScriptEngineFactory");
		        //ScriptEngineManager manager = new ScriptEngineManager();
		        //new FraSCAtiScriptEngineFactory().addDomainToContext( manager.getBindings() ); // Add a global var for domain
		        //InvocableScriptEngine engine = (InvocableScriptEngine) manager.getEngineByExtension("fscript");
		        //Bindings ctx = engine.createBindings(); // our execution context
				
				FraSCAtiFScript fscript = FraSCAtiFScript.getSingleton();
				fscript.getScriptEngine().eval("fuse = $domain/scachild::fuse/scachild::components/scachild::fuseIntentHandler;");
				fscript.getScriptEngine().eval("maxRequestsNumber = $fuse/scaproperty::trippedFuse;");
				fscript.getScriptEngine().eval("set-value($trippedFuse, false)");
				//fscript.execute("fuse = $domain/scachild::fuse/scachild::components/scachild::fuseIntentHandler;");
		        //fscript.execute("maxRequestsNumber = $fuse/scaproperty::trippedFuse;");
		        //fscript.execute("set-value($trippedFuse, false)");
				
		        //engine.eval("fuse = $domain/scachild::fuse/scachild::components/scachild::fuseIntentHandler;", ctx);
		        //engine.eval("maxRequestsNumber = $fuse/scaproperty::trippedFuse;", ctx);
		        //engine.eval("set-value($trippedFuse, false)", ctx);
		        System.out.println("Done, fuse rearmed !");		
		        serverResponse = "Intent properties succesfully updated !";
			}
			catch(Exception ex){
				ex.printStackTrace();
				serverResponse = "An error occurs while trying to update intent properties !";
				System.out.println(serverResponse);
				return serverResponse;
			}*/
			
			serverResponse = nodeJSServer.getServerResponse(user);
			System.out.println("[SCA PROXY TEST] serverResponse : " + serverResponse);			
			return serverResponse;
		}
	}

}