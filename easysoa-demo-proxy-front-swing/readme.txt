A light swing client demo for Frascati.

This project require the following server to run correctly !

- easysoa-demo-proxy-back-nodeJsHelloServer (started)
- easysoa-demo-proxy-core-nodeJsEventDispatcherServer (started)
- easysoa-demo-proxy-core-scaProxy (started)

The GUI contains several fields and buttons :

- Field "User parameter" : Can be used to specify an user name. This parameter is optional.
- Field "Server response" : Read only, display the server response. 
- Button "Send request" : Send the request to the server.

- Field "Max request number" : "Max request number" accepted by the proxy in a given period of time.
- Button "Hot update" : Update the "Max request number" parameter.
- Field "Fuse intent message" : Read only. Display the fuse intent status. 
- Button "Rearm fuse" : Rearm the fuse intent.

Remark : in this version, the "Hot update"  and "Rearm fuse" buttons doesn't work.

---

No installation required.

- Just open the project in Eclipse. 
- Build the project with maven (mvn clean install).
- Run the project as a Java application. The main method is in the class "frascatiSwingClient.com.openwide.sca.frascati.swing.client.ScaSwingClient".

---
