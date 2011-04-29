package frascatiSwingClient.com.openwide.sca.frascati.swing.client.messages;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.Set;

/**
 * Simple HTTP Server Handler example that demonstrates how easy it is to apply
 * the Http Server built-in to Sun's Java SE 6 JVM.
 */
public class HTTPListener implements HttpHandler {

	/**
	 * Implementation of only required method expected of an implementation of
	 * the HttpHandler interface.
	 * 
	 * @param httpExchange
	 *            Single-exchange HTTP request/response.
	 */
	public void handle(HttpExchange httpExchange) throws IOException {
		System.out.println("Request method : "
				+ httpExchange.getRequestMethod());
		System.out.println("Listener message : "
				+ httpExchange.getRequestBody().toString());
		System.out.println("Conversion : "
				+ convertStream(httpExchange.getRequestBody()));
		Set<String> keys = httpExchange.getHttpContext().getAttributes()
				.keySet();
		if (keys != null) {
			System.out.println("Keys.size : " + keys.size());
			for (String key : keys) {
				System.out.println("Key : " + key);
			}
		}
		final String response = "Message transmitted";
		httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,
				response.length());
		final OutputStream os = httpExchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
		System.out.println("Listener fin traitement");
	}

	private String convertStream(InputStream is) throws IOException {
		StringWriter writer = new StringWriter();
		InputStreamReader streamReader = new InputStreamReader(is);
		BufferedReader buffer = new BufferedReader(streamReader);
		String line = "";
		while (null != (line = buffer.readLine())) {
			writer.write(line);
		}
		return writer.toString();
	}
}
