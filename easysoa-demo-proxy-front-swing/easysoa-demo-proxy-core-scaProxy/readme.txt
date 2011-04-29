Proxy Core : a static proxy demo developed as a Frascati application.

Frascati 1.2 and above is required to run this software.

Remark : This proxy works only with REST requests and the addresses of remote servers are hard coded !

---

Tested with Frascati 1.2.

Installation instructions :

- Build the proxy core project with "mvn clean install"
- Copy the proxy core scaProxy jar (scaProxy-1.0-SNAPSHOT.jar) in the sca-apps folder

- Create an 'intent' folder in the "sca-apps" folder.
- Copy in this folder the intents required for this example to run (only the class and the resources files must be copied, not the jar file) :
	*	Log intent
	*	Fuse intent
	*	Frascati-debug intent
- Copy the intents jar's in the Frascati lib folder.
- Go back to the "sca-apps" folder.

- To launch the server, use the following command :
	*	bash:#  ../../bin/frascati run scaProxyTest -libpath ../scaProxy-1.0-SNAPSHOT.jar