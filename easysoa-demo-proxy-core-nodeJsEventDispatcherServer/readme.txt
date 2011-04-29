This is a little Node.js event dispatcher demo server .

A list of subscribers is maintained by the server. Each time a new request to publish a message is received, the message is transmitted to all subscribers. 
The subscribers must be registered on the server to receive messages.

Remark : There is a problem on the unregistration of the subscribers. A solution would be to give a unique id each time a new subscriber register on the server.  

---

To launch the server, use the following command :

-bash:# node nodeJsEventDispatcher.js

---

Node.js must be installed on your computer ! 
Follow the installation instructions at https://github.com/joyent/node/wiki/Installation