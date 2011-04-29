package com.openwide.sca.intents.util;

import javax.ws.rs.core.UriInfo;
import javax.script.Bindings;
import javax.script.ScriptEngineManager;
import org.objectweb.fractal.fscript.jsr223.FScriptEngineFactoryProxy;
import org.objectweb.fractal.fscript.jsr223.InvocableScriptEngine;
import org.osoa.sca.annotations.Service;
import org.ow2.frascati.fscript.jsr223.FraSCAtiScriptEngineFactory;

@Service(IntentUpdater.class)
public class IntentUpdaterImpl implements IntentUpdater {

	public String updateProperty(UriInfo ui, String propName, String propValue) {
		System.out.println("Update property : " + propName);
		System.out.println("Update value : " + propValue);
		String response;
		// Code ici pour appeler le FScript de maj des properties 
		try{
			System.out.println("Trying to rearm fuse !");
			System.setProperty(FScriptEngineFactoryProxy.SCRIPT_ENGINE_FACTORY_PROPERTY_NAME,"org.ow2.frascati.fscript.jsr223.FraSCAtiScriptEngineFactory");
	        ScriptEngineManager manager = new ScriptEngineManager();
	        new FraSCAtiScriptEngineFactory().addDomainToContext( manager.getBindings() ); // Add a global var for domain
	        InvocableScriptEngine engine = (InvocableScriptEngine) manager.getEngineByExtension("fscript");
	        Bindings ctx = engine.createBindings(); // our execution context
	        engine.eval("fuse = $domain/scachild::fuse/scachild::components/scachild::fuseIntentHandler;", ctx);
	        engine.eval("maxRequestsNumber = $fuse/scaproperty::trippedFuse;", ctx);
	        engine.eval("set-value($trippedFuse, false)", ctx);
	        System.out.println("Done, fuse rearmed !");		
			response = "Intent properties succesfully updated !";
		}
		catch(Exception ex){
			ex.printStackTrace();
			response = "An error occurs while trying to update intent properties !";
			System.out.println(response);
		}
		return response;
	}

}
