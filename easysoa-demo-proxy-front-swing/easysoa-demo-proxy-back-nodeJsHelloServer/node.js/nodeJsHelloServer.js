var sys = require('sys');
var net = require('net');
var http = require('http');

var server = http.createServer(function(req, res){
 console.log("request method : " + req.method);
 console.log("request url : " + req.url);
 console.log("request headers : " + req.headers);
 var params = require('url').parse(req.url, true);
 var user = params.query.user;
 console.log('"User" parameter value : ' + user);
 var jsonMessage;
 if(user != ""){ // ajouter undefined
     jsonMessage = '{"message" : "Hello from Node.js server !", "userName" : "' + user + '"}';
 } else {
     jsonMessage = '{"message" : "Hello !", "userName" : "Not specified"}';
 }
 res.writeHead(200, {'Content-Type': 'application/json'});
 res.end(jsonMessage);
 console.log('JSON Message sent !');
});

// Port 7001 to run with Frascati SCA Proxy
console.log('Server running at http://127.0.0.1:7001/');
server.listen(7001, "localhost");
