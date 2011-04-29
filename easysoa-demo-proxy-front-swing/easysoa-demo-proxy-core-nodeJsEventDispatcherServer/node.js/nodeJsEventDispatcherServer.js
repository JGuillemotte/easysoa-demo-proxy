var sys = require('sys');
var net = require('net');
var http = require('http');

Array.prototype.remove = function(e) {
    for (var i = 0; i < this.length; i++) {
        if (e == this[i]) { return this.splice(i, 1); }
    }
};

var subscribers = [];

// Subscriber
function Subscriber(socket, port) {
    this.socket = socket;
	this.port = port;
}

// Add subscriber
function addSubscriber(socket, port){
	var subscriber = new Subscriber(socket, port);
    subscribers.push(subscriber);
	console.log('new subscriber added to list !');
	console.log(subscribers.length + ' subscribers in list !');
}

// Remove subscriber
function removeSubscriber(socket){
    subscribers.forEach(function(sub) {
        if(sub.socket == socket){
	    	subscribers.remove(sub);
		}
    });
	console.log('subscriber removed from list !');
	console.log(subscribers.length + ' subscribers in list !');
}

// Publish message
function publishMessage(message){
	console.log('Message to send to subscribers : ' + message);
    subscribers.forEach(function(sub) {
		try{			
			console.log('Sending message to : ' + sub.socket.remoteAddress + " : " + sub.port);
			var remote_client = http.createClient(sub.port, sub.socket.remoteAddress);
		    var request = remote_client.request("GET", "/");
			request.on('response', function (response) {
				response.on('data', function (chunk) {
				    console.log('BODY: ' + chunk);
		  		});
			});
			request.end(message, "UTF-8");
		}
		catch(error){
			console.log("A problem occurs, message not send ! " + error);			
		}
    });
	console.log('send message to all subscribers !');
}

// Server creation
var server = http.createServer(function(req, res) { 
    // Get action
 	var params = require('url').parse(req.url, true);
	var action = params.query.action;
	console.log("action : " + action);
    if(action == "subscribe"){
		//Add a new subscriber to the list
		var port = params.query.port;
		console.log("port : " + port);
		addSubscriber(req.connection, port);
 		res.writeHead(200, {'Content-Type': 'text/plain'});
		res.end("new subscriber added to list !");   	
    }
	else if(action == "unsubscribe"){
		// Remove the subscriber from the list
		removeSubscriber(req.connection);
 		res.writeHead(200, {'Content-Type': 'text/plain'});
		res.end("subscriber removed from list !");
	}
	else if(action == "publish"){
		// Send message to all subscribers
		publishMessage(params.query.message);		
	}
});

console.log('Event Dispatcher Server running at http://127.0.0.1:7002/');
server.listen(7002, "localhost");
