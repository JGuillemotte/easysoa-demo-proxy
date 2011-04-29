package frascatiSwingClient.com.openwide.sca.frascati.swing.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.swing.SwingUtilities;

import com.sun.net.httpserver.HttpServer;

import frascatiSwingClient.com.openwide.sca.frascati.swing.client.messages.EventDispatcher;
import frascatiSwingClient.com.openwide.sca.frascati.swing.client.messages.HTTPListener;
import frascatiSwingClient.com.openwide.sca.frascati.swing.client.ui.MainFrame;

/**
 * SCA Swing Client
 * 
 */
public class ScaSwingClient {

	public static final int PORT = 7003;  
	public static final int BACKLOG = 0;
	public static final String URL_CONTEXT = "/";  	
	
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("SCA Swing Client starting !");

		// Register as subscriber on event dispatcher
		EventDispatcher.subscribe();

		HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress(PORT), BACKLOG);
			server.createContext(URL_CONTEXT, new HTTPListener());  
			server.setExecutor(null); // allow default executor to be created  
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
 			
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame mf = new MainFrame();
				mf.setVisible(true);
			}
		});
	}	

}

