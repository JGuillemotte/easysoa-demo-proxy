This is a little webscript for Alfresco share.

This webscript send a simple "hello world" like GET HTTP request and then display the server JSON response.
It can work with the nodeJsHelloServer example.
---

To run this example

1. copy the following files in the alfresco webscript share folder (eg : /opt/alfresco-3.4.d/tomcat/webapps/share/WEB-INF/classes/alfresco/site-webscripts/org/alfresco/components/dashlets) :

- nodejs-hello.get.desc.xml
- nodejs-hello.get.html.ftl
- nodejs-hello.get.js

2. Start your alfresco server
3. Go to this page (http://localhost:8080/share/service/index) and search for the nodejs-hello service.  

---

Alfresco share is required to run this example !